package ch01_array._3_remove_element_lc0027;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 27. 移除元素 —— 本地测试。
 *
 * <p>判题方式与力扣一致：返回长度 k，并把 nums 的前 k 个元素排序后与期望值比对
 * （题目允许元素顺序改变，所以排序后再比较）。
 */
class SolutionTest {

    @Test
    @DisplayName("示例 1：nums=[3,2,2,3], val=3 → 返回 2，前两个元素均为 2")
    void example1() {
        int[] nums = {3, 2, 2, 3};
        int k = new Solution().removeElement(nums, 3);

        assertEquals(2, k);
        int[] expected = {2, 2};
        Arrays.sort(nums, 0, k);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }

    @Test
    @DisplayName("示例 2：nums=[0,1,2,2,3,0,4,2], val=2 → 返回 5，前五个元素为 0,1,3,0,4")
    void example2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int k = new Solution().removeElement(nums, 2);

        assertEquals(5, k);
        int[] expected = {0, 1, 3, 0, 4};
        Arrays.sort(nums, 0, k);
        Arrays.sort(expected);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }

    @Test
    @DisplayName("边界：val 不存在于数组中，原数组保持不变")
    void valueNotPresent() {
        int[] nums = {1, 2, 3};
        int k = new Solution().removeElement(nums, 99);

        assertEquals(3, k);
        assertArrayEquals(new int[] {1, 2, 3}, nums);
    }

    @Test
    @DisplayName("边界：所有元素都等于 val，返回 0")
    void allElementsRemoved() {
        int[] nums = {4, 4, 4};
        assertEquals(0, new Solution().removeElement(nums, 4));
    }

    @Test
    @DisplayName("边界：空数组，返回 0")
    void emptyArray() {
        assertEquals(0, new Solution().removeElement(new int[] {}, 3));
    }
}
