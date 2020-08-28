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
public class P19RemoveNthNodeFromEndOfList3 {
	public static void main(String[] args) {
		Solution solution = new P19RemoveNthNodeFromEndOfList3().new Solution();
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
			ListNode first = dummy;
			ListNode second = dummy;
			for(int i=1;i<=n+1;i++){
				first = first.next;
			}

			//这里是为了保证 second 跟 first正好 差 N个间隔
			//并且 second 是在需要移除的节点的前一个节点
			while(first!=null){
				first = first.next;
				second = second.next;
			}

		second.next = second.next.next;
		return  dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

