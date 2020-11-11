//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 734 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public int maxDepth(TreeNode root) {
			int maxDepth = 0;
			if(root==null){
				return maxDepth;
			}
			Deque<TreeNode> queue = new ArrayDeque<>();
			queue.offer(root);
			while(!queue.isEmpty()){
				maxDepth++;
				int size = queue.size();
				for(int i=0;i<size;i++){
					TreeNode node = queue.poll();
					if(node.left!=null){
						queue.offer(node.left);
					}
					if(node.right!=null){
						queue.offer(node.right);
					}
				}
			}
			return maxDepth;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

