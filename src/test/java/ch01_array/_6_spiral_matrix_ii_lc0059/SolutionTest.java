package ch01_array._6_spiral_matrix_ii_lc0059;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 59. 螺旋矩阵 II —— 本地测试。
 *
 * <p>用例取自力扣题面。
 */
class SolutionTest {

    @Test
    @DisplayName("示例 1：n=3 → [[1,2,3],[8,9,4],[7,6,5]]")
    void example1() {
        assertArrayEquals(
                new int[][] {
                    {1, 2, 3},
                    {8, 9, 4},
                    {7, 6, 5}
                },
                new Solution().generateMatrix(3));
    }

    @Test
    @DisplayName("示例 2：n=1 → [[1]]")
    void example2() {
        assertArrayEquals(new int[][] {{1}}, new Solution().generateMatrix(1));
    }

    @Test
    @DisplayName("边界：n=2 → [[1,2],[4,3]]")
    void twoByTwo() {
        assertArrayEquals(
                new int[][] {
                    {1, 2},
                    {4, 3}
                },
                new Solution().generateMatrix(2));
    }

    @Test
    @DisplayName("边界：n=4，整圈填满")
    void fourByFour() {
        assertArrayEquals(
                new int[][] {
                    {1, 2, 3, 4},
                    {12, 13, 14, 5},
                    {11, 16, 15, 6},
                    {10, 9, 8, 7}
                },
                new Solution().generateMatrix(4));
    }
}
