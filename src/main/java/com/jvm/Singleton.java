package com.jvm;

/**
 * 单例
 * @author 菠萝凤梨
 * @date 2021/11/21 20:44
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance() {
        if (singleton == null) { // 1
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton(); // 2
                }
            }
        }
        return singleton;
    }
}
