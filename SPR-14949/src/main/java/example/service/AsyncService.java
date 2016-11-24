package example.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

public interface AsyncService {

	@Async
    Future<String> getResponse() throws Exception;

}
