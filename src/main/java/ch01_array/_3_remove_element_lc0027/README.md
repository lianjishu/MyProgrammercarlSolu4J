# 27. 移除元素

> 本地学习目录。`Solution.java` 是你动手写的练习骨架，`SolutionTest.java` 是本地判题器。
> **先自己想，卡住了再往下看「思路」和「参考代码」。**

- **力扣链接**：<https://leetcode.cn/problems/remove-element/>
- **所属章节**：第 01 章 数组（对应《代码随想录》PDF 第 8–12 页）
- **本地包名**：`ch01_array._3_remove_element_lc0027`

---

## 题目描述

给你一个数组 `nums` 和一个值 `val`，你需要**原地**移除所有数值等于 `val` 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 `O(1)` 额外空间并**原地**修改输入数组。元素的顺序可以改变，你不需要考虑数组中超出新长度后面的元素。

### 示例 1

```
输入: nums = [3,2,2,3], val = 3
输出: 2, nums = [2,2,_,_]
解释: 你的函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
```

### 示例 2

```
输入: nums = [0,1,2,2,3,0,4,2], val = 2
输出: 5, nums = [0,1,4,0,3,_,_,_]
解释: 你的函数应该返回 k = 5, 并且 nums 中的前五个元素为 0,0,1,3,4。
注意这五个元素可以任意顺序返回。
```

### 提示

- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

---

## 思路

### 关键认知：数组的元素不能「删」，只能「覆盖」

数组的元素在内存地址中是**连续**的，不能单独删除数组中的某个元素，只能覆盖。删除下标为 `i` 的元素，需要对下标大于 `i` 的所有元素做移动操作。

### 暴力解法（`O(n²)`）

两层 for 循环：外层遍历数组元素，发现要移除的元素后，内层把后面所有元素整体前移一位，然后 `i--`、`size--`。

```java
// 时间复杂度：O(n^2)，空间复杂度：O(1)
int removeElement(int[] nums, int val) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        if (nums[i] == val) {
            for (int j = i + 1; j < n; j++) {
                nums[j - 1] = nums[j];
            }
            i--;
            n--;
        }
    }
    return n;
}
```

这道题暴力解法在力扣上是可以过的，但效率低。

### 双指针法（`O(n)`）—— 推荐

**通过一个快指针和慢指针，在一个 for 循环下完成两个 for 循环的工作。**

先把两个指针的含义明确下来（很多同学做这题很懵，就是不理解快慢指针各指什么）：

| 指针 | 含义 |
|---|---|
| **快指针 fast** | 寻找新数组的元素，新数组就是**不含有目标元素**的数组 |
| **慢指针 slow** | 指向**更新**新数组下标的位置 |

> 双指针法（快慢指针法）在数组和链表的操作中非常常见，很多考察数组、链表、字符串等操作的面试题都用双指针法。

**注意：这些实现方法并没有改变元素的相对位置。**

### 相向双指针法

题目允许改变元素顺序，所以还可以用「相向双指针」：让 `left` 从左往右找等于 `val` 的元素，`right` 从右往左找不等于 `val` 的元素，然后覆盖。移动的元素更少。

---

## 参考代码（**先自己写再看**）

> 官方《代码随想录》Java 版实现。

### 版本一：快慢指针（`O(n)`，保持相对顺序）

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
```

### 版本二：相向双指针（`O(n)`，会改变相对顺序）

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        // 将 right 移到从右数第一个值不为 val 的位置
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        while (left <= right) {
            if (nums[left] == val) { // left 位置的元素需要移除
                // 将 right 位置的元素移到 left（覆盖），right 位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while (right >= 0 && nums[right] == val) {
                right--;
            }
        }
        return left;
    }
}
```

### 版本三：相向双指针（简化版）

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                // 这里兼容了 right 指针指向的值与 val 相等的情况
                left++;
            }
        }
        return left;
    }
}
```

- **时间复杂度**：`O(n)`
- **空间复杂度**：`O(1)`

---

## 相关题目推荐

- [26. 删除排序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)
- [283. 移动零](https://leetcode.cn/problems/move-zeroes/)
- [844. 比较含退格的字符串](https://leetcode.cn/problems/backspace-string-compare/)
- [977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/)
