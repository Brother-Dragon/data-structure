package com.black.difficult;

/**
 * 支持添加单词和搜索单词[通配符.]的数据结构
 * 字典树 dfs
 * @author Citrus
 * @date 2021/10/19 13:46
 */
public class WordDictionary {

    static class TrieNode {
        boolean end;
        TrieNode[] nodes = new TrieNode[26];
    }

    TrieNode root;
    private static final char NODE = '.';
    private static final int NUMBER = 26;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        //apple age
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';
            if (parent.nodes[number] == null) {
                parent.nodes[number] = new TrieNode();
            }
            parent = parent.nodes[number];
        }
        parent.end = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int index) {
        int length = word.length();
        if (length == index) {
            return node.end;
        }
        char c = word.charAt(index);
        if (c == NODE) {
            for (int i = 0; i < NUMBER; i++) {
                if (node.nodes[i] != null && dfs(word, node.nodes[i], index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int n = word.charAt(index) - 'a';
            if (node.nodes[n] == null) {
                return false;
            }
            return dfs(word, node.nodes[n], index + 1);
        }
    }

    public boolean normalSearch(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            int number = word.charAt(i) - 'a';
            if (parent.nodes[number] == null) {
                return false;
            }
            parent = parent.nodes[number];
        }
        return parent.end;
    }
}
