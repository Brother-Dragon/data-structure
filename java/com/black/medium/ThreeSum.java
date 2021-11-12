package com.black.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个正整数集合nums，找出其中三个数a+b+c=0 返回所有结果集
 * [-1,0,1,2,-1,-4]
 * [[-1,-1,2],[-1,0,1]]
 *
 * @author 菠萝凤梨
 * @create 2021/10/29 21:12
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        // [-4,-1,-1,0,1,2] k i j
        for (int k = 0; k < nums.length - 2; k++) {
            // 如果nums[k]已经大于0了，加上后面的i和j必然大于0，此时退出即可
            if (nums[k] > 0) {
                break;
            }
            // 去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    // sum小于0，i++，顺便跳过所有相同的数字
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    // sum大于0，j--，顺便跳过所有相同的数字
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    // sum=0 加入答案集合后，也要去重，跳过相同的选项
                    resultList.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return resultList;
    }
}
