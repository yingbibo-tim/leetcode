//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 963 👎 0

package com.leet.code.traning;

//java:删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList2 {
	public static void main(String[] args) {
		Solution solution = new P19RemoveNthNodeFromEndOfList2().new Solution();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		solution.removeNthFromEnd(node, 1);

	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null) {
				return null;
			}
			//巧妙之处
			ListNode dummy = new ListNode(0);
			dummy.next = head;

			ListNode first = head;
			int length = 0;
			while (first != null) {
				length++;
				first = first.next;
			}
			// 得到需要移除的index
			length = length-n;

			// 这里是为了使 length == 0 的时候 正好是需要移除的上一个节点
			first = dummy;
			while(length>0){
				length--;
				first = first.next;
			}
			//first 得到的是需要移除的上一个节点
			first.next = first.next.next;
			return dummy.next;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

