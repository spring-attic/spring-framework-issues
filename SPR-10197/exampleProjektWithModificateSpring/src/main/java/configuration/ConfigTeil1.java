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
public class ConfigTeil1 {

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

}
