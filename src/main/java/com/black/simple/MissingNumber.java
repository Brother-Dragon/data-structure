package com.black.simple;

/**
 * @author 菠萝凤梨
 * @date 2021/11/6 10:35
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int ans = 0;
        for (int i = 0; i <= length; i++) {
            ans ^= i;
        }
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
