//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 942 👎 0

package com.leet.code.traning;

import sun.security.util.Length;

//java:搜索旋转排序数组
public class P33SearchInRotatedSortedArray {
	public static void main(String[] args) {
		Solution solution = new P33SearchInRotatedSortedArray().new Solution();
		System.out.println(solution.search(new int[]{4,5,6,7,8,1,2,3}, 2));



	}

	//二分法变种
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int search(int[] nums, int target) {

			//[7,0,1,2,4,5,6]

			int result = -1;
			if (nums == null || nums.length == 0) {
				return result;
			}


			int left = 0;
			int right = nums.length - 1;


			// 1 2 3 4 5 6 7 8   8
			while (left <= right) {
				int midIndex = (right + left) / 2;
				int mid = nums[midIndex];
				if (mid == target) {
					return midIndex;

					// 1 2 3 4 5 6   5
					// 3 1 2 target = 3

					// 4 1 3 target = 3;

					//左边有序
				} else if(nums[0]<=mid){
					if(nums[0]<=target&&target<mid){
						right = midIndex-1;
					}else{
						left = midIndex+1;
					}
				}else{
					if(mid<target&&target<=nums[nums.length-1]){
						left = midIndex+1;
					}else{
						right = midIndex-1;
					}
				}

			}


			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

