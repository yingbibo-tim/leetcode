package com.leet.code.traning;

/**
 * @author yingbibo
 * on 2019-06-12
 * email: yingbibo@canzhaoxi.com.cn
 */
public class ListNode {
	int val;
	ListNode next;


	ListNode() {}


	ListNode(int x) {
		val = x;
	}

	ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
}
