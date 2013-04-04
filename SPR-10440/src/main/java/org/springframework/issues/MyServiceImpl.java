package org.springframework.issues;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.repo.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MessageRepository messageRepository;

	@Transactional
	public List<Message> someTransactionalMethod() {
		return messageRepository.findAll();
	}

}
