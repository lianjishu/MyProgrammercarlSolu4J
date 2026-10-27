# 209. 长度最小的子数组

> 本地学习目录。`Solution.java` 是你动手写的练习骨架，`SolutionTest.java` 是本地判题器。
> **先自己想，卡住了再往下看「思路」和「参考代码」。**

- **力扣链接**：<https://leetcode.cn/problems/minimum-size-subarray-sum/>
- **所属章节**：第 01 章 数组（对应《代码随想录》PDF 第 15–19 页）
- **本地包名**：`ch01_array._5_minimum_size_subarray_sum_lc0209`

---

## 题目描述

给定一个含有 `n` 个正整数的数组和一个正整数 `target`，找出该数组中满足其总和大于等于 `target` 的**长度最小的子数组**，并返回其长度。如果不存在符合条件的子数组，返回 `0`。

### 示例 1

```
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
```

### 示例 2

```
输入：target = 4, nums = [1,4,4]
输出：1
```

### 示例 3

```
输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
```

### 提示

- `1 <= target <= 10^9`
- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`

---

## 思路

### 暴力解法（`O(n²)`）

两个 for 循环，不断寻找符合条件的子序列。

```java
int minSubArrayLen(int s, int[] nums) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= s) {
                result = Math.min(result, j - i + 1);
                break; // 找到符合条件的最短子序列就 break
            }
        }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
}
```

> 力扣后来更新了数据，**暴力解法已经超时**。

### 滑动窗口（`O(n)`）—— 推荐

所谓滑动窗口，就是不断地调节子序列的起始位置和终止位置，从而得出我们想要的结果。

**滑动窗口其实是双指针法的一种**，只不过这种解法更像是「一个窗口的移动」，所以叫滑动窗口更贴切。

**首先要思考：只有一个循环时，这个循环的索引表示什么？**

如果只用一个 for 循环来表示滑动窗口的**起始位置**，那么怎么遍历剩下的结束位置？难免又陷入暴力解法的怪圈。所以只用一个循环时，这个循环的索引**一定是表示滑动窗口的终止位置**。

**实现滑动窗口，主要确定如下三点：**

1. **窗口内是什么？** 满足其和 ≥ target 的长度最小的连续子数组。
2. **窗口的起始位置如何移动？** 如果当前窗口的值大于等于 target 了，窗口就要向前移动了（也就是该缩小了）。
3. **窗口的结束位置如何移动？** 就是遍历数组的指针，也就是循环里的索引。

> **解题的关键在于窗口的起始位置如何移动。**

滑动窗口的精妙之处在于：根据当前子序列和的大小情况，不断调节子序列的起始位置，从而将 `O(n²)` 暴力解法降为 `O(n)`。

### 为什么是 `O(n)` 而不是 `O(n²)`？

别被 for 里套 while 吓到，主要是看**每一个元素被操作的次数**：每个元素进窗口操作一次、出窗口操作一次，总共只被操作 2 次，所以时间复杂度是 `2 × n` 也就是 `O(n)`。

---

## 参考代码（**先自己写再看**）

> 官方《代码随想录》Java 版实现。

### 版本一：滑动窗口（`O(n)`）

```java
class Solution {
    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
```

**逐行读懂：**

| 代码 | 含义 |
|---|---|
| `sum += nums[right]` | 窗口的**右边界**扩展 |
| `while (sum >= s)` | 窗口内已经够了，就不断**收缩左边界**，每收缩一次就记录一次更短的长度 |
| `sum -= nums[left++]` | 左端元素移出窗口，`left` 右移（**滑动窗口的精髓**） |
| `result == Integer.MAX_VALUE` | 从未满足条件 → 返回 0 |

- **时间复杂度**：`O(n)`
- **空间复杂度**：`O(1)`

---

## 相关题目推荐

- [904. 水果成篮](https://leetcode.cn/problems/fruit-into-baskets/)
- [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)
- [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)
