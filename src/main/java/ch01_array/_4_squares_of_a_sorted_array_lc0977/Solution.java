package ch01_array._4_squares_of_a_sorted_array_lc0977;

/**
 * 977. 有序数组的平方
 *
 * <p>力扣链接：<a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">https://leetcode.cn/problems/squares-of-a-sorted-array/</a>
 *
 * <p>题面：给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，
 * 要求也按非递减顺序排序。
 *
 * <p>示例 1：nums = [-4,-1,0,3,10] → 输出 [0,1,9,16,100]
 * <p>示例 2：nums = [-7,-3,2,3,11] → 输出 [4,9,9,49,121]
 *
 * <p>提示：1 &lt;= nums.length &lt;= 10^4，-10^4 &lt;= nums[i] &lt;= 10^4，nums 已按非递减顺序排序。
 * <p>进阶：请你设计时间复杂度为 O(n) 的算法解决本问题。
 *
 * @see <a href="README.md">本题题面与思路（点击查看）</a>
 */
public class Solution {

    /**
     * 返回每个数字的平方组成的新数组，且按非递减顺序排序。
     *
     * <p><b>为什么不能直接平方后排序？</b>那需要 O(n + n log n) 时间。题目要求 O(n)，所以要另辟蹊径。
     *
     * <p><b>双指针法的核心观察</b>：
     * 数组本身是有序的，只不过<b>负数平方之后可能变成最大值</b>。
     * 因此平方后的最大值一定在数组的<b>两端</b>（最左或最右），绝不可能在中间。
     *
     * <p>于是：左右两个指针分别从数组两端向中间靠拢，每次把<b>较大</b>的那个平方
     * 填进结果数组的<b>末尾</b>（result 数组从后往前填），这样结果自然就是升序的。
     *
     * <p>写的时候注意：循环条件用 {@code left <= right}（不是 &lt;），
     * 因为最后还剩两个元素时也要处理。
     *
     * @param nums 按非递减顺序排序的整数数组
     * @return 每个数字的平方组成的新数组，按非递减顺序排列
     */
    public int[] sortedSquares(int[] nums) {
        // TODO: 用双指针实现 O(n) 的平方
        throw new UnsupportedOperationException("TODO: 实现双指针");
    }
}