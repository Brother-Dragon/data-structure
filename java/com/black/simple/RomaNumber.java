package com.black.simple;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * @author Citrus
 * @date 2021/8/27 13:46
 */
public class RomaNumber {
    public static void main(String[] args) {
        System.out.println(romanToInt("MIV"));
    }
    /**
     * 小的数值放在大的左边，即做减法，反之为加法
     * 在代码实现上，可以往后看多一位，对比当前位与后一位的大小关系，从而确定当前位是加还是减法。当没有下一位时，做加法即可
     */
    public static int romanToInt(String s) {
        int ans = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int aft = getValue(s.charAt(i));
            if (pre <= aft) {
                ans -= pre;
            } else {
                ans += pre;
            }
            pre = aft;
        }
        ans += pre;
        return ans;
    }

    private static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
