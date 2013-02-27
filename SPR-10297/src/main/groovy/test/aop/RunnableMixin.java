package test.aop;


public class RunnableMixin implements Runnable {

    @Override
    public void run() {
        System.out.println("RunnableMixin#run()");
    }
}
