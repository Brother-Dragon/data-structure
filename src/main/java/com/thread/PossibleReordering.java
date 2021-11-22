package com.thread;

/**
 * 测试下指令重排序和内存可见性
 *
 * @author 菠萝凤梨
 * @date 2021/11/20 10:49
 */
public class PossibleReordering {
    static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
        });
        Thread other = new Thread(() -> {
            b = 1;
            y = a;
        });
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("(" + x + "," + y + ")");
    }
}
