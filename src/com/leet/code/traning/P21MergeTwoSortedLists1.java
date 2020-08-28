//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1237 👎 0

package com.leet.code.traning;

//java:合并两个有序链表
public class P21MergeTwoSortedLists1 {
	public static void main(String[] args) {
		Solution solution = new P21MergeTwoSortedLists1().new Solution();


	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		//有序
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode headNode = new ListNode();
			ListNode preNode = headNode;

			while (l1 != null && l2 != null) {
				int v1 = l1.val;
				int v2 = l2.val;
				if (v1 <= v2) {
					preNode.next = new ListNode(v1);
					l1 = l1.next;
				} else {
					preNode.next = new ListNode(v2);
					l2 = l2.next;
				}
				preNode = preNode.next;
			}

			preNode.next = l1==null?l2:l1;
			return headNode.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

