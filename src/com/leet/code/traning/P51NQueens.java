//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 633 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:N 皇后
public class P51NQueens {
	public static void main(String[] args) {
		Solution solution = new P51NQueens().new Solution();
		solution.solveNQueens(4);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<String>> solveNQueens(int n) {
			if (n <= 0) {
				return new ArrayList<>();
			}
			List<List<String>> resultList = new ArrayList<>();
			//初始化棋盘
			int[][] nums = new int[n][n];
			r(0, nums, resultList);
			return resultList;
		}

		private void r(int row, int[][] nums, List<List<String>> resultList) {
			if (row == nums.length) {
				List<String> list = new ArrayList<>();
				for (int i = 0; i < nums.length; i++) {
					String s = "";
					for (int j = 0; j < nums[0].length; j++) {
						if (nums[i][j] == 1) {
							s += "Q";
						} else {
							s += ".";
						}
					}
					list.add(s);
				}
				resultList.add(list);

			} else {
				for (int j = 0; j < nums[0].length; j++) {
					if (checkColumn(row, j, nums) && checkLeftUp(row, j, nums) && checkRightUp(row, j, nums)) {
						nums[row][j] = 1;
						r(row + 1, nums, resultList);
						nums[row][j] = 0;
					}
				}
			}
		}

		//判断列
		private boolean checkColumn(int row, int column, int[][] nums) {
			while (row >= 0) {
				int num = nums[row][column];
				if (num == 1) {
					return Boolean.FALSE;
				}
				row--;
			}
			return Boolean.TRUE;
		}

		//判断左斜
		private boolean checkLeftUp(int row, int column, int[][] nums) {
			while (row >= 0 && column >= 0) {
				int num = nums[row][column];
				if (num == 1) {
					return Boolean.FALSE;
				}
				row--;
				column--;
			}
			return Boolean.TRUE;
		}

		//判断右斜
		private boolean checkRightUp(int row, int column, int[][] nums) {
			while (row >= 0 && column <= nums[0].length - 1) {
				int num = nums[row][column];
				if (num == 1) {
					return Boolean.FALSE;
				}
				row--;
				column++;
			}
			return Boolean.TRUE;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}

