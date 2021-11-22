package com.thread;

/**
 * 线程通信1
 *
 * @author 菠萝凤梨
 * @date 2021/11/21 21:27
 */
public class ThreadSignal {
    private boolean hasDataToProcess;

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }

    public synchronized boolean hasDataToProcess() {
        return this.hasDataToProcess;
    }
}
class ThreadA extends Thread {
    ThreadSignal threadSignal;
    ThreadB threadB;

    public ThreadA(ThreadSignal threadSignal, ThreadB threadB) {
        this.threadSignal = threadSignal;
        this.threadB = threadB;
    }

    @Override
    public void run() {
        while (true) {
            if (threadSignal.hasDataToProcess()) {
                System.out.println("线程B的计算结果为:" + threadB.count);
                break;
            }
        }
    }

    public static void main(String[] args) {
        ThreadSignal threadSignal = new ThreadSignal();
        ThreadB threadB = new ThreadB(threadSignal);
        ThreadA threadA = new ThreadA(threadSignal, threadB);
        threadB.start();
        threadA.start();//A会一直等B把信号量设置为true才能执行，但他一直在消耗CPU的资源，忙等
    }
}
class ThreadB extends Thread {
    int count;
    ThreadSignal threadSignal;

    public ThreadB(ThreadSignal threadSignal) {
        this.threadSignal = threadSignal;
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
        threadSignal.setHasDataToProcess(true);
    }
}
