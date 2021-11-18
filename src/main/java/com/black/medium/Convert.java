package com.black.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * z字形变化
 * 但我看着像N😓
 *
 * @author Citrus
 * @date 2021/11/8 9:52
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(length, numRows); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            curRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
