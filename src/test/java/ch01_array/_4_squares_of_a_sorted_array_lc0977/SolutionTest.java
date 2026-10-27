package ch01_array._4_squares_of_a_sorted_array_lc0977;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 977. 有序数组的平方 —— 本地测试。
 *
 * <p>用例取自力扣题面。
 */
class SolutionTest {

    @Test
    @DisplayName("示例 1：nums=[-4,-1,0,3,10] → [0,1,9,16,100]")
    void example1() {
        assertArrayEquals(
                new int[] {0, 1, 9, 16, 100},
                new Solution().sortedSquares(new int[] {-4, -1, 0, 3, 10}));
    }

    @Test
    @DisplayName("示例 2：nums=[-7,-3,2,3,11] → [4,9,9,49,121]")
    void example2() {
        assertArrayEquals(
                new int[] {4, 9, 9, 49, 121},
                new Solution().sortedSquares(new int[] {-7, -3, 2, 3, 11}));
    }

    @Test
    @DisplayName("边界：只有一个元素")
    void singleElement() {
        assertArrayEquals(new int[] {9}, new Solution().sortedSquares(new int[] {3}));
        assertArrayEquals(new int[] {9}, new Solution().sortedSquares(new int[] {-3}));
    }

    @Test
    @DisplayName("边界：全为负数")
    void allNegative() {
        assertArrayEquals(
                new int[] {1, 4, 9, 16},
                new Solution().sortedSquares(new int[] {-4, -3, -2, -1}));
    }

    @Test
    @DisplayName("边界：全为非负数")
    void allPositive() {
        assertArrayEquals(
                new int[] {1, 4, 9, 16},
                new Solution().sortedSquares(new int[] {1, 2, 3, 4}));
    }
}
