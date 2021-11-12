package com.black.simple;

/**
 * 一个奇怪的时间问题 495
 *
 * @author Citrus
 * @date 2021/11/10 16:39
 */
public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // res:answer last:The end point of the last attack
        int res = 0, last = -1;
        for (int time : timeSeries) {
            //end time
            int x = time + duration - 1;
            //If the attack starts within the duration
            res += last < time ? duration :  x - last;
            last = x;
        }
        return res;
    }
}
