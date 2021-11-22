package com.black.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 键盘行
 *
 * @author 菠萝凤梨
 * @date 2021/10/31 11:26
 */
public class FindWords {
    static String[] printWords = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] hash = new int[26];

    static {
        for (int i = 0; i < printWords.length; i++) {
            for (char c : printWords[i].toCharArray()) {
                hash[c - 'a'] = i;
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        out:
        for (String word : words) {
            int start = -1;
            for (char c : word.toCharArray()) {
                c = Character.toLowerCase(c);
                if (start == -1) {
                    start = hash[c - 'a'];
                } else if (start != hash[c - 'a']) {
                    continue out;
                }
            }
            list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
}
