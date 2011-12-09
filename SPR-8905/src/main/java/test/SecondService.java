package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondService extends AbstractService<SecondDao> {

	@Override
	@Autowired
	public void setDao(SecondDao dao) {
		this.dao = dao;
	}

}
