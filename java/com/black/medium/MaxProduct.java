package com.black.medium;

/**
 * 最大单词长度乘积 318
 * @author Citrus
 * @date 2021/11/17 10:14
 */
public class MaxProduct {
    public static void main(String[] args) {
        String[] words = new String[]{"abcw","xtfn","abcedf"};
        int i = maxProduct(words);
        System.out.println(i);
    }
    public static int maxProduct(String[] words) {
        int length = words.length, index = 0;
        int[] mask = new int[n];
        for (String word : words) {
            int t = 0;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                // |= 相当于+，<<为左移运算符，低位补0，相当于乘上2的u次方
                t |= (1 << u);
            }
            mask[index++] = t;
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans,words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
