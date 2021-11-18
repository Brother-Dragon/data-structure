package com.black.difficult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 由若干括号和字母组成的字符串s
 * 删除最小数量的无效括号，使得输入的字符有效
 * 返回所有有可能的结果
 * s = "()())()"
 * ["(())()","()()()"]
 * 法1 ：回溯+剪枝
 * 法2 ：广度优先搜索
 *
 * @author Citrus
 * @date 2021/10/27 13:15
 */
public class RemoveInvalidParentheses {
    private static final List<String> RES = new ArrayList<>();

    public static void main(String[] args) {
        String s = "()())()";
        //List<String> resList = removeInvalidParentheses1(s);
        List<String> resList = removeInvalidParentheses(s);
        System.out.println(resList);
    }
//    --------------------------广度优先搜索-----------------------------

    public static List<String> removeInvalidParentheses1(String s) {
        Set<String> curSet = new HashSet<>();
        curSet.add(s);
        while (true) {
            for (String str : curSet) {
                if (isValid(str)) {
                    RES.add(str);
                }
            }
            if (RES.size() > 0) {
                return RES;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : curSet) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
                curSet = nextSet;
            }
        }
    }

//    --------------------------回溯------------------------------

    public static List<String> removeInvalidParentheses(String s) {
        //计算出最小删除数量
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftRemove++;
            } else if (s.charAt(i) == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }
        Set<String> curSet = new HashSet<>();
        helper(curSet, s, 0, 0, 0, leftRemove, rightRemove);
        RES.addAll(curSet);
        return RES;
    }

    /**
     * 回溯
     */
    public static void helper(Set<String> curSet, String str, int start, int leftCount, int rightCount, int leftRemove, int rightRemove) {
        if (leftRemove == 0 && rightRemove == 0) {
            if (isValid(str)) {
                curSet.add(str);
            }
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (leftRemove + rightRemove > str.length() - i) {
                return;
            }
            //尝试删除左括号
            String resStr = str.substring(0, i) + str.substring(i + 1);
            if (leftRemove > 0 && str.charAt(i) == '(') {
                helper(curSet, resStr, i, leftCount, rightCount, leftRemove - 1, rightRemove);
            }
            //尝试删除右括号
            if (rightRemove > 0 && str.charAt(i) == ')') {
                helper(curSet, resStr, i, leftCount, rightCount, leftRemove, rightRemove - 1);
            }
            if (str.charAt(i) == '(') {
                leftCount++;
            } else if (str.charAt(i) == ')') {
                rightCount++;
            }
            //如果当前右括号数量大于左括号的就非法了
            if (leftCount < rightCount) {
                break;
            }
        }
    }

    /**
     * 校验是否是合格的括号组合
     */
    public static boolean isValid(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res++;
            } else if (s.charAt(i) == ')') {
                res--;
                if (res < 0) {
                    return false;
                }
            }
        }
        return res == 0;
    }
}
