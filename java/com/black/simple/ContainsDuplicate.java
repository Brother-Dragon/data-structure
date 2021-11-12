package com.black.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一组数中是否存在重复数
 *
 * @author Citrus
 * @date 2021/10/22 16:28
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
