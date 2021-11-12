package com.black.simple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大的元素
 * 没有重复元素的两个数组nums1和nums2，其中nums1是2的子集
 * 找出nums1每个数字对应nums2同样位置右边第一个比他大的数字并返回
 * nums1 =[4,1,2] nums2 = [1,3,4,2] 输出[-1,3,-1]
 *
 * @author Citrus
 * @date 2021/10/26 9:22
 */
public class NextGreaterElement {
    /**
     * 暴力解法
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            //对应另一个数组相同数字的后面找
            while (j < m && nums1[i] != nums2[j]) {
                j++;
            }
            while (j < m && nums1[i] >= nums2[j]) {
                j++;
            }
            res[i] = j < m ? nums2[j] : -1;
        }
        return res;
    }

    /**
     * 单调栈
     * 对nums2进行逆序遍历
     * hashMap存储结果，毕竟是不重复的元素
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> resMap = new HashMap<>(n);
        for (int i = m - 1; i >= 0; i--) {
            int x = nums2[i];
            while (!deque.isEmpty() && deque.peekLast() <= x) {
                deque.pollLast();
            }
            resMap.put(x, deque.isEmpty() ? -1 : deque.peekLast());
            deque.addLast(x);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = resMap.get(nums1[i]);
        }
        return res;
    }
}
