//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 951 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:全排列
public class P46Permutations {
	public static void main(String[] args) {
		Solution solution = new P46Permutations().new Solution();
		solution.permute(new int[]{1,2,3});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			if (nums == null || nums.length == 0) {
				return new ArrayList<>();
			}
			List<List<Integer>> resultList = new ArrayList<>();
			get(resultList,new ArrayList<>(),0,nums);
			return resultList;
		}


		public void get(List<List<Integer>> resultList, List<Integer> list, int level, int[] nums) {
			if (nums.length == level) {
				resultList.add(new ArrayList<>(list));
			}else {
				int currentNum = nums[level];
				for(int i=0;i<=level;i++){
					list.add(i,currentNum);
					get(resultList, list, level + 1, nums);
					list.remove(i);
				}
			}

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

