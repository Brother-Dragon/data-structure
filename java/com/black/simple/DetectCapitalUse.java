package com.black.simple;

/**
 * 检测正确的大写字母用法
 * @author 菠萝凤梨
 * @create 2021/11/13 13:35
 */
public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        //全部大写
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        //全部小写
        if (word.toLowerCase().equals(word)) {
            return true;
        }
        //首字母大写
        int index = 1,length = word.length();
        if (Character.isUpperCase(word.charAt(0))){
            while (index < length && Character.isLowerCase(word.charAt(index))){
                index++;
            }
        }
        return index == length;
    }
}
