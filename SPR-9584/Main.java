import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;

public class Main {

    public static void main(String[] args) {
        int threadCount = Integer.parseInt(args[0]);

        final Object lock = new Object();

        for(int i=0; i<threadCount; i++) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (lock) {
                        try { lock.wait(); } catch(InterruptedException ignore) {}
                    }
                    verifyDescriptors();
                }
            }).start();
        }

        try { Thread.sleep(500); } catch(InterruptedException ignore) {}

        synchronized (lock) {
            lock.notifyAll();
        }
    }

    private static void verifyDescriptors() {
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(Three.class);
        if(pds.length != 9) {
            System.out.println("Fail: " + pds.length);
        }
    }

}
