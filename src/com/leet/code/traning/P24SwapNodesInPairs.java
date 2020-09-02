//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 605 👎 0

package com.leet.code.traning;

import java.util.List;

//java:两两交换链表中的节点
public class P24SwapNodesInPairs{
    public static void main(String[] args){
        Solution solution = new P24SwapNodesInPairs().new Solution();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        solution.swapPairs(node1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
       ListNode dummy = new ListNode();
       dummy.next = head;
       ListNode pre = dummy;
       // 节点交换
       while(pre.next!=null&&pre.next.next!=null){
           ListNode first = pre.next;
           ListNode second = pre.next.next;
           pre.next = second;
           first.next = second.next;
           second.next = first;
           pre = first;
       }
       return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

