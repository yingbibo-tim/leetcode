//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 652 👎 0

package com.leet.code.traning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//java:合并区间
public class P56MergeIntervals {
	public static void main(String[] args) {
		Solution solution = new P56MergeIntervals().new Solution();
		solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[][] merge(int[][] intervals) {

			List<int[]> list = new ArrayList<>();
			Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
			int[] repit = new int[intervals.length];
			for (int i = 0; i < intervals.length; i++) {
				if(repit[i]==0) {
					repit[i] = 1;
					int start = intervals[i][0];
					int end = intervals[i][1];
					for (int j = i + 1; j < intervals.length; j++) {
						if(repit[j]==0) {
							int compareStart = intervals[j][0];
							int compareEnd = intervals[j][1];
							int maxStart = Math.max(start,compareStart);
							int minEnd = Math.min(end,compareEnd);
							if(minEnd>=maxStart){
								start = Math.min(start,compareStart);
								end = Math.max(end,compareEnd);
								repit[j] = 1;
							}
						}
					}
					int[] nums = new int[]{start,end};
					list.add(nums);
				}
			}
			int[][] result  =new int[list.size()][2];
			for(int i=0;i<list.size();i++){
				result[i] = list.get(i);
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

