package ch01_array._5_minimum_size_subarray_sum_lc0209;

/**
 * 209. 长度最小的子数组
 *
 * <p>力扣链接：<a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">https://leetcode.cn/problems/minimum-size-subarray-sum/</a>
 *
 * <p>题面：给定一个含有 n 个正整数的数组和一个正整数 target，
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * <p>示例 1：target = 7, nums = [2,3,1,2,4,3] → 2（子数组 [4,3]）
 * <p>示例 2：target = 4, nums = [1,4,4] → 1
 * <p>示例 3：target = 11, nums = [1,1,1,1,1,1,1,1] → 0
 *
 * <p>提示：1 &lt;= target &lt;= 10^9，1 &lt;= nums.length &lt;= 10^5，1 &lt;= nums[i] &lt;= 10^4。
 *
 * @see <a href="README.md">本题题面与思路（点击查看）</a>
 */
public class Solution {

    /**
     * 找出和大于等于 target 的长度最小的连续子数组，返回其长度；不存在则返回 0。
     *
     * <p><b>滑动窗口</b>——本方法推荐用这个思路：
     * 滑动窗口其实是双指针法的一种，只不过更像一个「窗口」在移动。
     *
     * <p>要确定三件事：
     * <ol>
     *   <li><b>窗口内是什么？</b>满足「和 ≥ target」的最短连续子数组。</li>
     *   <li><b>窗口的结束位置怎么移动？</b>就是遍历数组的循环下标 right，<b>只往右走</b>。</li>
     *   <li><b>窗口的起始位置怎么移动？</b>一旦当前窗口和 ≥ target，就记录长度，
     *       然后把左端元素移出窗口、left 右移，<b>不断收缩</b>直到窗口和 &lt; target。</li>
     * </ol>
     *
     * <p><b>为什么是 O(n) 而不是 O(n^2)？</b>别被 for 里套 while 吓到：
     * 每个元素进窗口一次、出窗口一次，总共只被操作 2 次，所以是 O(n)。
     *
     * <p>返回 0 的情况：如果 result 从未被更新过，说明不存在符合条件的子数组。
     *
     * @param target 目标和下界
     * @param nums   含有正整数的数组
     * @return 长度最小的子数组长度，不存在则返回 0
     */
    public int minSubArrayLen(int target, int[] nums) {
        // TODO: 用滑动窗口实现
        throw new UnsupportedOperationException("TODO: 实现滑动窗口");
    }
}