package com.black.simple;

/**
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和 。
 *
 * @author Citrus
 * @date 2021/8/30 10:37
 */
public class SumOddLengthSubArrays {
    public int sumOddLengthSubArrays(int[] arr) {
        int length = arr.length;
        int ans = 0;
        int[] preSum = new int[length + 1];
        //得到前缀和
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        for (int start = 0; start < length; start++) {
            for (int j = 1; start + j < length; j += 2) {
                int end = start + j - 1;
                ans += preSum[end + 1] - preSum[start];
            }
        }
        return ans;
    }
}
