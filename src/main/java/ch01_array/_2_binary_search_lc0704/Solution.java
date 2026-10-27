package ch01_array._2_binary_search_lc0704;

/**
 * 704. 二分查找
 *
 * <p>力扣链接：<a href="https://leetcode.cn/problems/binary-search/">https://leetcode.cn/problems/binary-search/</a>
 *
 * <p>题面：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 *
 * <p>提示：
 * <ul>
 *   <li>你可以假设 nums 中的所有元素是不重复的。</li>
 *   <li>n 将在 [1, 10000] 之间。</li>
 *   <li>nums 的每个元素都将在 [-9999, 9999] 之间。</li>
 * </ul>
 *
 * @see <a href="README.md">本题题面与思路（点击查看）</a>
 */
public class Solution {

    /**
     * 在有序数组 nums 中查找 target，返回其下标；不存在返回 -1。
     *
     * <p><b>实现前请先想清楚这三件事</b>（这就是「循环不变量」）：
     * <ol>
     *   <li><b>区间的定义是什么？</b>只有两种：
     *       <ul>
     *         <li>左闭右闭 {@code [left, right]} → 循环条件用 {@code left <= right}，
     *             右边界收缩为 {@code right = mid - 1}</li>
     *         <li>左闭右开 {@code [left, right)} → 循环条件用 {@code left < right}，
     *             右边界收缩为 {@code right = mid}</li>
     *       </ul>
     *       一旦选定，整个循环里的边界处理必须自始至终遵守它，不能中途换。</li>
     *   <li><b>中点怎么算？</b>用 {@code left + (right - left) / 2}（等价位运算 {@code >> 1}），
     *       避免 {@code left + right} 溢出。</li>
     *   <li><b>比较后往哪边缩？</b>看 target 落在哪个子区间，就把区间收成那个子区间，
     *       而不是「排除掉中点就完事」。</li>
     * </ol>
     *
     * <p>本题前提：数组有序 + 元素不重复（否则二分返回的下标可能不唯一）。
     *
     * @param nums   升序排列的整型数组
     * @param target 目标值
     * @return target 的下标，不存在则返回 -1
     */
    public int search(int[] nums, int target) {
        // TODO: 用你选定的区间定义（并把定义写进注释）实现二分查找
        throw new UnsupportedOperationException("TODO: 实现二分查找");
    }
}