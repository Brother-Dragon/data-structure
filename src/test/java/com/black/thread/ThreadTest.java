package com.black.thread;

import com.thread.RunObj;
import org.junit.Test;

/**
 * @author Citrus
 * @date 2021/11/18 9:57
 */
public class ThreadTest {
    /**
     * wait()使当前线程进入等待状态。直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。
     *
     * @throws Exception
     */
    @Test
    public void testWait() throws Exception {
        final RunObj runObj = new RunObj();
        Runnable runA = () -> {
            try {
                String item = runObj.removeElement();
                System.out.println(item);
            } catch (InterruptedException ix) {
                System.out.println("Interrupted Exception!");
            } catch (Exception e) {
                System.out.println("Exception throw.");
            }
        };
        Runnable runB = () -> runObj.addElement("Test!");
        try {
            Thread t1 = new Thread(runA, "T1");
            t1.start();
            Thread.sleep(500);
            Thread t2 = new Thread(runA, "T2");
            t2.start();
            Thread.sleep(500);
            Thread t3 = new Thread(runB, "T3");
            t3.start();
            Thread.sleep(1000);
            t1.interrupt();
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
