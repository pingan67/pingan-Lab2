import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 */
//class Solution3 {
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        int len = nums.length-1;
//        Arrays.sort(nums);
//
//        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
//        int[] dp = new int[len];
//        Arrays.fill(dp, 1);
//        int maxSize = 1;
//        int maxVal = dp[0];
//        for (int i = 1; i < len; i++) {
//            for (int j = 1; j < i; j++) {
//                // 题目中说「没有重复元素」很重要
//                if (nums[i] % nums[j] == 0) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//
//            if (dp[i] > maxSize) {
//                maxSize = dp[i];
//                maxVal = i;
//            }
//        }
//
//        // 第 2 步：倒推获得最大子集
//        List<Integer> res = new ArrayList<Integer>();
//        if (maxSize == 1) {
//            res.add(nums[0]);
//            return res;
//        }
//
//        for (int i = len - 1; i >= 0; i--) {
//            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
//                res.add(nums[i]);
//                maxVal = nums[i];
//                maxSize--;
//            }
//        }
//        return res;
//    }
//}
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//class Solution3 {
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums); // 先对数组进行排序
//
//        int n = nums.length;
//        int[] dp = new int[n]; // dp[i] 表示以 nums[i] 结尾的最大整除子集的大小
//        Arrays.fill(dp, 1); // 初始化，每个元素自身构成一个子集
//
//        int maxSize = 1; // 最大整除子集的大小
//        int maxIndex = 0; // 最大整除子集中最后一个元素的索引
//
//        // 动态规划计算最大整除子集的大小
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] % nums[j] == 0) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            if (dp[i] > maxSize) {
//                maxSize = dp[i];
//                maxIndex = i;
//            }
//        }
//
//        // 从最大元素开始倒推构建最大整除子集
//        List<Integer> result = new ArrayList<>();
//        for (int i = maxIndex; i >= 0; i--) {
//            if (dp[i] == maxSize) {
//                result.add(nums[i]);
//                maxSize--; // 逐步减小，确保只加入当前最大整除子集的元素
//            }
//        }
//        // 由于是从后往前添加，结果集已经是正确的顺序，无需反转
//        return result;
//    }
//}
class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // 先对数组进行排序

        int n = nums.length;
        int[] dp = new int[n]; // dp[i] 表示以 nums[i] 结尾的最大整除子集的大小
        Arrays.fill(dp, 1); // 初始化，每个元素自身构成一个子集

        int maxSize = 1; // 最大整除子集的大小
        int maxIndex = 0; // 最大整除子集中最后一个元素的索引

        // 动态规划计算最大整除子集的大小
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // 从最大元素开始倒推构建最大整除子集
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == maxSize) {
                result.add(nums[i]);
                maxSize--; // 逐步减小，确保只加入当前最大整除子集的元素
            }
        }
        // 由于是从后往前添加，结果集已经是正确的顺序，无需反转
        return result;
    }
}

//我认为改正非常正确没有瑕疵


