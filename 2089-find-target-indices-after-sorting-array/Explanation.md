# LeetCode 2089 - Find Target Indices After Sorting Array

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

Given an integer array `nums` and an integer `target`, imagine sorting `nums` in ascending order.

The goal is to return all the indices where `target` appears in the sorted array.

The indices should be returned in increasing order.

Instead of actually sorting the array, we can determine the required indices by counting:

* How many elements are **smaller than** `target`.
* How many elements are **equal to** `target`.

---

# 💡 Intuition

The important observation is that we don't actually need to sort the array.

Suppose:

```text
nums = [1, 2, 5, 2, 3]
target = 2
```

After sorting:

```text
[1, 2, 2, 3, 5]
```

The target `2` starts at index `1` and appears twice:

```text
[1, 2, 2, 3, 5]
    ↑  ↑
    1  2
```

Why does it start at index `1`?

Because there is exactly **one element smaller than `2`**.

So:

```text
starting index = number of elements smaller than target
```

Then, if `target` appears `equal` times, the target indices are:

```text
small, small + 1, ..., small + equal - 1
```

This lets us solve the problem without sorting the array.

---

# 🚀 Approach

1. Initialize two counters:

   * `small` → number of elements smaller than `target`.
   * `equal` → number of elements equal to `target`.

2. Traverse through every element in `nums`.

   * If `num < target`, increment `small`.
   * If `num == target`, increment `equal`.

3. After the traversal, `small` represents the index where the first occurrence of `target` would appear after sorting.

4. Generate indices from `small` to `small + equal - 1`.

5. Add each generated index to the result list.

6. Return the list.

---

# 🧠 Dry Run

Example:

Input

```text
nums = [1, 2, 5, 2, 3]
target = 2
```

### Execution

Initial values:

```text
small = 0
equal = 0
```

### Iteration 1

```text
num = 1
```

Since:

```text
1 < 2
```

Increment `small`:

```text
small = 1
equal = 0
```

### Iteration 2

```text
num = 2
```

Since:

```text
2 == 2
```

Increment `equal`:

```text
small = 1
equal = 1
```

### Iteration 3

```text
num = 5
```

Since:

```text
5 > 2
```

Nothing changes:

```text
small = 1
equal = 1
```

### Iteration 4

```text
num = 2
```

Since:

```text
2 == 2
```

Increment `equal`:

```text
small = 1
equal = 2
```

### Iteration 5

```text
num = 3
```

Since:

```text
3 > 2
```

Nothing changes:

```text
small = 1
equal = 2
```

So:

```text
small = 1
equal = 2
```

The result indices should range from:

```text
1 → 1 + 2 - 1
```

Therefore:

```text
[1, 2]
```

Final Output

```text
[1, 2]
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the array once to count elements smaller than and equal to `target`.

Then we generate `equal` indices.

Therefore, the total complexity is:

```text
O(n + equal)
```

Since `equal <= n`, this simplifies to:

```text
O(n)
```

### Space Complexity

```text
O(k)
```

where `k` is the number of occurrences of `target`, because the returned list contains one index for each occurrence.

Ignoring the output list, the algorithm uses:

```text
O(1)
```

auxiliary space.

---

# 🎯 Key Takeaways

* You don't always need to sort an array to determine where a value would appear after sorting.
* The number of elements **smaller than `target`** tells us the starting index of `target`.
* The number of elements **equal to `target`** tells us how many consecutive indices to generate.
* This avoids the `O(n log n)` cost of sorting and solves the problem in `O(n)`.
* **Interview tip:** Look for ways to determine the result from counts or properties of the data instead of performing an unnecessary operation such as sorting.
