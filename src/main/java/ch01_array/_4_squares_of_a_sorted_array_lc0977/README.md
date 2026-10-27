# 977. 有序数组的平方

> 本地学习目录。`Solution.java` 是你动手写的练习骨架，`SolutionTest.java` 是本地判题器。
> **先自己想，卡住了再往下看「思路」和「参考代码」。**

- **力扣链接**：<https://leetcode.cn/problems/squares-of-a-sorted-array/>
- **所属章节**：第 01 章 数组（对应《代码随想录》PDF 第 12–15 页）
- **本地包名**：`ch01_array._4_squares_of_a_sorted_array_lc0977`

---

## 题目描述

给你一个按**非递减顺序**排序的整数数组 `nums`，返回**每个数字的平方**组成的新数组，要求也按**非递减顺序**排序。

### 示例 1

```
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
```

### 示例 2

```
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
```

### 提示

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` 已按**非递减顺序**排序

### 进阶

请你设计时间复杂度为 `O(n)` 的算法解决本问题。

---

## 思路

### 暴力排序（`O(n + n log n)`）

最直观的想法：每个数平方之后，排个序。

```java
int[] sortedSquares(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        nums[i] *= nums[i];
    }
    Arrays.sort(nums);
    return nums;
}
```

时间是 `O(n + n log n)`，可以说就是 `O(n log n)`。但题目要求 `O(n)`，所以要另辟蹊径。

### 双指针法（`O(n)`）—— 推荐

**核心观察**：数组其实是有序的，只不过**负数平方之后可能成为最大值**。

那么数组平方的最大值就在数组的**两端**，不是最左边就是最右边，**不可能是中间**。此时就可以考虑双指针了。

- `i` 指向起始位置，`j` 指向终止位置；
- 定义一个和原数组一样大小的新数组 `result`，让 `k` 指向 `result` 的终止位置；
- 每次比较 `nums[i]²` 和 `nums[j]²`，**把大的那个填到 `result` 的末尾**（`k--`），并移动对应指针。

这样结果自然就是升序的。

> **写的时候注意**：循环条件用 `i <= j`（不是 `<`），因为最后要处理两个元素。

> 不必太在意力扣上的执行用时、击败了多少用户，那个是个玩具，很不准确。做题时自己能分析出时间复杂度就可以了。

---

## 参考代码（**先自己写再看**）

> 官方《代码随想录》Java 版实现。

### 版本一：排序法

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
```

### 版本二：双指针法（`O(n)`）

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的，需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
```

### 版本三：双指针法（更简洁）

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int j = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[j--] = nums[l] * nums[l++];
            } else {
                res[j--] = nums[r] * nums[r--];
            }
        }
        return res;
    }
}
```

- **时间复杂度**：`O(n)`
- **空间复杂度**：`O(n)`（双指针法需要结果数组；排序法是 `O(log n)`）

---

## 相关题目推荐

- [977 的同族：合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/)
- [283. 移动零](https://leetcode.cn/problems/move-zeroes/)
