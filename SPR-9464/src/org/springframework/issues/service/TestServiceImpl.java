package org.springframework.issues.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.dao.TestDao;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;

	@Override
	public int queryDummyValue() {
		return testDao.queryDummyValue();

	}
}
