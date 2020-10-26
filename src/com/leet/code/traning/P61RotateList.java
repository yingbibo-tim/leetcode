//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 353 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:旋转链表
public class P61RotateList {
	public static void main(String[] args) {
		Solution solution = new P61RotateList().new Solution();
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		//node1.next.next.next = new ListNode(4);
		//node1.next.next.next.next = new ListNode(5);
		solution.rotateRight(node1,4);
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
		public ListNode rotateRight(ListNode head, int k) {

			List<ListNode> list = new ArrayList<>();
			while (head != null) {
				list.add(head);
				head = head.next;
			}
			if(list.size()==0){
				return head;
			}
			k = k%list.size();
			ListNode[] arr = new ListNode[list.size()];
			for (int i = 0; i < list.size(); i++) {
				int index = i+k;
				while(index>list.size() - 1){
					index = index-list.size();
				}
				ListNode node = list.get(i);
				node.next = null;
				arr[index] = node;
			}
			ListNode newNode = new ListNode(0);
			ListNode p = newNode;
			for (ListNode node : arr) {
				p.next = node;
				p = p.next;
			}
			return newNode.next;
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}

