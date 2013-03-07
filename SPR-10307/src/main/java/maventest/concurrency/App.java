
package maventest.concurrency;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	private static final int NUMBER_OF_THREAD = 2;

	private class Appl implements Runnable {

		public AnnotationConfigApplicationContext applicationContext;

		public Appl(AnnotationConfigApplicationContext applicationContext) {
			this.applicationContext = applicationContext;
		}

		public void run() {
			this.applicationContext.refresh();
		}
	}

	public void run() throws InterruptedException {
		AnnotationConfigApplicationContext[] contexts = new AnnotationConfigApplicationContext[App.NUMBER_OF_THREAD];
		Thread[] threads = new Thread[App.NUMBER_OF_THREAD];

		for (int i = 0; i < App.NUMBER_OF_THREAD; i++) {
			contexts[i] = new AnnotationConfigApplicationContext();
			contexts[i].register(BeansDefinition.class);
			threads[i] = new Thread(new Appl(contexts[i]));
		}

		for (int i = 0; i < App.NUMBER_OF_THREAD; i++) {
			threads[i].start();
		}

		for (int i = 0; i < App.NUMBER_OF_THREAD; i++) {
			threads[i].join();
		}

		for (int i = 0; i < App.NUMBER_OF_THREAD; i++) {
			TheBean bean1 = contexts[i].getBean(TheBean.class);
			for (int j = i + 1; j < App.NUMBER_OF_THREAD; j++) {
				TheBean bean2 = contexts[j].getBean(TheBean.class);
				if (bean1 == bean2) {
					throw new RuntimeException("Error, bean from context " + i
							+ " is shared with bean from context " + j + ". (" + bean1
							+ "," + bean2 + ")");
				}
			}
		}

		for (int i = 0; i < App.NUMBER_OF_THREAD; i++) {
			contexts[i].close();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			App app = new App();
			app.run();
		}
	}
}
