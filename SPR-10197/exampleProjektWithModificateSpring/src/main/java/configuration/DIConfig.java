package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import beans.DIObjekt1;
import beans.DIObjekt2;
import beans.DIObjekt3;


//@Lazy(true)
public class DIConfig {

	@Bean
	public DIObjekt1 diObjekt1(){
		return new DIObjekt1();
	}
	
	@Bean
	public DIObjekt2 diObjekt2(){
		return new DIObjekt2();
	}
	
	@Bean
	public DIObjekt3 diObjekt3(){
		return new DIObjekt3();
	}
}
