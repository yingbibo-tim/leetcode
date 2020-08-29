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
public class P22GenerateParentheses {
	public static void main(String[] args) {
		Solution solution = new P22GenerateParentheses().new Solution();
		System.out.println(solution.generateParenthesis(3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> resultList = new ArrayList<>();
			if (n <= 0) {
				return resultList;
			}
			List<String> allList = new ArrayList<>();
			for(int i=0;i<2*n;i++){
				if(i==0){
					allList.add("(");
				}else{
					List<String> tempList = new ArrayList<>();
					for(String s:allList){
						for(int j=0;j<2;j++){
							String temp=s+(j==0?"(":")");
							tempList.add(temp);
						}
					}
					allList = tempList;
				}
			}
			for(String s:allList) {
				String temp = s;
				while (true) {
					String old = s;
					s=s.replace("()","");
					if(Objects.equals(old,s)){
						break;
					}
					if(s.length()==0){
						resultList.add(temp);
					}
				}
			}


			return resultList;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

