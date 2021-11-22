package com.black.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐子序列
 *
 * @author 菠萝凤梨
 * @date 2021/11/20 21:22
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                ans = Math.max(ans, map.get(num) + map.get(num - 1));
            }
        }
        return ans;
    }
}
