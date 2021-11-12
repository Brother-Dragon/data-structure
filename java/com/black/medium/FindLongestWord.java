package com.black.medium;

import java.util.List;

/**
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 通过删除字母匹配到字典里最长单词
 *
 * @author Citrus
 * @date 2021/9/14 10:28
 */
public class FindLongestWord {
    /**
     * 对字典进行遍历，取每个字符串t出来对比，假设输入的字符串为s，则最大匹配应该是t为s的子串，对字典长度进行排序
     *
     * @param s
     * @param dictionary
     * @return
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        //排序
        dictionary.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        int sLength = s.length();
        //遍历取字符串t
        for (String t : dictionary) {
            int tLength = t.length();
            //t指针
            int i = 0;
            //s指针
            int j = 0;
            while (i < tLength && j < sLength) {
                if (s.charAt(j) == t.charAt(i)) {
                    i++;
                }
                j++;
                if (i == tLength) {
                    return t;
                }
            }
        }
        return "";
    }
}
