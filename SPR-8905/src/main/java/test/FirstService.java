package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService extends AbstractService<FirstDao> {

	@Override
	@Autowired
	public void setDao(FirstDao dao) {
		this.dao = dao;
	}

}
