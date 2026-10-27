package ch01_array._3_remove_element_lc0027;

/**
 * 27. 移除元素
 *
 * <p>力扣链接：<a href="https://leetcode.cn/problems/remove-element/">https://leetcode.cn/problems/remove-element/</a>
 *
 * <p>题面：给你一个数组 nums 和一个值 val，你需要 <b>原地</b> 移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变，你不需要考虑数组中超出新长度后面的元素。
 *
 * <p>示例 1：nums = [3,2,2,3], val = 3 → 返回 2，且 nums 前两个元素均为 2。
 * <p>示例 2：nums = [0,1,2,2,3,0,4,2], val = 2 → 返回 5，且 nums 前五个元素为 0,1,3,0,4。
 *
 * <p>提示：0 &lt;= nums.length &lt;= 100，0 &lt;= nums[i] &lt;= 50，0 &lt;= val &lt;= 100。
 *
 * @see <a href="README.md">本题题面与思路（点击查看）</a>
 */
public class Solution {

    /**
     * 原地移除 nums 中所有等于 val 的元素，返回移除后数组的新长度。
     *
     * <p><b>关键认知：数组的元素不能「删」，只能「覆盖」。</b>
     * 数组元素在内存地址上是连续的，无法单独释放某个元素，只能用后面的元素把它覆盖掉。
     *
     * <p><b>双指针法（快慢指针）</b>——本方法推荐用这个思路：
     * <ul>
     *   <li><b>快指针 fast</b>：负责遍历整个数组，去<b>寻找</b>新数组的元素，
     *       也就是那些不等于 val 的元素。</li>
     *   <li><b>慢指针 slow</b>：指向<b>写入</b>新数组的下标位置，
     *       指向新数组中下一个该放元素的位置。</li>
     * </ul>
     * 一次循环干两件事，所以比暴力解法的两层循环少一个数量级的时间复杂度。
     *
     * <p>注意：双指针法<b>不会改变元素的相对顺序</b>；题目允许改变顺序，
     * 所以也有「相向双指针」等移动元素更少的解法（见 README）。
     *
     * @param nums 待处理的数组（会被原地修改）
     * @param val  要移除的值
     * @return 移除后数组的长度 k，nums 的前 k 个元素即为结果
     */
    public int removeElement(int[] nums, int val) {
        // TODO: 用快慢指针实现原地移除
        throw new UnsupportedOperationException("TODO: 实现快慢指针");
    }
}