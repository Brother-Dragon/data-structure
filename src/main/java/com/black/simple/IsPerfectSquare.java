package com.black.simple;

/**
 * 是否为有效的完全平方数
 *
 * @author 菠萝凤梨
 * @date 2021/11/4 20:51
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int res = (int) Math.sqrt(num);
        return res * res == num;
    }

    public boolean isPerfectSquare1(int num) {
        //数学 一个数是完全平方数就会满足n^2 = 1+3+5+...+(2*n-1)
        int x = 1;
        while (num > 0) {
            num -= x;
            x += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare2(int num) {
        // 二分法
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
