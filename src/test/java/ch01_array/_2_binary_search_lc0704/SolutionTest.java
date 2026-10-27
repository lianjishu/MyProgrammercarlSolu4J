package ch01_array._2_binary_search_lc0704;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 704. 二分查找 —— 本地测试。
 *
 * <p>用例取自力扣题面。写好 {@link Solution#search(int[], int)} 后运行本测试即可自测，
 * 不需要去力扣 OJ 提交。
 */
class SolutionTest {

    @Test
    @DisplayName("示例 1：target 存在，返回下标 4")
    void example1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(4, new Solution().search(nums, 9));
    }

    @Test
    @DisplayName("示例 2：target 不存在，返回 -1")
    void example2() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(-1, new Solution().search(nums, 2));
    }

    @Test
    @DisplayName("边界：target 是第一个元素")
    void targetIsFirst() {
        assertEquals(0, new Solution().search(new int[] {-1, 0, 3, 5, 9, 12}, -1));
    }

    @Test
    @DisplayName("边界：target 是最后一个元素")
    void targetIsLast() {
        assertEquals(5, new Solution().search(new int[] {-1, 0, 3, 5, 9, 12}, 12));
    }

    @Test
    @DisplayName("边界：只有一个元素")
    void singleElement() {
        assertEquals(0, new Solution().search(new int[] {5}, 5));
        assertEquals(-1, new Solution().search(new int[] {5}, 3));
    }

    @Test
    @DisplayName("边界：target 小于最小值 / 大于最大值")
    void outOfRange() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(-1, new Solution().search(nums, -100));
        assertEquals(-1, new Solution().search(nums, 100));
    }
}
