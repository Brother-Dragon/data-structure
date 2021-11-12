package com.black.simple;

/**
 * 给你一个有序数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 *
 * @author Citrus
 * @date 2021/8/31 14:17
 */
public class RemoveDuplicates {
    /**
     * 在原基础上进行遍历，采用快慢指针
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
