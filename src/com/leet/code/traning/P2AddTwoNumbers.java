package com.leet.code.traning;

/**
 * @author yingbibo
 * on 2020-05-26
 * email: yingbibo@canzhaoxi.com.cn
 */
public class P2AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);


		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(9);
//		l2.next.next.next = new ListNode(9);
//		l2.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

		addTwoNumbers(l1, l2);

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode resultNode = null;
		ListNode nextNode = null;
		int least = 0;
		while (l1 != null || l2 != null) {
			int v1 = l1 == null ? 0 : l1.val;
			int v2 = l2 == null ? 0 : l2.val;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			int currentValue = v1 + v2 + least;
			ListNode currentNode = new ListNode(currentValue % 10);
			least = currentValue / 10;

			if (resultNode == null) {
				resultNode = currentNode;
			}else{
				if(nextNode==null){
					nextNode = currentNode;
					resultNode.next = nextNode;
				}else{
					nextNode.next = currentNode;
					nextNode = nextNode.next;
				}
			}
		}

		if(least>0){
			ListNode node = new ListNode(least);
			node.next = resultNode;
			resultNode = node;
		}

		return resultNode;
	}
}
