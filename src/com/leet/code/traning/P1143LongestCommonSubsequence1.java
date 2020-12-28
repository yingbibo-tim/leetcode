//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 306 👎 0

package com.leet.code.traning;

//java:最长公共子序列
public class P1143LongestCommonSubsequence1 {
	public static void main(String[] args) {
		Solution solution = new P1143LongestCommonSubsequence1().new Solution();
		System.out.println(solution.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int longestCommonSubsequence(String text1, String text2) {
			if (text1 == null || text2 == null) {
				return 0;
			}
			int[][] table = new int[text1.length()][text2.length()];
			for(int i=0;i<text1.length();i++){
				for(int j=0;j<text2.length();j++){
					if(text1.charAt(i)==text2.charAt(j)){
						int length1 = 0;
						int length2 = 0;
						if(i>0&&j>0){
							length1 = table[i-1][j-1];
						}

						table[i][j] = Math.max(length1,length2)+1;
					}else{
						int length1 = 0;
						int length2 = 0;
						if(i>0){
							length1 = table[i-1][j];
						}
						if(j>0){
							length2 = table[i][j-1];
						}
						table[i][j] = Math.max(length1,length2);

					}


				}
			}
			return table[text1.length()-1][text2.length()-1];


		}


	}
}
