//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 367 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

import java.util.ArrayList;
import java.util.List;

//java:恢复二叉搜索树
public class P99RecoverBinarySearchTree {
	public static void main(String[] args) {
		Solution solution = new P99RecoverBinarySearchTree().new Solution();
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(2);
		solution.recoverTree(treeNode);
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
		public void recoverTree(TreeNode root) {
			List<TreeNode> treeNodes = new ArrayList<>();
			intro(root,treeNodes);
			TreeNode node1 = null;
			TreeNode node2 = null;
			for(int i=0;i<treeNodes.size()-1;i++){
				if(treeNodes.get(i).val>treeNodes.get(i+1).val){
					if(node1==null){
						node1 = treeNodes.get(i);
						node2 = treeNodes.get(i+1);
					}else{
						node2 = treeNodes.get(i+1);
						break;
					}
				}
			}
			int val = node1.val;
			node1.val = node2.val;
			node2.val = val;

		}


		private void intro(TreeNode node, List<TreeNode> treeNodes){
			if(node!=null){
				intro(node.left,treeNodes);
				treeNodes.add(node);
				intro(node.right,treeNodes);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

