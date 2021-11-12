package com.black.medium;

/**
 * 迷宫,八皇后应该也是此法
 *
 * @author 菠萝凤梨
 * @create 2021/11/2 21:02
 */
public class DFSMaze {
    int[][] book = new int[51][51];
    int[][] a = new int[51][51];
    int n, m, p, q, min = 9999; // n,m设为迷宫大小

    /**
     * 深度优先算法
     */
    public void dfs(int x, int y, int step) {
        int[][] next = {{0, 1}, // right
                        {1, 0}, // down
                        {0, -1}, // left
                        {-1, 0}}; // up
        // 如果找到了
        if (x == p && y == q) {
            if (step < min) {
                min = step;
            }
            return;
        }
        int tx, ty;
        // 枚举四种走法
        for (int k = 0; k <= 3; k++) {
            tx = x + next[k][0];
            ty = y + next[k][1];
            // 判断是否越界
            if (tx < 1 || tx > n || ty < 1 || ty > m) {
                continue;
            }
            // 判断是否有障碍物以及是否走过了
            if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx,ty,step+1);
                book[tx][ty] = 0;
            }
        }
    }

    /**
     * 广度优先算法
     */
    public void bfs(){}
}
