package ch01_array._6_spiral_matrix_ii_lc0059;

/**
 * 59. 螺旋矩阵 II
 *
 * <p>力扣链接：<a href="https://leetcode.cn/problems/spiral-matrix-ii/">https://leetcode.cn/problems/spiral-matrix-ii/</a>
 *
 * <p>题面：给你一个正整数 n，生成一个包含 1 到 n² 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix。
 *
 * <p>示例 1：n = 3 → [[1,2,3],[8,9,4],[7,6,5]]
 * <p>示例 2：n = 1 → [[1]]
 *
 * <p>提示：1 &lt;= n &lt;= 20。
 *
 * @see <a href="README.md">本题题面与思路（点击查看）</a>
 */
public class Solution {

    /**
     * 生成按顺时针螺旋排列的 n x n 矩阵，包含 1 到 n²。
     *
     * <p>本题<b>不涉及任何算法</b>，纯粹是<b>模拟</b>，但十分考察对代码的掌控能力。
     *
     * <p><b>模拟顺时针填充四条边</b>：
     * <ol>
     *   <li>填充上行：从左到右</li>
     *   <li>填充右列：从上到下</li>
     *   <li>填充下行：从右到左</li>
     *   <li>填充左列：从下到上</li>
     * </ol>
     * 由外向内一圈一圈画下去。
     *
     * <p><b>画一整圈只有一条铁律：每条边都统一按「左闭右开」遍历。</b>
     * 拐角处让给<b>新的那一条边</b>继续画，这样四条边合起来才不重不漏。
     * 很多同学写不对，就是一会儿左开右闭、一会儿左闭右开，规则不统一。
     *
     * <p>另外：n 为奇数时，最中间那个位置不会被任何一条边覆盖，需要<b>单独赋值</b>。
     *
     * @param n 矩阵边长
     * @return 螺旋排列的 n x n 矩阵
     */
    public int[][] generateMatrix(int n) {
        // TODO: 用模拟（每条边统一左闭右开）实现螺旋填充
        throw new UnsupportedOperationException("TODO: 实现螺旋矩阵");
    }
}