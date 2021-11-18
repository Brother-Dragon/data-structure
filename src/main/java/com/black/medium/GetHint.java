package com.black.medium;

/**
 * 猜数字
 *
 * @author Citrus
 * @date 2021/11/8 9:23
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int a = 0, b = 0;
        int[] s = new int[10], g = new int[10];
        for (int i = 0; i < length; i++) {
            int s1 = secret.charAt(i) - '0', g1 = guess.charAt(i) - '0';
            if (s1 == g1) {
                a++;
            } else {
                s[s1]++;
                g[g1]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(s[i],g[i]);
        }
        return a + "A" + b + "B";
    }
}
