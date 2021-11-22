package com.black.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 迷宫,八皇后应该也是此法
 *
 * @author 菠萝凤梨
 * @date 2021/11/2 21:02
 */
public class DFSMaze {
    class Node {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    int[][] book = new int[51][51];
    int[][] a = new int[51][51];
    int n, m, p, q, min = 9999; // n,m设为迷宫大小
    int[][] next = {{0, 1}, // right
            {1, 0}, // down
            {0, -1}, // left
            {-1, 0}}; // up

    /**
     * 深度优先算法
     */
    public void dfs(int x, int y, int step) {
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
    public void bfs(){
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node();
        node.setX(1);
        node.setY(1);
        queue.offer(node);
        int step = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int nextX = queue.peek().getX() + next[i][0];
                int nextY = queue.peek().getY() + next[i][1];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {
                    continue;
                }
                if (a[nextX][nextY] == 0 && book[nextX][nextY] == 0) {
                    book[nextX][nextY] = 1;
                    Node nextNode = new Node();
                    nextNode.setX(nextX);
                    nextNode.setY(nextY);
                    queue.offer(nextNode);
                    step++;
                }
                if (nextX == p && nextY == q) {
                    break;
                }
            }
            queue.remove();//出队
        }
        System.out.println(step);
    }
}
