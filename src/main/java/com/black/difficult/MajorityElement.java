package com.black.difficult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * @author Citrus
 * @date 2021/10/22 15:29
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int n = length / 3;
        HashMap<Integer, Integer> map = new HashMap<>(length);
        for (int num : nums) {
            //getOrDefault 从map获取key对应的value，如果没有，则返回设置的默认值，此处为0，取得值后+1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) > n) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 解法2 摩尔投票
     * 题目隐含了一个条件，候选人只能是两个，假设候选人m>2，根据每个候选者票数x都需大于n/3，
     * 则当选人的总票数为m*x->3*n/3=n 也就是当选人总票数大于全部票数，证伪
     * 在只有两个候选者的情况下，当为候选者票数时，该候选者票数++，若均不为候选者票时，候选者均票数--，
     * 最后根据选出来的候选者进行遍历确定真伪
     *
     * @param nums
     * @return
     */
    public List<Integer> moElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 初始化两个候选人
        int vote1 = nums[0], vote2 = nums[0], count1 = 0, count2 = 0;
        // ----抵消阶段
        for (int num : nums) {
            if (num == vote1) {
                count1++;
                continue;
            }
            if (num == vote2) {
                count2++;
                continue;
            }
            // 匹配第一个
            if (count1 == 0) {
                vote1 = num;
                count1++;
                continue;
            }
            // 匹配第二个
            if (count2 == 0) {
                vote2 = num;
                count2++;
                continue;
            }
            // 都没匹配
            count1--;
            count2--;
        }
        // ----校验阶段
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == vote1) {
                count1++;
            } else if (num == vote2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(vote1);
        }
        if (count2 > nums.length / 3) {
            result.add(vote2);
        }
        return result;
    }
}
