package formbind.board.service;

import java.util.List;
import java.util.Map;

/**
 * BoardService interface.
 */
public interface BoardService {

	public void create(Map<String, Object> targetMap) throws Exception;

	public void update(Map<String, Object> targetMap) throws Exception;

	public void remove(Map<String, Object> targetMap) throws Exception;

	public Map<String, Object> get(Map<String, Object> targetMap) throws Exception;

	List<Map<String, Object>> getPagingList(Map<String, Object> targetMap) throws Exception;   
}
