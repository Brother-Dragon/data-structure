package com.black.difficult;

/**
 * 路径是否相交问题
 * 总结归纳找规律
 * @author Citrus
 * @date 2021/10/29 14:09
 */
public class IsSelfCrossing {
    public static void main(String[] args) {
        int[] test = new int[5];
        test[0] = 3;
        test[1] = 3;
        test[2] = 4;
        test[3] = 2;
        test[4] = 2;
        boolean selfCrossing = isSelfCrossing(test);
        System.out.println(selfCrossing);
    }
    public static boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) {
            return false;
        }
        for (int i = 3; i < n; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            if (i >= 4 && (distance[i - 4] + distance[i] >= distance[i - 2])
                    && distance[i - 1] == distance[i - 3]) {
                return true;
            }
            if (i >= 5 && distance[i - 1] <= distance[i - 3] && distance[i - 2] >= distance[i - 4]
                    && (distance[i] + distance[i - 4] >= distance[i - 2])
                    && (distance[i - 5] + distance[i - 1] >= distance[i - 3])) {
                return true;
            }
        }
        return false;
    }
}
