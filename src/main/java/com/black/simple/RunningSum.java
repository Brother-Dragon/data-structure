package com.black.simple;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]
 * @author Citrus
 * @date 2021/8/28 9:15
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 3;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 10;
        nums[4] = 1;
        System.out.println(Arrays.toString(runningSum(nums)));
    }
    public static int[] runningSum(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[left];
            left = i;
        }
        return nums;
    }
}
