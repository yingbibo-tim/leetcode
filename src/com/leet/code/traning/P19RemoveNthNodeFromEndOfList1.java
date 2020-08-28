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

import java.util.ArrayList;
import java.util.List;

//java:删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList1 {
	public static void main(String[] args) {
		Solution solution = new P19RemoveNthNodeFromEndOfList1().new Solution();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		solution.removeNthFromEnd(node,1);

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

			List<ListNode> list = new ArrayList<>();
			list.add(head);
			while(head.next!=null){
				ListNode next = head.next;
				head = next;
				list.add(next);
			}
			if(list.size()==1){
				return null;
			}
			int i = list.size()-n-1;
			int j = list.size()-n+1;
			if(i>=0&&j<=list.size()-1){
				list.get(i).next = list.get(j);
			}else{
				list.remove(list.size()-n);
				list.get(list.size()-1).next = null;
			}


			return list.get(0);

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

