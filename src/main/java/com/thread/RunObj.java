package com.thread;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Citrus
 * @date 2021/11/18 9:59
 */
public class RunObj extends Object {

    private final List synList;

    public RunObj() {
        //新建个同步列表
        synList = Collections.synchronizedList(new LinkedList<>());
    }

    /**
     * 删除列表中的数据
     *
     * @return
     * @throws InterruptedException
     */
    public String removeElement() throws InterruptedException {
        synchronized (synList) {
            while (synList.isEmpty()) {
                System.out.println("List is empty...");
                //holdsLock-当且仅当对象obj的监视器被某条线程持有的时候返回true
                System.out.println(Thread.holdsLock(synList));
                synList.wait();
                System.out.println("synList is waiting...");
            }
            return (String) synList.remove(0);
        }
    }

    public void addElement(String element) {
        System.out.println("Opening...");
        synchronized (synList) {
            synList.add(element);
            System.out.println("New Element:'" + element + "'");
            synList.notifyAll();
            System.out.println("notifyAll called!");
        }
        System.out.println("closing...");
    }
}
