package org.springframework.issues.service;

import org.springframework.issues.datamodel.TestData;

public interface TestService {
	public TestData saveTestData(TestData entity);

	public TestData loadTestDataById(Long id);
}
