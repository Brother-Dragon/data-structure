package com.black.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成所有n对括号的有效组合
 * 回溯法
 * @author Citrus
 * @date 2021/10/27 13:23
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public static void backTrack(List<String> res, StringBuilder stringBuilder, int open, int close, int max) {
        if (stringBuilder.length() == 2 * max) {
            res.add(stringBuilder.toString());
            return;
        }
        if (open < max) {
            stringBuilder.append('(');
            backTrack(res, stringBuilder, open + 1, close, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < open) {
            stringBuilder.append(')');
            backTrack(res, stringBuilder, open, close + 1, max);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
