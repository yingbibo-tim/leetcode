//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 703 👎 0

package com.leet.code.traning;

//java:K 个一组翻转链表
public class P25ReverseNodesInKGroup {
	public static void main(String[] args) {
		Solution solution = new P25ReverseNodesInKGroup().new Solution();
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		node1.next.next.next = new ListNode(4);
		node1.next.next.next.next = new ListNode(5);
		//node1.next.next.next.next.next = new ListNode(6);

		System.out.println(solution.reverseKGroup(node1, 2));
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 *
	 *
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		//看错题目。。。特码的 以为是间隔的节点反转

		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode dummy = new ListNode();
			dummy.next = head;
			ListNode pre = dummy;
			ListNode first = dummy;
			ListNode second = dummy;
			int length = 0;
			while (second != null && second.next!=null&& length < k -1 ) {

				//  dummy->1->2->3->4->5

				second = second.next;
				length++;
				if(length==k-1 && second.next!=null){
					ListNode leftNode = first.next;
					ListNode currentNode = second;
					ListNode rightNode = second.next;
					ListNode rightNextNode = second.next.next;

					//先断开连接
					second.next = null;
					if(leftNode.next!=null) {
						rightNode.next = leftNode.next;
						currentNode.next = leftNode;
					}else{
						rightNode.next = leftNode;
					}
					leftNode.next = rightNextNode;
					pre.next = rightNode;
					pre = leftNode;
					first = leftNode;
					second = leftNode;
					length = 0;
				}
			}

			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

