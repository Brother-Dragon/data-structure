package com.black.difficult;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 接雨水2 太难了 我还是没懂
 *
 * @author 菠萝凤梨
 * @date 2021/11/3 20:13
 */
public class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int maxHeight = 0;
        // 求出最高的高度
        for (int[] ints : heightMap) {
            for (int j = 0; j < n; j++) {
                maxHeight = Math.max(maxHeight, ints[j]);
            }
        }
        // 假设每个方块的接水高度都是maxHeight
        int[][] water = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                water[i][j] = maxHeight;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        // 肯定会溢出的，进行调整，广度优先搜索
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
                    water[nx][ny] = Math.max(water[x][y],heightMap[nx][ny]);
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += (water[i][j] - heightMap[i][j]);
            }
        }
        return res;
    }
}
