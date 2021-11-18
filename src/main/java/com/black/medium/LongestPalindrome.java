package com.black.medium;

/**
 * 最长回文字符串
 *
 * @author Citrus
 * @date 2021/11/8 17:38
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = longestPalindrome("babad");
        System.out.println(str);
    }
    /**
     * 中心扩散
     */
    public static String longestPalindromeCenter(String s) {
        int strLen = s.length();
        int len = 1, maxLen = 0, left, right, maxStart = 0;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
                len++;
            }
            while (right < strLen && s.charAt(i) == s.charAt(right)) {
                right++;
                len++;
            }
            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                right++;
                left--;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxLen + maxStart + 1);
    }

    /**
     * 动态规划
     * 初始状态dp[1][r] = true，1=r
     * 状态转移方程 dq[1][r] = true,并且1-1，r+1这两个位置的字符也相同，则dq[1-1][r+1]=true
     */
    public static String longestPalindrome(String s) {
        int strLen = s.length();
        int maxStart = 0, maxEnd = 0, maxLen = 1;
        boolean[][] dq = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dq[l + 1][r - 1])) {
                    dq[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
