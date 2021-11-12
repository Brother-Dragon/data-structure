package com.black.medium;

/**
 * 猜数字大小Ⅱ 375 记忆化搜索
 * @author Citrus
 * @date 2021/11/12 15:00
 */
public class GetMoneyAmount {
    static int N = 210;
    static int[][] cache = new int[N][N];
    public int getMoneyAmount(int n) {
        return dfs(1, n);
    }

    /**
     * 在[l, n]范围内猜数，返回值为猜中至少需要多少钱
     */
    private int dfs(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (cache[l][r] != 0) {
            return cache[l][r];
        }
        int ans = 0x3f3f3f3f;
        for (int x = l; x < r; x++) {
            //对所猜数x进行两边求值，继续递归，最后要加上所猜数的值才是最后消费的金额
            //为什么是求最大值，因为不知道x能不能猜中，要考虑最差的情况
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            //至少
            ans = Math.min(cur,ans);
        }
        cache[l][r] = ans;
        return ans;
    }
}
