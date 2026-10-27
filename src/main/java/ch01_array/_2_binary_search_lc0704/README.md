# 704. 二分查找

> 本地学习目录。`Solution.java` 是你动手写的练习骨架，`SolutionTest.java` 是本地判题器。
> **先自己想，卡住了再往下看「思路」和「参考代码」。**

- **力扣链接**：<https://leetcode.cn/problems/binary-search/>
- **所属章节**：第 01 章 数组（对应《代码随想录》PDF 第 4–8 页）
- **本地包名**：`ch01_array._2_binary_search_lc0704`

---

## 题目描述

给定一个 `n` 个元素有序的（升序）整型数组 `nums` 和一个目标值 `target`，写一个函数搜索 `nums` 中的 `target`，如果 `target` 存在返回下标，否则返回 `-1`。

你必须编写一个具有 `O(log n)` 时间复杂度的算法。

### 示例 1

```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

### 示例 2

```
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```

### 提示

- 你可以假设 `nums` 中的所有元素是不重复的。
- `n` 将在 `[1, 10000]` 之间。
- `nums` 的每个元素都将在 `[-9999, 9999]` 之间。

---

## 思路

### 这道题的前提

**数组为有序数组**，同时题目强调**数组中无重复元素**。一旦有重复元素，使用二分查找返回的下标可能不是唯一的。这些是使用二分法的前提条件。

### 循环不变量

二分查找涉及的边界条件很多，逻辑比较简单，但就是写不好。写乱的主要原因是对**区间的定义**没有想清楚。

> **区间的定义就是不变量。** 在循环中每一次边界的处理都要坚持根据区间的定义来操作，这就是**循环不变量**规则。

写二分法，区间定义一般只有两种：

| 区间定义 | 循环条件 | 右边界收缩 | 原因 |
|---|---|---|---|
| 左闭右闭 `[left, right]` | `left <= right` | `right = middle - 1` | `left == right` 时区间依然有效 |
| 左闭右开 `[left, right)` | `left < right` | `right = middle` | `left == right` 时区间为空，没有意义 |

**一旦选定，整个循环里的边界处理必须自始至终遵守它，不能中途换。**

### 中点怎么算

用 `left + (right - left) / 2`（等价位运算 `>> 1`），避免 `left + right` 溢出。

---

## 参考代码（**先自己写再看**）

> 官方《代码随想录》Java 版实现。两种区间定义各一版，看懂原理后自己重写一遍。

### 版本一：左闭右闭区间 `[left, right]`

```java
class Solution {
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // nums[mid] > target
                right = mid - 1;
            }
        }
        // 未找到目标值
        return -1;
    }
}
```

### 版本二：左闭右开区间 `[left, right)`

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // nums[mid] > target
                right = mid;
            }
        }
        // 未找到目标值
        return -1;
    }
}
```

- **时间复杂度**：`O(log n)`
- **空间复杂度**：`O(1)`

---

## 相关题目推荐

- [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/)
- [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)
- [69. x 的平方根](https://leetcode.cn/problems/sqrtx/)
- [367. 有效的完全平方数](https://leetcode.cn/problems/valid-perfect-square/)
