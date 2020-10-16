//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 487 👎 0

package com.leet.code.traning;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;

//java:字母异位词分组
public class P49GroupAnagrams {
	public static void main(String[] args) {
		Solution solution = new P49GroupAnagrams().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> resultMap = new HashMap<>();
			for (String str : strs) {
				char[] chars = str.toCharArray();
				Arrays.sort(chars);
				if (!resultMap.containsKey(String.valueOf(chars))) {
					resultMap.put(String.valueOf(chars), new ArrayList<>());
				}
				resultMap.get(String.valueOf(chars)).add(str);
			}

			return new ArrayList(resultMap.values());
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

