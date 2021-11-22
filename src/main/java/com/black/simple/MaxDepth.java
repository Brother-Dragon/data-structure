package com.black.simple;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树最长深度
 * @author 菠萝凤梨
 * @date 2021/11/21 14:18
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node));
        }
        return ans + 1;
    }

    public int maxDepthBfs(Node root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node t = queue.pollFirst();
                for (Node child : t.children) {
                    queue.addLast(child);
                }
            }
            ans++;
        }
        return ans;
    }
}
class Node {
    public int val;
    public List<Node> children;
    public Node (){

    }
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}