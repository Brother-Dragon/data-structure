package com.black.medium;

/**
 * bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * [10,55,45,25,25]
 *
 * @author Citrus
 * @date 2021/8/31 10:13
 */
public class CorpFlightBookings {
    /**
     * 差分
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
