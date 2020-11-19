//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 637 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

//java:将有序数组转换为二叉搜索树
public class P108ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
		solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
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

// 有序 平衡 搜索树 中序遍历
	class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {

			if (nums.length == 0) {
				return null;
			}
			return buildTree(nums, 0, nums.length - 1);


		}

		private TreeNode buildTree(int[] nums, int left, int right) {
			if (left > right) {
				return null;
			}
			int mid = (left + right) / 2;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = buildTree(nums, left, mid - 1);
			node.right = buildTree(nums, mid + 1, right);
			return node;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

