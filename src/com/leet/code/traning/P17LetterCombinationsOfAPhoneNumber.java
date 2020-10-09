//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 936 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args){
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return result;
        }
        Map<Character,String[]> map = new HashMap<>();
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});
        build(new StringBuilder(),map,digits,0,result);
        System.out.println(result);
        return result;

    }

    private void build(StringBuilder sb,Map<Character,String[]> map,String digits,int level,List<String> result){
        if(level == digits.length()){
            result.add(sb.toString());
        }else {
            char c = digits.charAt(level);
            String[] nums = map.get(c);
            for (String s : nums) {
                sb.append(s);
                build(sb, map, digits, level + 1, result);
                sb.deleteCharAt(sb.toString().length() - 1);
            }
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}

