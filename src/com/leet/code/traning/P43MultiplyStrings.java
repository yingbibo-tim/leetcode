//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 495 👎 0

package com.leet.code.traning;

import java.util.Objects;

//java:字符串相乘
public class P43MultiplyStrings {
	public static void main(String[] args) {
		Solution solution = new P43MultiplyStrings().new Solution();
		System.out.println(solution.multiply("123","456"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String multiply(String num1, String num2) {
			if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
				return "0";
			}
			int lengthNum1 = num1.length();
			int lengthNum2 = num2.length();
			int[] arr = new int[lengthNum1+lengthNum2];
			for(int i=lengthNum1-1;i>=0;i--){
				int n1 = num1.charAt(i)-'0';
				for(int j=lengthNum2-1;j>=0;j--){
					int n2 = num2.charAt(j)-'0';
					int sum = n1*n2;
					arr[i+j+1] = arr[i+j+1]+sum;
				}
			}
			for(int i=arr.length-1;i>0;i--){
				arr[i-1] = arr[i-1]+arr[i]/10;
				arr[i] = arr[i]%10;
			}
			String s = "";
			int index = arr[0]==0?1:0;
			for(int i=index;i<arr.length;i++){

				s+=arr[i];
			}

			return s;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

