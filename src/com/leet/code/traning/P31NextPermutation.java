//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 643 👎 0

package com.leet.code.traning;

//java:下一个排列
public class P31NextPermutation {
	public static void main(String[] args) {
		Solution solution = new P31NextPermutation().new Solution();
		solution.nextPermutation(new int[]{1,5,1});
	}

	// 0 4 3 2 1
	// 1 3 4 2 7 6 5 3

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void nextPermutation(int[] nums) {
			if (nums == null || nums.length == 1) {
				return;
			}
			//先判断是不是最大序列
			boolean flag = true;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] < nums[i + 1]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				for (int i = 0; i < nums.length - 1; i++) {
					for (int j = 0; j < nums.length - i - 1; j++) {
						int start = nums[j];
						int next = nums[j + 1];
						if (next < start) {
							nums[j] = next;
							nums[j + 1] = start;
						}

					}
				}
				return;
			}

			for( int end=nums.length-1;end>0;end--){
				if(nums[end]>nums[end-1]){
					for(int j=nums.length-1;j>=end;j--){
						if(nums[j]>nums[end-1]){
							int temp = nums[end-1];
							nums[end-1] = nums[j];
							nums[j] = temp;
							break;
						}
					}
					System.out.println("111");
					int i = end;
					for(int j=nums.length-1;j>=i;j--,i++){
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					}

					break;
				}
			}


		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

