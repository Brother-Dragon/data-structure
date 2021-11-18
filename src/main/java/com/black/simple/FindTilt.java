package com.black.simple;

/**
 * 二叉树的坡度 562
 *
 * @author Citrus
 * @date 2021/11/18 11:15
 */
public class FindTilt {
    int ans;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left), r = dfs(node.right);
        ans += Math.abs(l - r);
        return l + r + node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
