# 59. 螺旋矩阵 II

> 本地学习目录。`Solution.java` 是你动手写的练习骨架，`SolutionTest.java` 是本地判题器。
> **先自己想，卡住了再往下看「思路」和「参考代码」。**

- **力扣链接**：<https://leetcode.cn/problems/spiral-matrix-ii/>
- **所属章节**：第 01 章 数组（对应《代码随想录》PDF 第 19–22 页）
- **本地包名**：`ch01_array._6_spiral_matrix_ii_lc0059`

---

## 题目描述

给你一个正整数 `n`，生成一个包含 `1` 到 `n²` 所有元素，且元素按**顺时针顺序螺旋排列**的正方形矩阵 `matrix`。

### 示例 1

```
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
```

### 示例 2

```
输入：n = 1
输出：[[1]]
```

### 提示

- `1 <= n <= 20`

---

## 思路

### 本题不涉及任何算法，就是模拟

但十分考察对代码的掌控能力。自信地拿到这道题，只需要按部就班地模拟即可。

很多同学刚开始做这种题目的时候，上来就是一波判断猛于虎，结果运行时各种问题，然后开始各种修修补补，最后发现改了这儿那儿有问题，改了那儿这儿又跑不起来了。

### 模拟顺时针画矩阵的过程

1. 填充上行：从左到右
2. 填充右列：从上到下
3. 填充下行：从右到左
4. 填充左列：从下到上

由外向内，一圈一圈这么画下去。

### 铁律：每条边统一按「左闭右开」遍历

边界条件非常多，在一个循环中如此多的边界条件，**如果不按照固定规则来遍历，那就是一进循环深似海，从此 offer 是路人**。

画一整圈要画四条边，每画一条边都要坚持一致的左闭右开（或左开右闭）原则，这样这一圈才能按统一的规则画下来。**拐角处让给新的一条边来继续画。**

很多同学写这道题一直写不好、代码越写越乱，就是因为画每一条边的时候一会儿左开右闭、一会儿左闭右开，规则不统一。

> 求解本题依然要坚持**循环不变量原则**（和二分查找里讲的一样）。

### 另一个细节

`n` 为奇数时，矩阵最中间那个位置不会被任何一条边覆盖，**需要单独赋值**。

---

## 参考代码（**先自己写再看**）

> 官方《代码随想录》Java 版实现。

### 版本一：起始点 + offset（每条边统一左闭右开）

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;  // 每一圈的起始点
        int offset = 1;
        int count = 1;  // 矩阵中需要填写的数字
        int loop = 1;   // 记录当前的圈数
        int i, j;       // j 代表列, i 代表行

        while (loop <= n / 2) {

            // 顶部：左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            // 右列：左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部：左闭右开，所以判断循环结束时， j != startY
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }

            // 左列：左闭右开，所以判断循环结束时， i != startX
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }
}
```

### 版本二：定义四个边界（思路更清晰，推荐）

```java
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        // 初始化 n x n 矩阵
        int[][] matrix = new int[n][n];

        // 初始化边界和起始值
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // 从左到右填充上边界
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // 从上到下填充右边界
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 从右到左填充下边界
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // 从下到上填充左边界
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
```

- **时间复杂度**：`O(n²)`（模拟遍历二维矩阵）
- **空间复杂度**：`O(1)`（不计返回值）

---

## 类似题目

- [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)
- [剑指 Offer 29. 顺时针打印矩阵](https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)
