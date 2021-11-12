package com.black.medium;

import java.util.HashMap;

/**
 * 给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。
 * s = "abc abc bb" 3
 * s = "b b b b b" 1
 * s = "pw wke w" 3
 *
 * @author Citrus
 * @date 2021/8/28 9:55
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int ans = 0;
        //key为字符 value为字符下标+1
        HashMap<Character, Integer> map = new HashMap<>(length);
        //滑动窗口->可移动队列，定义不重复子串开始位置为start，结束为end
        //随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start
        //此时 [start, end] 区间内不存在重复字符
        //无论是否更新 start，都会更新其 map 数据结构和结果 ans。
        for (int start = 0, end = 0; end < length; end++) {
            char flagChar = s.charAt(end);
            if (map.containsKey(flagChar)) {
                start = Math.max(map.get(flagChar), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
