//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 149 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//java:递增子序列
public class P491IncreasingSubsequences {
	public static void main(String[] args) {
		Solution solution = new P491IncreasingSubsequences().new Solution();
		int[] list = new int[]{4, 6, 7, 7};
		solution.findSubsequences(list);
	}

	class Solution {
		public List<List<Integer>> findSubsequences(int[] nums) {
			if(nums.length<1){
				return new ArrayList<>();
			}
			Set<String> allSet = new HashSet<>();
			for(int i=0;i<nums.length-1;i++){
				int start = nums[i];
				Set<String> sets = new HashSet<>();
				for(int j=i+1;j<nums.length;j++){
					int next = nums[j];
					String s = start+"#"+next;

					Set<String> newSets = new HashSet<>(sets);
					for(String old:newSets){
						old = old+"#"+next;
						sets.add(old);
					}
					sets.add(s);
				}
				allSet.addAll(sets);
			}
			List<List<Integer>> list = new ArrayList<>();
			for(String s:allSet){
				String[] ss = s.split("#");
				List<Integer> childList = new ArrayList<>();
				for(int i=1;i<ss.length;i++){
					if(Integer.parseInt(ss[i])>=Integer.parseInt(ss[i-1])){
						childList.add(Integer.parseInt(ss[i]));
					}

				}
				childList.add(0,Integer.parseInt(ss[0]));
				if(childList.size() == ss.length){
					list.add(childList);
				}

			}

			System.out.println(list);
			return list;
		}
	}

}

