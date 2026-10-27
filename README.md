# 《代码随想录》Java 本地刷题工程

配套《代码随想录》PDF 教程的**本地**学习工程：每道题都放在本地目录下，
带题面文档 + 待填的 `Solution` 骨架 + 本地 JUnit 判题器，**不用去力扣 OJ 提交也能自测对错**。

- 教材原文：`代码随想录PDF全集V3.0/`（本仓库内已附带全部 11 章 PDF）
- 官方题解参考：<https://github.com/youngyangyang04/leetcode-master>

---

## 快速开始

```bash
cd E:\Projects\learning\ds-algo\Programmercarl\algo-java

# 编译 + 跑全部测试（必须带 -o，见下方「环境说明」）
mvn -o clean test

# 只跑某一题
mvn -o test "-Dtest=ch01_array._3_remove_element_lc0027.SolutionTest"

# 打包
mvn -o package
```

> **首次运行前请把 `mvn` 加上 `-o`（离线模式）。** 本机网络无法连接 Maven 中央仓库，
> 不加 `-o` 会卡在依赖下载上。依赖和插件都已缓存在本地仓库里，离线直接可用。

在 IntelliJ IDEA 里直接打开本目录即可（Maven 面板会自动识别），
`SolutionTest.java` 左侧的绿色三角就是本地判题按钮。

---

## 当前进度

### 第 01 章 数组 ✅

《代码随想录》数组章节共 7 节，其中「1. 数组理论基础」和「7. 数组总结篇」是理论篇，
下面 5 个目录对应 5 道题目，目录名前缀的数字就是**该题在代码随想录中的节号**。

| 节号 | 题目 | 目录 | 本地包名 |
|---|---|---|---|
| 2 | 704. 二分查找 | `src/main/java/ch01_array/_2_binary_search_lc0704/` | `ch01_array._2_binary_search_lc0704` |
| 3 | 27. 移除元素 | `src/main/java/ch01_array/_3_remove_element_lc0027/` | `ch01_array._3_remove_element_lc0027` |
| 4 | 977. 有序数组的平方 | `src/main/java/ch01_array/_4_squares_of_a_sorted_array_lc0977/` | `ch01_array._4_squares_of_a_sorted_array_lc0977` |
| 5 | 209. 长度最小的子数组 | `src/main/java/ch01_array/_5_minimum_size_subarray_sum_lc0209/` | `ch01_array._5_minimum_size_subarray_sum_lc0209` |
| 6 | 59. 螺旋矩阵 II | `src/main/java/ch01_array/_6_spiral_matrix_ii_lc0059/` | `ch01_array._6_spiral_matrix_ii_lc0059` |

> 节号按**代码随想录 PDF 数组章节的目录顺序**排（704 → 27 → 977 → 209 → 59），不是按题号大小。
> 节号取自官方目录，题目末尾的 `lcXXXX` 是力扣题号，方便回头对照力扣原题。

其余 10 章（链表、哈希表、字符串、双指针、栈与队列、二叉树、回溯、贪心、动态规划、单调栈）待做。

---

## 目录约定

```
algo-java/
├── pom.xml                       # Maven 工程（UTF-8，JUnit 5.10.5）
├── .mvn/jvm.config               # 固定 UTF-8，避免控制台中文乱码
└── src/
    ├── main/java/ch01_array/     # 题目代码
    │   └── _3_remove_element_lc0027/
    │       ├── Solution.java     # ← 你要填空的练习骨架
    │       └── README.md         # 题面 + 思路 + 官方参考代码
    └── test/java/ch01_array/     # 本地判题器（与 main 完全镜像）
        └── _3_remove_element_lc0027/
            └── SolutionTest.java
```

**命名规则**

