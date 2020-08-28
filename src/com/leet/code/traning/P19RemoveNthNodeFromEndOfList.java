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
public class P19RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		solution.removeNthFromEnd(node,2);

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

			List<Integer> list = new ArrayList<>();
			list.add(head.val);
			while(head.next!=null){
				ListNode next = head.next;
				head = next;
				list.add(next.val);
			}
			if(list.size()==1){
				return null;
			}
			ListNode next = null;
			list.remove(list.size()-n);
			ListNode first = new ListNode(list.get(0));
			for(int i=1;i<list.size();i++){
				ListNode node = new ListNode(list.get(i));
				if(i==1){
					next = node;
					first.next = next;
				}else{
					next.next = node;
					next = node;
				}

			}
			return first;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

