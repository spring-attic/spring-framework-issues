See src/test/java/com/demo/IntrospectionJavaTests.java.

The test will fail if it includes a method like this:
	
static GrailsWebRequest getMessageSource() {
    return null;
}

The return type appears to be relevant.  For example, if the return type is
MessageSource, the test passes.  If the return type is GrailsWebRequest and the
method name is getGrailsWebRequest or getFoo, the test passes.


	
