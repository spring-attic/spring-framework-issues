package org.springframework.issues.dao;

import org.springframework.issues.datamodel.TestData;

public interface TestDAO {
	public TestData saveTestData(TestData entity);

	public TestData loadTestDataById(Long id);
}
