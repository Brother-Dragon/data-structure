package com.black.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * @author 菠萝凤梨
 * @date 2021/10/30 20:38
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] text = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(text)));
    }

    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (int num : nums) {
            if (map.get(num) == 1) {
                ans[index++] = num;
            }
        }
        return ans;
    }

    public static int[] singleNumberBit(int[] nums) {
        int sortNum = 0;
        for (int num : nums) {
            sortNum ^= num;
        }
        //lowbit取到的结果就是最低位的1和后面的0
        int lsb = sortNum == Integer.MAX_VALUE ? sortNum : (sortNum & (-sortNum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((lsb & num) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1,type2};
    }
}
