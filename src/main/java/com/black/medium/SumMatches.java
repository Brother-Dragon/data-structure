package com.black.medium;

/**
 * 火柴
 *
 * @author 菠萝凤梨
 * @create 2021/10/29 21:54
 */
public class SumMatches {
    /**
     * 计算某个数需要多少火柴
     */
    public static int calculate(int x) {
        int nums = 0;
        int[] useNum = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        while (x / 10 != 0) {
            // 当前数至少有两位
            // 求得尾数
            nums += useNum[x % 10];
            x /= 10;
        }
        nums += useNum[x];
        return nums;
    }

    public static void main(String[] args) {
        //枚举
        int a, b, c, m, sum = 0;
        m = 18;
        for (a = 0; a <= 1111; a++) {
            for (b = 0; b <= 1111; b++) {
                c = a + b;
                if (calculate(a) + calculate(b) + calculate(c) == m - 4) {
                    System.out.println(a + "+" + b + "=" + c);
                    sum++;
                }
            }
        }
        System.out.println("解法数量为"+sum);
    }
}
