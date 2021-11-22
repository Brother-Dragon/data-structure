package com.black.difficult;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 啊哈算法中解救小哈 广度优先算法
 *
 * @author 菠萝凤梨
 * @date 2021/11/10 20:45
 */
public class BFS {
    static class Node {
        private int x;//横坐标
        private int y;//纵坐标
        private int step;//步数

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

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }
    }

    static int[][] next = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}//分别是向右，向下，向左，向上
    };
    static int[][] a;//存储地图
    static int[][] book;//标记

    public static void main(String[] args) {
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
        int endX = scanner.nextInt();//小哈位置
        int endY = scanner.nextInt();
        int head = 1;
        Node node = new Node();
        node.setX(startX);
        node.setY(startY);
        node.setStep(0);
        queue.offer(node);
        book[startX][startY] = 1;
        int flag = 0;//是否到达小哈位置 1代表到了就可以结束了
        while (!queue.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int nextX = queue.peek().getX() + next[i][0];
                int nextY = queue.peek().getY() + next[i][1];
                //是否越界
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {
                    continue;
                }
                //是否是障碍物或者已经在路径中了
                if (a[nextX][nextY] == 0 || book[nextX][nextY] == 0) {
                    //标记点已经走过，广搜无需复原记录
                    book[nextX][nextY] = 1;
                    //入队
                    Node nextNode = new Node();
                    nextNode.setX(nextX);
                    nextNode.setY(nextY);
                    nextNode.setStep(queue.peek().getStep() + 1);
                    queue.offer(nextNode);
                }
                if (nextX == endX && nextY == endY) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                head++;
            }
            queue.remove();
        }
        while (queue.size()!=1){
            queue.remove();
        }
        System.out.println(queue.peek().getStep());
    }
}
