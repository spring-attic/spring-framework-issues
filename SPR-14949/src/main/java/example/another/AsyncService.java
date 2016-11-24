package example.another;

import java.util.concurrent.Future;

public interface AsyncService {

    Future<String> getResponse() throws Exception;

}
