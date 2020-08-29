//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1267 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//java:括号生成
public class P22GenerateParentheses1 {
	public static void main(String[] args) {
		Solution solution = new P22GenerateParentheses1().new Solution();
		System.out.println(solution.generateParenthesis(3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> resultList = new ArrayList<>();
			if(n<=0){
				return resultList;
			}
			parenthesis(resultList,new StringBuilder(),0,0,n);
			return resultList;
		}

		public void parenthesis(List<String> resultList,StringBuilder sb,int leftCount,int rightCount,int maxCount){
			if(sb.length()==2*maxCount){
				resultList.add(sb.toString());
			}
			if(leftCount<maxCount){
				sb.append("(");
				parenthesis(resultList,sb,leftCount+1,rightCount,maxCount);
				sb.deleteCharAt(sb.toString().length()-1);
			}
			if(rightCount<leftCount){
				sb.append(")");
				parenthesis(resultList,sb,leftCount,rightCount+1,maxCount);
				sb.deleteCharAt(sb.toString().length()-1);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

