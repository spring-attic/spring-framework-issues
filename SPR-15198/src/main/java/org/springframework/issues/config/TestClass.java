package org.springframework.issues.config;

public class TestClass {

	public static final String ID = "Testclass";
	
	static int i=0;
	static long latestHit = System.currentTimeMillis();;
	
	String payload;
	
	public TestClass() {
		this("slow");
	}
	
	public TestClass(String p) {
		this.payload = p;
		// Some time measurement for benchmarking
		i++;
		if (i % 1000 == 0) {
			long diff = System.currentTimeMillis() - latestHit;
			System.err.println("hit: " + i + "(" +  diff +") " + this.getPayload());
			latestHit = System.currentTimeMillis();
		}
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
