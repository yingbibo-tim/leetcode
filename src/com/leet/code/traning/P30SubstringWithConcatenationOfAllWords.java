//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 336 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:串联所有单词的子串
public class P30SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		String s = "01234567";
		int i = s.length() - 6;
		System.out.println(i);
		Solution solution = new P30SubstringWithConcatenationOfAllWords().new Solution();
		List<Integer> list = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
		System.out.println(list);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<Integer> findSubstring(String s, String[] words) {
			List<Integer> result = new ArrayList<>();
			if (s == null || s.length() == 0 || words == null || words.length == 0) {
				return new ArrayList<>();
			}
			for (String word : words) {
				if (!s.contains(word)) {
					return new ArrayList<>();
				}
			}
			int wordLength = words[0].length();
			Map<String,Integer> wordsMap = new HashMap<>();
			for(String word:words){
				wordsMap.merge(word,1,Integer::sum);
			}
			for (int i = 0; i <= s.length() -(wordLength*words.length); i++) {
				Map<String,Integer> tempMap = new HashMap<>();
				String temp = s.substring(i,wordLength*words.length+i);
				while(temp.length()>0){
					String w = temp.substring(0,wordLength);
					temp = temp.substring(wordLength);
					tempMap.merge(w,wordsMap.containsKey(w)?1:0,Integer::sum);
				}
				if(wordsMap.equals(tempMap)){
					result.add(i);
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

