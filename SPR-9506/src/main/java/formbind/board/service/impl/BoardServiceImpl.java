package formbind.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import formbind.board.service.BoardService;

/**
 * BoardService implementation class
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Inject
	@Named("boardDao")
    BoardDao boardDao;
    
    public void create(Map<String, Object> targetMap) throws Exception{
        this.boardDao.create(targetMap);	
    }

    public void update(Map<String, Object> targetMap) throws Exception{
        this.boardDao.update(targetMap);
    }

    public void remove(Map<String, Object> targetMap) throws Exception{
        this.boardDao.remove(targetMap);
    }

    public Map<String, Object> get(Map<String, Object> targetMap) throws Exception{
        return this.boardDao.get(targetMap);
    }

	public List<Map<String, Object>> getPagingList(Map<String, Object> targetMap) throws Exception {
		return this.boardDao.getPagingList(targetMap);
	}      
}
