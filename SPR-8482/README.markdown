A demonstration of Spring 3.1's new CommandLinePropertySource support.

The simple main method in Spr8482Main wires up a Spring ApplicationContext with a single
'Greeter' bean having a sayGreeting() method.

You'll notice that Greeter uses @Inject to get hold of the Spring Environment object,
and when sayHello() is called, tries to look up a property from the environment named
'greeting'.  The environment may contain any number of property sources, and by default
looks to the system properties and system enviroment variables.

Try running this main method as-is. You'll see that the 'Greeter' bean says "Welcome!",
as a default greeting when no 'greeting' property is present.

Try running the class with a command line argument of "--greeting='Wilkommen'", and
you'll see that the greeting changes. This is because a CommandLinePropertySource has
been configured and added to the Spring application context's environment.  You can do
this from within Eclipse using the Run->Run Configurations menu, or from the Maven
command line with the following:

```bash
$ mvn package exec:java -Dexec.mainClass="org.springframework.issues.Spr8482Main" -Dexec.args="--greeting=Wilkommen"
```

Now, try leaving the --greeting command line argument in place while also setting a
'greeting' environment variable when running the application:

```bash
$ greeting=Bienvenidos  mvn package exec:java -Dexec.mainClass="org.springframework.issues.Spr8482Main" -Dexec.args="--greeting=Wilkommen"
```

You'll notice that 'Bienvenidos' is now the greeting.  This is because the system
environment property source has higher precedence in the application context's
Environment than does our command-line property source. Notice how the command line
property source was added with the #getLast() method?  Try making this #getFirst() and
see what happens!

As an additional excercise, consider replacing the JOptCommandLinePropertySource with
Spring's own SimpleCommandLinePropertySource.  See the Javadoc for details, but the
idea with that variant is to provide the simplest possible approach to parsing
command line opts.

Enjoy!
