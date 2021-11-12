package com.black.medium;

import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值
 *
 * @author Citrus
 * @date 2021/8/27 13:46
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    /**
     * 小顶堆（minHeap）：存储所有元素中较大的一半，堆顶存储的是其中最小的数。
     * 大顶堆（maxHeap）：存储所有元素中较小的一半，堆顶存储的是其中最大的数
     */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        //从大到小逆序排序
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    /**
     * 从数据流中添加一个整数到数据结构中。
     *
     * @param num
     */
    public void addNum(int num) {
        //小顶堆存储的是比较大的元素，num比较大元素中最小的还大，所以，进入minHeap
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        } else {
            maxHeap.offer(num);
            //保证小顶堆要多一个元素
            if (maxHeap.size() - minHeap.size() > 0) {
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    /**
     * 返回目前所有元素的中位数。
     *
     * @return
     */
    public double findMedian() {
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
