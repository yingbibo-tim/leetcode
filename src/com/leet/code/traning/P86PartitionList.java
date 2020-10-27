//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 274 👎 0

package com.leet.code.traning;
//java:分隔链表
public class P86PartitionList{
    public static void main(String[] args){
        Solution solution = new P86PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        ListNode minListNode = new ListNode(0);
        ListNode maxListNode = new ListNode(0);
        ListNode dummy1 = minListNode;
        ListNode dummy2 = maxListNode;
        while(head!=null){
            int val = head.val;
            if(val<x){
                minListNode.next = head;
                minListNode = minListNode.next;
            }else{
                maxListNode.next = head;
                maxListNode = maxListNode.next;
            }
            head = head.next;
        }
        maxListNode.next  = null;
        minListNode.next = dummy2.next;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

