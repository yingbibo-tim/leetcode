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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:合并两个有序链表
public class P21MergeTwoSortedLists {
	public static void main(String[] args) {
		Solution solution = new P21MergeTwoSortedLists().new Solution();


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
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			List<Integer> list = new ArrayList<>();
			while (l1!=null||l2!=null){
				if(l1!=null&&l2!=null){
					list.add(l1.val );
					list.add(l2.val );
					l1 = l1.next;
					l2 = l2.next;
				}else if(l1!=null){
					list.add(l1.val);
					l1 = l1.next;
				}else {
					list.add(l2.val );
					l2 = l2.next;
				}
			}
			Collections.sort(list);
			ListNode dummy = new ListNode();
			ListNode next = new ListNode();
			dummy.next = next;
			for(Integer i:list){
				next.next = new ListNode(i);
				next = next.next;
			}
			return dummy.next.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

