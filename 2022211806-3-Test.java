import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class Solution3Test {


        @Test
        public void testNormalInput() {
            // 测试目的：验证方法在正常输入下的正确性
            // 用到的测试用例：包含不同正整数的数组
            Solution3 solution = new Solution3();
            int[] nums1 = {1, 2, 3};
            List<Integer> result1 = solution.largestDivisibleSubset(nums1);
            assertTrue(result1.containsAll(List.of(1, 2)) || result1.containsAll(List.of(1, 3)));

            int[] nums2 = {1, 2, 4, 8};
            List<Integer> result2 = solution.largestDivisibleSubset(nums2);
            assertEquals(List.of(1, 2, 4, 8), result2);


        }

        @Test
        public void testBoundaryInput() {
            // 测试目的：验证方法在边界输入下的正确性
            // 用到的测试用例：空数组、只包含一个元素的数组
            Solution3 solution = new Solution3();
            int[] nums1 = {};
            List<Integer> result1 = solution.largestDivisibleSubset(nums1);
            assertTrue(result1.isEmpty());

            int[] nums2 = {1};
            List<Integer> result2 = solution.largestDivisibleSubset(nums2);
            assertEquals(List.of(1), result2);
        }

        @Test
        public void testSingleLargestElement() {
            // 测试目的：验证当数组中存在一个元素远大于其他元素时的正确性
            // 用到的测试用例：包含一个远大于其他元素的数组
            Solution3 solution = new Solution3();
            int[] nums = {1, 2, 3, 1000000000};
            List<Integer> result = solution.largestDivisibleSubset(nums);
            assertTrue(result.contains(1000000000) || result.containsAll(List.of(1, 2, 3)));
            // 注意：由于题目要求返回任何一个有效解子集，所以这里的结果可能包含1, 2, 3或者只包含1000000000
        }

        // 注意：由于题目限制了输入为正整数且无重复，因此没有测试包含小数或重复元素的数组。

    }



