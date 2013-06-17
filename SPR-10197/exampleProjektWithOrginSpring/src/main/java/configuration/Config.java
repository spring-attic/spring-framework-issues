package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
//@Lazy(true)
public class Config {

	@Autowired private DIObjekt1 diObjekt1;
	@Autowired private DIObjekt2 diObjekt2;
	@Autowired private DIObjekt3 diObjekt3;
	
	@Bean
	public Service1 service5(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service1(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service6(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service7(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service8(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service9(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service10(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service11(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service12(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service13(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service14(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service15(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service16(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service17(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service18(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service19(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service1 service20(){
		Service1Impl service1 = new Service1Impl();
		service1.setDIObjekt(diObjekt1);
		return service1;
	}
	
	@Bean
	public Service2 service2(){
		Service2Impl service2 = new Service2Impl();
		service2.setDIObjekt(diObjekt2);
		return service2;
	}
	
	@Bean
	public Service3 service3(){
		Service3Impl service3 = new Service3Impl();
		service3.setDIObjekt(diObjekt1);
		return service3;
	}
	
	@Bean
	public Service4 service4(){
		Service4Impl service4 = new Service4Impl();
		service4.setDIObjekt(diObjekt3);
		return service4;
	}
	
	@Bean public Service1 service22(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service23(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service24(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service25(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service26(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service27(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service28(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service29(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service30(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service31(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service32(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service33(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service34(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service35(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service36(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service37(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service38(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service39(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service40(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service41(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service42(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service43(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service44(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service45(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service46(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service47(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service48(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service49(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
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
	@Bean public Service1 service70(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service71(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service72(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service73(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service74(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service75(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service76(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service77(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service78(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service79(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service80(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service81(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service82(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service83(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service84(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service85(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service86(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service87(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service88(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service89(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service90(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service91(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service92(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service93(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service94(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service95(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service96(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service97(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service98(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }
	@Bean public Service1 service99(){   Service1Impl Service1 = new Service1Impl();   Service1.setDIObjekt(diObjekt1);   return Service1;  }


}
