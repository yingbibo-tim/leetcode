//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 874 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.List;

//java:跳跃游戏
public class P55JumpGame {
	public static void main(String[] args) {
		Solution solution = new P55JumpGame().new Solution();
		solution.canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean canJump(int[] nums) {
			int[] newNums = new int[nums.length];
			jump(nums,0,newNums);
			return newNums[nums.length-1]==1;
		}

		private void jump(int[] nums, int level,int[] newNums){
			if(newNums[Math.min(level,nums.length-1)]!=1) {
				if (level >= nums.length - 1) {
					newNums[nums.length - 1] = 1;
				} else {
					int num = nums[level];
					newNums[level] = 1;
					for (int i = 1; i <= num; i++) {
						jump(nums, level + i, newNums);
					}
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

