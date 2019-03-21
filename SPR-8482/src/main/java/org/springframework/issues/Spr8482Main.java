/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.issues;

import javax.inject.Inject;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.JOptCommandLinePropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

/**
 * A demonstration of Spring 3.1's new CommandLinePropertySource support.
 *
 * This simple main method wires up a Spring ApplicationContext with a single 'Greeter'
 * bean having a sayGreeting() method.
 *
 * You'll notice that Greeter uses @Inject to get hold of the Spring Environment object,
 * and when sayHello() is called, tries to look up a property from the environment named
 * 'greeting'.  The environment may contain any number of property sources, and by default
 * looks to the system properties and system enviroment variables.
 *
 * Try running this main method as-is. You'll see that the 'Greeter' bean says "Welcome!",
 * as a default greeting when no 'greeting' property is present.
 *
 * Try running the class with a command line argument of "--greeting='Wilkommen'", and
 * you'll see that the greeting changes. This is because a CommandLinePropertySource has
 * been configured and added to the Spring application context's environment.  You can do
 * this from within Eclipse using the Run->Run Configurations menu, or from the Maven
 * command line with the following:
 *
 *     $ mvn -e exec:java -Dexec.mainClass="org.springframework.issues.Spr8482Main" -Dexec.args="--greeting=Wilkommen"
 *
 * Now, try leaving the --greeting command line argument in place while also setting a
 * 'greeting' environment variable when running the application:
 *
 *     $ greeting=Bienvenidos  mvn -e exec:java -Dexec.mainClass="org.springframework.issues.Spr8482Main" -Dexec.args="--greeting=Wilkommen"
 *
 * You'll notice that 'Bienvenidos' is now the greeting.  This is because the system
 * environment property source has higher precedence in the application context's
 * Environment than does our command-line property source. Notice how the command line
 * property source was added with the #getLast() method?  Try making this #getFirst() and
 * see what happens!
 *
 * As an additional excercise, consider replacing the JOptCommandLinePropertySource with
 * Spring's own SimpleCommandLinePropertySource.  See the Javadoc for details, but the
 * idea with that variant is to provide the simplest possible approach to parsing
 * command line opts.
 *
 * Enjoy!
 *
 * @author Chris Beams
 */
public class Spr8482Main {

	public static void main(String... args) {
		OptionParser parser = new OptionParser();
		parser.accepts("greeting").withRequiredArg();
		OptionSet options = parser.parse(args);
		PropertySource<?> ps = new JOptCommandLinePropertySource(options);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().getPropertySources().addLast(ps);
		ctx.register(Greeter.class);
		ctx.refresh();

		Greeter greeter = ctx.getBean(Greeter.class);
		greeter.sayGreeting();
	}
}


@Component
class Greeter {

	@Inject private Environment env;

	/**
	 * Print out the 'greeting' property if it exists, and otherwise, "Welcome!".
	 */
	public void sayGreeting() {
		System.out.println(env.getProperty("greeting", "Welcome!"));
	}

}
