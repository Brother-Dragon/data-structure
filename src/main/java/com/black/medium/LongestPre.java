package com.black.medium;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author Citrus
 * @date 2021/8/27 13:47
 */
public class LongestPre {

    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "flower";
        strings[1] = "flow";
        strings[2] = "flee";
        System.out.println(longestCommonPrefix(strings));
    }

    /**
     * 纵向搜索，取出第一个字符串，对剩下的字符串逐字符遍历
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char bef = str.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != bef) {
                    return str.substring(0,i);
                }
            }
        }
        return str;
    }
}
