package com.thread;

/**
 * 线程通信2
 *
 * @author 菠萝凤梨
 * @date 2021/11/21 21:42
 */
public class MonitorSignal {
}

class ThreadD extends Thread {
    int count;
    MonitorSignal monitorSignal;
    public ThreadD(MonitorSignal monitorSignal) {
        this.monitorSignal = monitorSignal;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (monitorSignal) {
            monitorSignal.notify();//计算完notify唤醒因调用wait而挂起的线程
        }
    }
}
class ThreadC extends Thread {
    MonitorSignal monitorSignal;
    ThreadD threadD;
    public ThreadC (MonitorSignal monitorSignal, ThreadD threadD) {
        this.monitorSignal = monitorSignal;
        this.threadD = threadD;
    }

    @Override
    public void run() {
        synchronized (monitorSignal) {
            try {
                monitorSignal.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程D的执行结果为:" + threadD.count);
        }
    }

    public static void main(String[] args) {
        MonitorSignal monitorSignal = new MonitorSignal();
        ThreadD threadD = new ThreadD(monitorSignal);
        ThreadC threadC = new ThreadC(monitorSignal, threadD);
        threadC.start();
        threadD.start();
    }
}
