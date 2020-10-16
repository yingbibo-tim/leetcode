//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 726 👎 0

package com.leet.code.traning;

import com.sun.xml.internal.xsom.impl.scd.Step;

//java:跳跃游戏 II
public class P45JumpGameIi {
	public static void main(String[] args) {
		Solution solution = new P45JumpGameIi().new Solution();
		System.out.println(solution.jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
		System.out.println(solution.jump(new int[]{1,2,3}));
		System.out.println(solution.jump(new int[]{3,2,1}));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int jump(int[] nums) {
			int index = 0;
			int stepCount = 1;
			while (index < nums.length-1) {
				stepCount++;
				int length = nums[index];
				int max = -1;
				int startIndex = index+1;
				int endIndex =  Math.min(index + length + 1,nums.length);
				if(index+length+1>=nums.length){
					break;
				}

				for (int i = startIndex; i < endIndex; i++) {
					if (i+nums[i] >= max) {
						index = i;
						max = nums[i]+i;
					}
				}
			}
			return stepCount-1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

