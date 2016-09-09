package spr14673;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ShutdownHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	private Server server;

	public static void main(String[] args) throws Exception {
		JettyServer jettyServer = new JettyServer();
		jettyServer.start();
		jettyServer.join();
	}

	public void start() throws Exception {
		ResourceCollection resourceCollection = new ResourceCollection(new String[] { "src/main/webapp" });

		server = new Server(8080);

		WebAppContext webApp = new WebAppContext();
		webApp.setContextPath("/");
		webApp.setDefaultsDescriptor("org/eclipse/jetty/webapp/webdefault.xml");
		webApp.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
		webApp.setInitParameter("org.eclipse.jetty.websocket.jsr356", "true");
		webApp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
		webApp.setBaseResource(resourceCollection);

		List<Resource> dirs = new ArrayList<>();
		Resource logbackResource = Resource.newClassPathResource("logback.xml");
		File logbackFile = logbackResource.getFile();
		File classesFolderFile = logbackFile.getParentFile();
		Resource classesResource = Resource.newResource(classesFolderFile);
		dirs.add(classesResource);
		webApp.getMetaData().setWebInfClassesDirs(dirs);

		String[] configurationClasses = WebAppContext.getDefaultConfigurationClasses();
		List<String> plusConfigurationClasses = new ArrayList<String>(configurationClasses.length + 3);
		for (String configurationClass : configurationClasses) {
			plusConfigurationClasses.add(configurationClass);
		}
		plusConfigurationClasses.add("org.eclipse.jetty.annotations.AnnotationConfiguration");
		plusConfigurationClasses.add("org.eclipse.jetty.plus.webapp.EnvConfiguration");
		plusConfigurationClasses.add("org.eclipse.jetty.plus.webapp.PlusConfiguration");

		webApp.setConfigurationClasses(plusConfigurationClasses.toArray(new String[0]));

		ShutdownHandler shutdown = new ShutdownHandler("down", true, true);
		shutdown.setSendShutdownAtStart(true);

		HandlerList handlerList = new HandlerList();
		handlerList.addHandler(shutdown);
		handlerList.addHandler(webApp);

		server.setHandler(handlerList);
		webApp.setThrowUnavailableOnStartupException(true);

		try {
			server.start();
		} catch (Exception e) {
			server.stop();
			e.printStackTrace();
		}
	}

	public void join() throws Exception {
		try {
			server.join();
		} catch (InterruptedException e) {
			server.stop();
			e.printStackTrace();
		}
	}
	
	public void stop() throws Exception {
		try {
			server.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
