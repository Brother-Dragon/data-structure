package com.black.difficult;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 啊哈算法中 宝岛探险 分别用广度和深度实现
 *
 * @author 菠萝凤梨
 * @date 2021/11/11 20:21
 */
public class Adventure {
    static class Node {
        int x;//横坐标
        int y;//纵坐标

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

    static int[][] next = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}//分别是向右，向下，向左，向上
    };
    static int[][] a;//存储地图
    static int[][] book;//标记

    /**
     * 广搜在于，将每个点录入队列，然后探寻这个点的可能性，标记之后出队，进行下个点
     */
    public static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        book = new int[n + 1][m + 1];
        a = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int startX = scanner.nextInt();//迷宫入口
        int startY = scanner.nextInt();
        Node node = new Node();
        node.setX(startX);
        node.setY(startY);
        queue.offer(node);
        book[startX][startY] = 1;
        int sum = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int nextX = queue.peek().getX() + next[i][0];
                int nextY = queue.peek().getY() + next[i][1];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {
                    continue;
                }
                if (a[nextX][nextY] > 0 && book[nextX][nextY] == 0) {
                    sum++;
                    book[nextX][nextY] = 1;
                    Node nextNode = new Node();
                    nextNode.setX(nextX);
                    nextNode.setY(nextY);
                    queue.offer(nextNode);
                }
                queue.remove();
            }
        }
        System.out.println(sum);
    }

    static int dn = 5, dm = 5,sum = 0;//假设地图最大值，深搜用一下

    /**
     * 深搜呢，尽可能往下走，走到头了就回到原点，[递归]换个方向继续走，适合探索最大值之类的
     */
    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];
            if (nextX < 1 || nextX > dn || nextY < 1 || nextY > dm) {
                continue;
            }
            if (a[nextX][nextY] > 0 && book[nextX][nextY] == 0) {
                sum++;
                book[nextX][nextY] = 1;
                DFS(nextX,nextY);
            }
        }
        return;
    }
}
