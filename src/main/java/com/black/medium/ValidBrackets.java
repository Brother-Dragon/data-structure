package com.black.medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 有效的括号
 * 栈是限制线性表中元素的插入和删除只能在线性表的同一端进行的一种特殊线性表。允许插入和删除的一端，为变化的一端，称为栈顶(Top)，另一端为固定的一端，称为栈底(Bottom)。
 * 根据栈的定义可知，最先放入栈中元素在栈底，最后放入的元素在栈顶，而删除元素刚好相反，最后放入的元素最先删除，最先放入的元素最后删除
 * s = "()[]{}" s = "{[]}"
 * @author Citrus
 * @date 2021/8/27 13:46
 */
public class ValidBrackets {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1 || length == 0){
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            //以右括号进行判断，左括号入栈
            if (hashMap.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(hashMap.get(c))) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
