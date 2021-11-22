package com.black.medium;

import java.util.Random;

/**
 * 打乱数组
 *
 * @author Citrus
 * @date 2021/11/22 8:52
 */
public class ShuffleList {
    int[] nums;
    int n;
    Random random = new Random();

    public ShuffleList(int[] nums) {
        this.nums = nums;
        n = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            // 交换
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }

    void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
