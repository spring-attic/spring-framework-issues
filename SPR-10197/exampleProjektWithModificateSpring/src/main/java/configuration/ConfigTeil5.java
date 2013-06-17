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
public class ConfigTeil5 {

	@Autowired private DIObjekt1 diObjekt1;
	@Autowired private DIObjekt2 diObjekt2;
	@Autowired private DIObjekt3 diObjekt3;
	
	@Bean public Service1 service50(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service51(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service52(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service53(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service54(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service55(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service56(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service57(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service58(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service59(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }

}
