//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 429 👎 0

package com.leet.code.traning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//java:有效的数独

/**
 * 确定好子方格数
 *
 *  i/3 在第几行
 *
 *  j/3 在第几列
 *
 *  i/3 * 3(每行3个)
 *
 *  i/3 * 3 + j/3 就是具体的格子
 *
 *
 */

public class P36ValidSudoku {
	public static void main(String[] args) {
		Solution solution = new P36ValidSudoku().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isValidSudoku(char[][] board) {
			Map<Integer, Set<Character>> rowMap = new HashMap<>();
			Map<Integer, Set<Character>> columnMap = new HashMap<>();
			Map<Integer, Set<Character>> partMap = new HashMap<>();


			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					char c = board[i][j];
					if (c != '.') {
						{
							Set<Character> set = rowMap.get(i);
							if (set == null) {
								set = new HashSet<>();
							}
							if (set.contains(c)) {
								return Boolean.FALSE;
							}
							set.add(c);
							rowMap.put(i, set);
						}

						{
							Set<Character> set = columnMap.get(j);
							if(set == null ){
								set = new HashSet<>();
							}
							if(set.contains(c)){
								return Boolean.FALSE;
							}
							set.add(c);
							columnMap.put(j,set);
						}

						{
							int index = i/3 *3 + j/3;
							Set<Character> set = partMap.get(index);
							if(set == null) {
								set = new HashSet<>();
							}
							if(set.contains(c)){
								return Boolean.FALSE;
							}
							set.add(c);
							partMap.put(index,set);
							
						}





					}

				}
			}
			return Boolean.TRUE;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

