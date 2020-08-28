//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 556 👎 0

package com.leet.code.traning;

import java.util.Arrays;

//java:最接近的三数之和
public class P16ThreeSumClosest {
	public static void main(String[] args) {
		Solution solution = new P16ThreeSumClosest().new Solution();
		System.out.println(solution.threeSumClosest(new int[]{1,2,4,8,16,32,64,128},82));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int threeSumClosest(int[] nums, int target) {
			Arrays.sort(nums);
			int result = nums[0] + nums[1] + nums[2];
			if(result==target){
				return result;
			}
			for(int i=0;i<nums.length-2;i++){
				int currentIndex = i;
				int leftIndex = i+1;
				int rightIndex = nums.length-1;
				while(leftIndex<rightIndex){
					int current = nums[currentIndex];
					int left = nums[leftIndex];
					int right = nums[rightIndex];
					int now = current+left+right;
					int abs = Math.abs(now-target);
					int oldAbs = Math.abs(result-target);
					result = abs>=oldAbs?result:now;
					if(now==target){
						return result;
					}else if(now>target){
						rightIndex--;
					}else{
						leftIndex++;
					}
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

