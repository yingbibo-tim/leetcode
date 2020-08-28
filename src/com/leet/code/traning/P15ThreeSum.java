//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2518 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
public class P15ThreeSum {
	public static void main(String[] args) {
		Solution solution = new P15ThreeSum().new Solution();
		int[] i = {0,0,0};
		System.out.println(solution.threeSum(i));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> resultList = new ArrayList<>();
			if (nums == null || nums.length < 3) {
				return resultList;
			}
			//从小到大排序
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				if(nums[i]>0){
					return resultList;
				}
				if(i>0&&nums[i]==nums[i-1]){
					continue;
				}


				int currentIndex = i;
				int leftIndex = i + 1;
				int rightIndex = nums.length-1;
				while (leftIndex < rightIndex) {
					int current = nums[currentIndex];
					int left = nums[leftIndex];
					int right = nums[rightIndex];
					int sum = current+left+right;
					//如果和>0 则说明 右边的太大了
					if(sum>0){
						rightIndex--;
					}else if(sum<0){
						leftIndex++;
					}else{
						List<Integer> list = new ArrayList<>();
						list.add(current);list.add(left);list.add(right);
						resultList.add(list);
						int currentLeftIndex = leftIndex;
						int currentRightIndex = rightIndex;
						leftIndex++;
						rightIndex--;
						while(leftIndex<nums.length&&(nums[leftIndex]==nums[currentLeftIndex])){
							leftIndex++;
						}
						while(rightIndex>=0&&nums[rightIndex]==nums[currentRightIndex]){
							rightIndex--;
						}
					}

				}
			}

			return resultList;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

