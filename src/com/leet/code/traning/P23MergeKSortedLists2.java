//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 872 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//java:合并K个升序链表
public class P23MergeKSortedLists2 {
	public static void main(String[] args) {
		Solution solution = new P23MergeKSortedLists2().new Solution();


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
	//归并
	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0) {
				return null;
			}
			List<ListNode> list = new ArrayList<>();
			for(ListNode node:lists){
				if(node!=null){
					list.add(node);
				}
			}

			if(list.size()==0){
				return null;
			}
			if(list.size()==1){
				return list.get(0);
			}

			for(int i=0;i<list.size()-1;i=i+2){
				merge(list,list.get(i),list.get(i+1));
			}

			return list.get(list.size()-1);
		}


		private void merge(List<ListNode> list,ListNode l1,ListNode l2){
			ListNode dummy = new ListNode();
			ListNode pre = dummy;
			while(l1!=null&&l2!=null){
				if(l1.val<=l2.val){
					pre.next = new ListNode(l1.val);
					l1 = l1.next;
				}else{
					pre.next = new ListNode(l2.val);
					l2 = l2.next;
				}
				pre = pre.next;
			}
			pre.next= l1==null?l2:l1;
			list.add(dummy.next);
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}

