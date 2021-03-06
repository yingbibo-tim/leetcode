//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 770 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:二叉树的中序遍历
public class P94BinaryTreeInorderTraversal1 {
	public static void main(String[] args) {
		Solution solution = new P94BinaryTreeInorderTraversal1().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */
	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> resultList = new ArrayList<>();
			inorderTraversal1(resultList,root);
			return resultList;
		}

		/**
		 * 递归方式
		 *
		 * @param resultList
		 * @param root
		 */
		private void inorderTraversal1(List<Integer> resultList, TreeNode root) {
			if(root!=null) {
				int nodeValue = root.val;
				TreeNode leftTreeNode = root.left;
				TreeNode rightTreeNode = root.right;
				inorderTraversal1(resultList,leftTreeNode);
				resultList.add(nodeValue);
				inorderTraversal1(resultList,rightTreeNode);


			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

