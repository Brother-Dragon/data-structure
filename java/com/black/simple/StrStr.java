package com.black.simple;

/**
 * @author Citrus
 * @date 2021/10/22 16:32
 */
public class StrStr {
    public static void main(String[] args) {
        int i = strStr("a", "a");
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        for (int i = 0; i + l2 <= l1; i++) {
            boolean flag = true;
            for (int j = 0; j < l2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
