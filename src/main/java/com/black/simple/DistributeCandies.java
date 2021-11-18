package com.black.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 恰糖果
 *
 * @author 菠萝凤梨
 * @create 2021/11/1 20:42
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
