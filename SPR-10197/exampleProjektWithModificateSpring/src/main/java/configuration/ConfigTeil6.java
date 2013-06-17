package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import beans.DIObjekt1;
import beans.DIObjekt2;
import beans.DIObjekt3;
import beans.Service1;
import beans.Service1Impl;
import beans.Service2;
import beans.Service2Impl;
import beans.Service3;
import beans.Service3Impl;
import beans.Service4;
import beans.Service4Impl;


@Configuration
public class ConfigTeil6 {

	@Autowired private DIObjekt1 diObjekt1;
	@Autowired private DIObjekt2 diObjekt2;
	@Autowired private DIObjekt3 diObjekt3;
	
	@Bean public Service1 service60(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service61(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service62(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service63(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service64(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service65(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service66(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service67(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service68(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service69(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	}
