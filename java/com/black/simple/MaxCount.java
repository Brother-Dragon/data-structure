package com.black.simple;

/**
 * 598 范围求和
 * 模拟转换
 * @author 菠萝凤梨
 * @create 2021/11/7 21:03
 */
public class MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
