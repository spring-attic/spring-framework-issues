package formbind.board.web;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.anyframe.datatype.HashMapModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import formbind.board.service.BoardService;

/**
 * Controller for Board
 */
@Controller
@RequestMapping("/board.do")
public class BoardController {
	
	@Inject
	@Named("boardService")
    private BoardService boardService;

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(params = "method=createView") 
    public String createView(@ModelAttribute("board") HashMapModel hashMapModel) throws Exception {   
        return "generation/board/form";                   
    }

    @RequestMapping(params = "method=create")  
    public String create(@ModelAttribute("board") HashMapModel hashMapModel, BindingResult results, SessionStatus status) throws Exception {
    	
    	if (results.hasErrors()) {
			return "generation/board/form";
		}
		
        boardService.create(hashMapModel.getMap());    
        status.setComplete();
            
        return "redirect:/board.do?method=list";        
    }

    @RequestMapping(params = "method=get")    
    public String get(@ModelAttribute("board") HashMapModel hashMapModel) throws Exception { 	
        Map<String, Object> resultMap = boardService.get(hashMapModel.getMap());
       	hashMapModel.setMap(resultMap);   	               	                	

       return "generation/board/form";
    }
    
    @RequestMapping(params = "method=list")  
    public String list(@ModelAttribute("search") HashMapModel hashMapModel, Model model, HttpServletRequest request) throws Exception {
    	Map<String, Object> map = hashMapModel.getMap();
    	
        List<Map<String, Object>> boardList = boardService.getPagingList(map);
        model.addAttribute("boardList", boardList);
                
        return "generation/board/list"; 
    }
}
