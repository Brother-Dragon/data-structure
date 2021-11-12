package com.black.medium;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * @author Citrus
 * @date 2021/8/27 13:47
 */
public class MinBoatsNum {
    /**
     * 船数要最少，两人船要尽可能多。
     * 考虑体重最轻的人，如果他不能和体重最重的坐同一艘船，那么最重的只能单独一艘。那么问题就变成求n-1个人的最少船数，最后加上1即为答案；
     * 如果他可以和体重最重的坐同一艘船，那么问题变成求n-2个人的最少船数，最后答案加上1；
     * 首先对people进行排序，两个指针指向最轻和最重的，移动指针求解；
     */
    public static void main(String[] args) {
        int[] ints = new int[2];
        ints[0] = 1;
        ints[1] = 2;
        System.out.println(numRescueBoats(ints, 3));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length -1;
        int ans = 0;
        while (light <= heavy) {
            if (light + heavy <= limit) {
                light++;
            }
            ans++;
            heavy--;
        }
        return ans;
    }
}
