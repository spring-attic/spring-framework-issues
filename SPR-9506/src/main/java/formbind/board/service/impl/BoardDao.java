package formbind.board.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

/**
 * Dummy BoardDao class
 *
 */
@Repository("boardDao") 
public class BoardDao {
	
	private List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
	
	@PostConstruct
	public void setBoardListData(){
		
		Map<String, Object> b = new HashMap<String, Object>();
		b.put("postId", "POST-0001");
		b.put("contents", "My Contents");
    	b.put("regDate", "2012-06-19");
    	b.put("regId", "admin");
    	b.put("title", "My Title");
		
    	boardList.add(b);
	}
	
    public void create(Map<String, Object> targetMap) throws Exception {
    	boardList.add(targetMap);
    }

    public void update(Map<String, Object> targetMap) throws Exception {
    	throw new UnsupportedOperationException();
    }

    public void remove(Map<String, Object> targetMap) throws Exception {
    	throw new UnsupportedOperationException();
    }

    public Map<String, Object> get(Map<String, Object> targetMap) throws Exception {
    	String postId = (String)targetMap.get("postId");
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	for (Map<String, Object> b : boardList){
    		if (b.get("postId").equals(postId)){
    			resultMap.put("postId", b.get("postId"));
    			resultMap.put("contents", b.get("contents"));
    			resultMap.put("regDate", b.get("regDate"));
    			resultMap.put("regId", b.get("regId"));
    			resultMap.put("title", b.get("title"));
    			break;
    		}
    	}
    	
        return resultMap;
    }

    public List<Map<String, Object>> getPagingList(Map<String, Object> targetMap) throws Exception {
        return boardList;
	}
}
