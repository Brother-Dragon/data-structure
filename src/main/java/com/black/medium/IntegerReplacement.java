package com.black.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 整数替换
 * dfs,bfs,贪心【我不会】
 *
 * @author Citrus
 * @date 2021/11/19 14:02
 */
public class IntegerReplacement {
    Map<Long, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return dfs(n);
    }

    int dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);
        return ans;
    }

    public int integerReplacementBfs(int n) {
        if (n == 1) {
            return 0;
        }
        Map<Long, Integer> resMap = new HashMap<>();
        Deque<Long> values = new ArrayDeque<>();
        values.addLast((long) n);
        resMap.put((long) n, 0);
        while (!values.isEmpty()) {
            long t = values.pollFirst();
            int step = resMap.get(t);
            long[] ns = t % 2 == 0 ? new long[]{t / 2} : new long[]{t + 1, t - 1};
            for (long x : ns) {
                if (x == 1) {
                    return step + 1;
                }
                if (!resMap.containsKey(x)) {
                    map.put(x, step + 1);
                    values.addLast(x);
                }
            }
        }
        return -1;
    }
}
