package com.black.simple;

/**
 * @author Citrus
 * @date 2021/8/31 17:09
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
