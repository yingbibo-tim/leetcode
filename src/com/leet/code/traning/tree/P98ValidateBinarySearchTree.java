//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 824 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

//java:验证二叉搜索树
public class P98ValidateBinarySearchTree {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(6);


		Solution solution = new P98ValidateBinarySearchTree().new Solution();
		System.out.println(solution.isValidBST(node));
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
		public boolean isValidBST(TreeNode root) {
			return check(root,null,null);
		}

		private boolean check(TreeNode node, Integer low, Integer up) {
			if (node == null) {
				return true;
			}
			int val = node.val;
			if(low!=null&&val<=low){
				return false;
			}
			if(up!=null&&val>=up){
				return false;
			}
			if(!check(node.left,low,val)){
				return false;
			}
			if(!check(node.right,val,up)){
				return false;
			}
			return true;
		}
		private boolean check11(TreeNode node,int headNodeVal) {
			if (node == null ) {
				return true;
			}
			int val = node.val;
			TreeNode left = node.left;
			TreeNode right = node.right;
			if(left==null&&right==null){
				return true;
			}else if(left!=null&&right==null){
				return left.val<val&&left.val<headNodeVal&&check11(left,headNodeVal);
			}else if(right!=null&&left==null){
				return right.val>val&&right.val>headNodeVal&&check11(right,headNodeVal);
			}else {
				return left.val<val
						&&right.val>val
						&&left.val<headNodeVal
						&&right.val>headNodeVal
						&&check11(left,headNodeVal)&&check11(right,headNodeVal);
			}
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}

