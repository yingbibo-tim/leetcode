//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 251 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:螺旋矩阵 II
public class P59SpiralMatrixIi{
    public static void main(String[] args){
        Solution solution = new P59SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        if(n==0){
            return new int[][]{};
        }

        int[][] matrix = new int[n][n];
        List<Integer> resultList = new ArrayList<>();
        int startRow = 0;
        int endRow = n - 1;
        int startColumn = 0;
        int endColumn = n - 1;
        int rowLength = n;
        int columnLength = n;
        int start = 1;
        int index = 0;
        while(true) {
            if (start == 1) {
                for (int j = startColumn; j <= endColumn; j++) {
                    int num = ++index;
                    matrix[startRow][j] = num;
                }
                startRow++;
            } else if (start == 2) {
                for (int j = startRow; j <= endRow; j++) {
                    int num = ++index;
                    matrix[j][endColumn] = num;
                }
                endColumn--;
            } else if (start == 3) {
                for (int j = endColumn; j >= startColumn; j--) {
                    int num = ++index;
                    matrix[endRow][j] = num;
                }
                endRow--;
            } else if (start == 4) {
                for (int j = endRow; j >= startRow; j--) {
                    int num = ++index;
                    matrix[j][startColumn] = num;
                }
                startColumn++;
            }
            start = start + 1;
            if (start > 4) {
                start = 1;
            }
            if(index==rowLength*columnLength){
               return matrix;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

