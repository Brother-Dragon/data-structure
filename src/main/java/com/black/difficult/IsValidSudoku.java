package com.black.difficult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 是否为有效数独
 * 数字1-9每一行只能出现一次
 * 每一列只能出现一次
 * 每一个以粗实线分隔的3×3的子宫格只能出现一次[0,3,6]
 *
 * @author Citrus
 * @date 2021/10/19 14:42
 */
public class IsValidSudoku {
    private final static int NUM = 9;

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < NUM; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                char a = board[i][j];
                if (a == '.') {
                    continue;
                }
                int u = a - '0';
                int index = i / 3 * 3 + j / 3;
                if (row.get(i).contains(u) || col.get(j).contains(u) || area.get(index).contains(u)) {
                    return false;
                }
                row.get(i).add(u);
                col.get(j).add(u);
                area.get(index).add(u);
            }
        }
        return true;
    }

    public static boolean isValidSudokuTwo(char[][] board) {
        boolean[][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int a = c - '0';
                int index = i / 3 * 3 + j / 3;
                if (row[i][a] || col[j][a] || area[index][a]) {
                    return false;
                }
                row[i][a] = col[j][a] = area[index][a] = true;
            }
        }
        return true;
    }
}
