//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1817 👎 0

package com.leet.code.traning;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

//java:有效的括号
public class P20ValidParentheses1 {
	public static void main(String[] args) {
		Solution solution = new P20ValidParentheses1().new Solution();
		System.out.println(solution.isValid("()[]{}"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isValid(String s) {
			if(Objects.isNull(s)){
				return false;
			}
			if(s.length()==0){
				return true;
			}
			Map<Character,Character> map = new HashMap<>();
			map.put(')','(');
			map.put('}','{');
			map.put(']','[');
			Stack<Character> stack = new Stack<Character>();
			char[] chars = s.toCharArray();
			for(int i=0;i<chars.length;i++){
				char c = chars[i];
				if(stack.isEmpty()){
					stack.add(c);
				}else {
					char first = stack.peek();
					if (Objects.equals(map.get(c), first)) {
						stack.pop();
					} else {
						stack.add(c);
					}
				}

			}

			return stack.isEmpty();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

