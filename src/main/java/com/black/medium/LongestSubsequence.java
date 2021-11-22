package com.black.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长定差子序列
 * @author 菠萝凤梨
 * @date 2021/11/5 21:06
 */
public class LongestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}
