//给定一个包含 n 个整数的数组 nums 和一个目标值 target，
// 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 552 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:四数之和
public class P18FourSum {
	public static void main(String[] args) {
		Solution solution = new P18FourSum().new Solution();
		System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			List<List<Integer>> resultList = new ArrayList<>();
			if (nums == null || nums.length < 4) {
				return resultList;
			}
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 3; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}

				int index1 = i;
				int num1 = nums[index1];
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j > i + 1 && nums[j] == nums[j - 1]) {
						continue;
					}

					int index2 = j;
					int index3 = j + 1;
					int index4 = nums.length - 1;
					int num2 = nums[index2];
					while (index3 < index4) {
						int num3 = nums[index3];
						int num4 = nums[index4];
						if (num1 + num2 + num3 + num4 == target) {
							List<Integer> list = new ArrayList<>();
							list.add(num1);
							list.add(num2);
							list.add(num3);
							list.add(num4);
							resultList.add(list);
							while (index3 < index4 && nums[index3 + 1] == nums[index3]) {
								index3++;
							}
							while (index3 < index4 && nums[index4 - 1] == nums[index4]) {
								index4--;
							}
							index3++;
							index4--;


						} else if (num1 + num2 + num3 + num4 > target) {
							index4--;
						} else {
							index3++;
						}
					}
				}

			}
			return resultList;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

