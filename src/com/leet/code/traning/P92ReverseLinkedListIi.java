//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 561 👎 0

package com.leet.code.traning;

//java:反转链表 II
public class P92ReverseLinkedListIi {
	public static void main(String[] args) {
		Solution solution = new P92ReverseLinkedListIi().new Solution();
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		 node1.next.next = new ListNode(3);
		 node1.next.next.next = new ListNode(4);
		 node1.next.next.next.next = new ListNode(5);
		solution.reverseBetween(node1, 2, 4);

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
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (m == n) {
				return head;
			}
			ListNode dummy = head;
			ListNode preBeforeNode = null;
			ListNode firstPreNode = null;
			ListNode preNode = null;
			ListNode lastlastNode = null;
			int index = 1;
			while (head != null) {
				ListNode next = head.next;

				if (index <= n && index >= m) {
					if (preNode != null) {
						head.next = preNode;
						preNode = head;
					} else {
						preNode = head;
						firstPreNode = head;
						preNode.next = null;
					}
				} else if (index == m - 1) {
					preBeforeNode = head;
				} else if (index == n + 1) {
					lastlastNode = head;
				}

				index++;
				head = next;
			}

			if (preBeforeNode != null) {
				preBeforeNode.next = preNode;
			}
			firstPreNode.next = lastlastNode;
			return preBeforeNode==null?preNode:dummy;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

