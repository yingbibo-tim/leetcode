//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]    [根节点 左节点序列 右节点序列]
//中序遍历 inorder = [9,3,15,20,7]      [左节点序列 根节点 右节点序列]
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 750 👎 0

package com.leet.code.traning.tree;

import com.leet.code.traning.TreeNode;

import java.util.*;

//java:从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
		TreeNode treeNode = new TreeNode(3);
		treeNode.left = new TreeNode(9);
		treeNode.right = new TreeNode(20);
		treeNode.right.left = new TreeNode(15);
		treeNode.right.right = new TreeNode(7);
		solution.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});

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
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			Map<Integer,Integer> inorderMap = new HashMap<>();
			for(int i=0;i<inorder.length;i++){
				inorderMap.put(inorder[i],i);
			}
			TreeNode node = null;
			node = getTree(preorder,inorderMap,0,preorder.length-1,0,preorder.length-1);
			return node;
		}

		private TreeNode getTree(int[] preorder,Map<Integer,Integer> inorderMap,int p_startIndex,int p_endIndex,int i_startIndex,int i_endIndex){
			if(p_startIndex>p_endIndex){
				return null;
			}
			TreeNode root = new TreeNode(preorder[p_startIndex]);
			int iIndex = inorderMap.get(root.val);
			int leftLength = iIndex - i_startIndex;
			root.left = getTree(preorder,inorderMap,p_startIndex+1,p_startIndex+leftLength,i_startIndex,iIndex-1);
			root.right = getTree(preorder,inorderMap,p_startIndex+leftLength+1,p_endIndex,iIndex+1,i_endIndex);
			return  root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

