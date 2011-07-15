package poc.configurable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
class Entity {

	@Autowired
	private Service service;

	Service getService(){
		return service;
	}

}
