package com.black.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 重新排序得到2的幂，成功true，失败false
 *
 * @author Citrus
 * @date 2021/10/28 8:41
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        boolean res = reorderedPowerOf2(16);
        System.out.println(res);
    }

    static int numLength;

    static int[] split = new int[10];

    public static boolean reorderedPowerOf2(int n) {
        //对n进行拆分
        while (n != 0) {
            split[n % 10]++;
            n /= 10;
            numLength++;
        }
        return dfs(0, 0);
    }

    static boolean dfs(int index, int cur) {
        if (index == numLength) {
            return isPowerOfTwo(cur);
        }
        for (int i = 0; i < 10; i++) {
            if (split[i] != 0) {
                split[i]--;
                if ((i != 0 || cur != 0) && dfs(index + 1, cur * 10 + i)) {
                    return true;
                }
                split[i]++;
            }
        }
        return false;
    }

    static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
