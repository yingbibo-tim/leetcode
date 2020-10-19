//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 153 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:N皇后 II
public class P52NQueensIi{
    public static void main(String[] args){
        Solution solution = new P52NQueensIi().new Solution();
        solution.totalNQueens(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int totalNQueens(int n) {
            if (n <= 0) {
                return 0;
            }
            List<Integer> resultList = new ArrayList<>();
            //初始化棋盘
            int[][] nums = new int[n][n];
            r(0, nums, resultList);
            return resultList.size();
        }

        private void r(int row, int[][] nums, List<Integer> resultList) {
            if (row == nums.length) {
                resultList.add(1);
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