| 对象 | 格式 | 例子 |
|---|---|---|
| 章节目录 | `ch<两位章号>_<英文主题>` | `ch01_array`、`ch02_linked_list` |
| 题目目录 | `_<节号>_<snake_case 英文题意>_lc<四位题号>` | `_3_remove_element_lc0027` |
| 包名 | **与目录名完全一致** | `ch01_array._3_remove_element_lc0027` |
| 解题类 | `Solution`（多解法时用 `Solution2`、`Solution3`） | `Solution.java` |
| 测试类 | `SolutionTest` | `SolutionTest.java` |

题目目录名的三段含义：

| 片段 | 含义 | 例子 |
|---|---|---|
| `_<节号>` | 该题在**代码随想录 PDF 里的节号** | `_3`（数组章节第 3 节 = 移除元素） |
| `_<英文题意>` | 题目英文名的 snake_case | `remove_element` |
| `_lc<四位题号>` | **力扣题号**，方便对照力扣原题 | `lc0027` |

> ⚠️ **包名不能以数字开头。** Java 标识符不允许数字开头，
> 所以节号前面必须加一个下划线：目录 `_3_remove_element_lc0027` ↔ 包名 `ch01_array._3_remove_element_lc0027`。
> 这样文件夹名和包名仍然完全一致，IntelliJ 不会出现「包名与目录不符」的黄色提示。

---

## 学习方式

每道题按这个顺序做：

1. **读 `README.md` 的「题目描述」** —— 明确输入、输出、约束
2. **自己写 `Solution.java`** —— 骨架里已经把该想清楚的点写进注释了（比如快慢指针各指什么、
   滑动窗口三条要点、螺旋矩阵的「每条边统一左闭右开」）
3. **跑 `mvn -o test` 自测** —— 红了就对了，说明你还没实现
4. **卡住了再看「思路」和「参考代码」** —— 参考代码是官方《代码随想录》Java 版实现
5. **合上答案重写一遍** —— 这一步才是真正学会的地方

`Solution.java` 里的方法体初始是 `throw new UnsupportedOperationException("TODO")`，
这样**编译能过、测试会明确报「还没实现」**，不会静默通过让你误以为写对了。

---

## 环境说明（踩坑记录）

| 项 | 说明 |
|---|---|
| JDK | 17 LTS（`C:\Java\jdk-17`） |
| Maven | 3.9.14（`D:\Maven\apache-maven-3.9.14`） |
| **Maven 本地仓库** | **`D:\Maven\localRepository`** |
| JUnit | `org.junit.jupiter:junit-jupiter:5.10.5`（已缓存在上述仓库） |
| IDE | IntelliJ IDEA 2026.1.1 / 2025.3、VS Code |

**三个必须知道的点：**

1. **必须用 `mvn -o` 离线模式。** 本机 SSL 无法连接 Maven 中央仓库和 PyPI，
   联网模式会卡死。所有依赖和插件版本都已在 `pom.xml` 里显式锁定
   （compiler 3.15.0 / surefire 3.5.4 / resources 3.4.0），离线直接可用。

2. **本地仓库是 `D:\Maven\localRepository`，和 `~/.m2` 无关。**
   由 `D:\Maven\apache-maven-3.9.14\conf\settings.xml` 的
   `<localRepository>D:/Maven/localRepository</localRepository>` 指定，
   且 `~/.m2` 下**没有** `settings.xml` 覆盖它。
   所以 `C:\Users\ASUS\.m2\repository` 即使存在也不会被使用（构建前后文件数不变，已验证）。
   以后换机器时，注意让这个 `localRepository` 指向有 JUnit 的那个仓库。

3. **UTF-8 编码。** Windows 控制台默认 GBK，中文路径在 Maven 输出里会显示乱码
   （**不影响编译**，只是显示问题）。`.mvn/jvm.config` 固定了 JVM 的输入输出编码，
   `pom.xml` 里的 `project.build.sourceEncoding` 固定了源码读写编码。

---

## 题目来源

- **题面**：<https://leetcode.cn/problems/remove-element/> 等力扣原题页
- **思路与参考代码**：《代码随想录》官方题解
  <https://github.com/youngyangyang04/leetcode-master/tree/master/problems>
- **配套 PDF**：`代码随想录PDF全集V3.0/`
