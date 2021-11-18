package com.black.medium;

/**
 * l1 = [1,2,4], l2 = [1,3,4]
 * [1,1,2,3,4,4]
 *
 * @author Citrus
 * @date 2021/8/31 11:04
 */
public class MergeTwoLists {
    /**
     * 两个升序列表合并成新的升序列表递归
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
    }

    /**
     * 迭代
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //一个哨兵节点
        ListNode preNode = new ListNode(-1);
        //维护一个指针去next操作，最后返回的还是哨兵节点的next
        ListNode pre = preNode;
        //如果是空的就让pre去继承那个非空的生下部分
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}