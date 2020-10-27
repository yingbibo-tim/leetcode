//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 498 👎 0

package com.leet.code.traning;
//java:二进制求和
public class P67AddBinary{
    public static void main(String[] args){
        Solution solution = new P67AddBinary().new Solution();
        solution.addBinary("11","1");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int pre = 0;
        String newStr = "";
        while(a.length()>0||b.length()>0){
            int c1 = a.length()>0?a.charAt(a.length()-1)-'0':0;
            int c2 =b.length()>0? b.charAt(b.length()-1)-'0':0;
            newStr=(c1+c2+pre)%2+newStr;
            pre = (c1+c2+pre)/2;
            a = a.length()>0?a.substring(0,a.length()-1):a;
            b = b.length()>0?b.substring(0,b.length()-1):b;
        }
        if(pre>0){
            newStr=pre+newStr;
        }
        return newStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

