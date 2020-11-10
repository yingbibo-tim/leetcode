//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 688 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	/**
	 * 层序遍历
	 */
	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> resultList = new ArrayList<>();
			if(root==null){
				return resultList;
			}
			getLevelOrder(resultList,root);
			return resultList;
		}

		private void getLevelOrder(List<List<Integer>> resultList, TreeNode root) {
			Deque<TreeNode> queue = new ArrayDeque<>();
			queue.add(root);
			while (true) {
				List<Integer> list = new ArrayList<>();
				Deque<TreeNode> newQueue = new ArrayDeque<>();
				while(!queue.isEmpty()) {
					TreeNode node = queue.poll();
					if (node.left != null) {
						newQueue.add(node.left);
					}
					if (node.right != null) {
						newQueue.add(node.right);
					}
					list.add(node.val);
				}
				resultList.add(list);
				if(newQueue.isEmpty()){
					break;
				}else{
					queue = newQueue;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

