package com.jvm;

/**
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 新生代5m
 * -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 堆内存10m 也即老年代5m
 * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760  ESS 8：1：1 大对象10m
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC 使用parnew CMS
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log 打印详细的gc日志、打印出来每次GC发生的时间、将gc日志写入一个磁盘文件
 */

/**
 * @author Citrus
 * @date 2021/10/28 14:06
 */
public class Demo1 {
    public static void main(String[] args) {
        byte[] array1 = new byte[4 * 1024 * 1024];
        array1 = null;
        byte[] array2 = new byte[2 * 1024 * 1024];
        byte[] array3 = new byte[2 * 1024 * 1024];
        byte[] array4 = new byte[2 * 1024 * 1024];
        byte[] array5 = new byte[128 * 1024];
        byte[] array6 = new byte[2 * 1024 * 1024];
    }
}


