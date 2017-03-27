package example.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class DefaultAsyncService implements AsyncService {

	public static final Logger log = LoggerFactory.getLogger(DefaultAsyncService.class);

	@Override
	public Future<String> getResponse() throws Exception {
		log.info("get in service");
		return new AsyncResult<String>("result in " + Thread.currentThread().getName() + " thread");
	}
}
