package com.black.medium;

import java.util.Arrays;

/**
 * 啊哈算法的案例
 * 深度优先搜索伪代码
 *  dfs(int step){
 *      判断边界
 *      尝试每一种可能fori{
 *          继续下一步dfs(step+1);
 *      }
 *  }
 *
 * @author 菠萝凤梨
 * @date 2021/10/30 11:26
 */
public class DFS {
    public static int n = 3;
    //记录手上的牌
    public static int[] book = new int[10];
    //记录盒子的牌
    public static int[] a = new int[10];

    /**
     * dfs的核心在于考虑当下怎么做，下一步跟当下是一样的
     * 此方法在于探究当第step个盒子的时候应该怎么做
     *
     */
    public static void dfs(int step) {
        if (step == n + 1) {
            // 输出一种顺序
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                //扑克牌在手上
                a[step] = i;
                book[i] = 1;
                dfs(step + 1);
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }
}
