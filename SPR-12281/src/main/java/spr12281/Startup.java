package spr12281;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

public class Startup
{
	private static final String	PATH	= "../SPR-12281/src/main/webapp/";

	public static void main ( String[] args ) throws Exception
	{
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir("./target/tomcat");
		tomcat.setPort(8080);
		tomcat.addWebapp("", new File(PATH).getAbsolutePath());
		tomcat.start();
		tomcat.getServer().await();
	}
}
