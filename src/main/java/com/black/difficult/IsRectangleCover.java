package com.black.difficult;

import java.util.HashMap;
import java.util.Map;

/**
 * 完美矩形，五个矩形完美覆盖一个完整的矩形，也就是说大矩形的面积要是所有小矩形面积之和，四角顶点只能出现一次，其余顶点只能出现两次或者四次
 *
 * @author Citrus
 * @date 2021/11/16 8:42
 */
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        int minX = rectangles[0][0], minY = rectangles[0][1], maxX = rectangles[0][2], maxY = rectangles[0][3];
        Map<Point, Integer> cnt = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int x = rectangle[0], y = rectangle[1], a = rectangle[2], b = rectangle[3];
            area += (long) (a - x) * (b - y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            Point point1 = new Point(x, y);
            Point point2 = new Point(x, b);
            Point point3 = new Point(a, y);
            Point point4 = new Point(a, b);
            //统计其余顶点
            cnt.put(point1, cnt.getOrDefault(point1, 0) + 1);
            cnt.put(point2, cnt.getOrDefault(point2, 0) + 1);
            cnt.put(point3, cnt.getOrDefault(point3, 0) + 1);
            cnt.put(point4, cnt.getOrDefault(point4, 0) + 1);
        }
        //统计四个顶点
        Point pointMinMin = new Point(minX, minY);
        Point pointMinMax = new Point(minX, maxY);
        Point pointMaxMin = new Point(maxX, minY);
        Point pointMaxMax = new Point(maxX, maxY);
        if (area != (long) (maxX - minX) * (maxY - minY)
                || cnt.getOrDefault(pointMinMin, 0) != 1
                || cnt.getOrDefault(pointMinMax, 0) != 1
                || cnt.getOrDefault(pointMaxMin, 0) != 1
                || cnt.getOrDefault(pointMaxMax, 0) != 1) {
            return false;
        }

        cnt.remove(pointMinMin);
        cnt.remove(pointMinMax);
        cnt.remove(pointMaxMin);
        cnt.remove(pointMaxMax);

        for (Map.Entry<Point, Integer> entry : cnt.entrySet()) {
            int value = entry.getValue();
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point point2 = (Point) o;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x + y;
    }
}
