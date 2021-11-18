package com.black.medium;

/**
 * 盛最多水的容器，类似接雨水，都是双指针，左右指针，谁小谁以当前方向前进
 *
 * @author Citrus
 * @date 2021/11/9 16:10
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length, ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
