//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 519 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//java:螺旋矩阵
//如何确定拐角或者方向
public class P54SpiralMatrix {
	public static void main(String[] args) {
		Solution solution = new P54SpiralMatrix().new Solution();
		//int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] nums = new int[][]{{3},{2}};
		solution.spiralOrder(nums);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			if(matrix.length==0){
				return new ArrayList<>();
			}

			List<Integer> resultList = new ArrayList<>();
			int startRow = 0;
			int endRow = matrix.length - 1;
			int startColumn = 0;
			int endColumn = matrix[0].length - 1;
			int rowLength = matrix.length;
			int columnLength = matrix[0].length;
			int start = 1;
			while(true) {
				//for (int i = 0; i < Math.min(rowLength, columnLength) * 2 - 1; i++) { //确定转换次数
					if (start == 1) {
						for (int j = startColumn; j <= endColumn; j++) {
							int num = matrix[startRow][j];
							resultList.add(num);
						}
						startRow++;
					} else if (start == 2) {
						for (int j = startRow; j <= endRow; j++) {
							int num = matrix[j][endColumn];
							resultList.add(num);
						}
						endColumn--;
					} else if (start == 3) {
						for (int j = endColumn; j >= startColumn; j--) {
							int num = matrix[endRow][j];
							resultList.add(num);
						}
						endRow--;
					} else if (start == 4) {
						for (int j = endRow; j >= startRow; j--) {
							int num = matrix[j][startColumn];
							resultList.add(num);
						}
						startColumn++;
					}


					start = start + 1;
					if (start > 4) {
						start = 1;
					}
					if(resultList.size()==rowLength*columnLength){
						return resultList;
					}
				//}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

