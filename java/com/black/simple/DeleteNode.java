package com.black.simple;


/**
 * @author Citrus
 * @date 2021/11/2 10:21
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        //一般删除节点就是让被删除节点的前一个和后一个连接就行了
        //但是本题不能访问前一个节点
        //只能让被删节点的后一个节点复制到该节点，然后删除后一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
