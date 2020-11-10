//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 503 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

import java.util.Objects;

//java:相同的树
public class P100SameTree {
	public static void main(String[] args) {
		Solution solution = new P100SameTree().new Solution();
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
		public boolean isSameTree(TreeNode p, TreeNode q) {
			return check(p,q);
		}



		private boolean check(TreeNode p, TreeNode q) {
			if (p == null && q == null) {
				return true;
			} else {
				if (p == null || q == null) {
					return false;
				}
				return Objects.equals(p.val,q.val)&&check(p.left,q.left)&&check(p.right,q.right);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

