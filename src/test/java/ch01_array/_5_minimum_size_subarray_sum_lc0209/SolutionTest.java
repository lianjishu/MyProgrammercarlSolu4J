package ch01_array._5_minimum_size_subarray_sum_lc0209;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 209. 长度最小的子数组 —— 本地测试。
 *
 * <p>用例取自力扣题面。
 */
class SolutionTest {

    @Test
    @DisplayName("示例 1：target=7, nums=[2,3,1,2,4,3] → 2")
    void example1() {
        assertEquals(2, new Solution().minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }

    @Test
    @DisplayName("示例 2：target=4, nums=[1,4,4] → 1")
    void example2() {
        assertEquals(1, new Solution().minSubArrayLen(4, new int[] {1, 4, 4}));
    }

    @Test
    @DisplayName("示例 3：target=11, nums=[1,1,1,1,1,1,1,1] → 0（不存在）")
    void example3() {
        assertEquals(0, new Solution().minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    @DisplayName("边界：子数组和恰好等于 target（[2,3] 之和正好是 5）")
    void exactMatch() {
        assertEquals(2, new Solution().minSubArrayLen(5, new int[] {2, 3, 1}));
    }

    @Test
    @DisplayName("边界：单个元素就已超过 target，长度为 1")
    void singleElementSuffices() {
        assertEquals(1, new Solution().minSubArrayLen(5, new int[] {2, 3, 9}));
    }

    @Test
    @DisplayName("边界：整个数组才够")
    void wholeArrayNeeded() {
        assertEquals(3, new Solution().minSubArrayLen(6, new int[] {1, 2, 3}));
    }
}
