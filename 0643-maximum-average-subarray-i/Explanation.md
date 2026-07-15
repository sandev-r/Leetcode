# 643. Maximum Average Subarray I

## Problem Summary

You are given an integer array `nums` and an integer `k`.

Your task is to find the **maximum average value** among all contiguous subarrays of length `k`.

Return the maximum average.

---

# Intuition

A straightforward approach is to calculate the sum of every subarray of size `k` and compute its average.

However, this is inefficient because adjacent subarrays share most of their elements.

For example:

```text
nums = [1, 12, -5, -6, 50, 3]
k = 4

Subarray 1: [1, 12, -5, -6]
Subarray 2: [12, -5, -6, 50]
```

Notice that these two subarrays have **three common elements**.

Recalculating the entire sum for every window repeats unnecessary work.

Instead, we can reuse the previous window's sum.

---

# Key Observation

Since every subarray has the **same fixed size (`k`)**, we can use the **Sliding Window** technique.

When moving the window one step to the right:

- Remove the element leaving the window.
- Add the new element entering the window.

Example:

```text
Current Window

[1, 12, -5, -6]
 Sum = 2

Move one step →

[12, -5, -6, 50]

New Sum

2 - 1 + 50 = 51
```

Instead of calculating the entire sum again, we update it in **O(1)** time.

---

# Approach (Sliding Window)

1. Calculate the sum of the first `k` elements.
2. Store this as the current maximum sum.
3. Slide the window through the remaining elements.
4. For every new position:
   - Subtract the element leaving the window.
   - Add the new element entering the window.
   - Update the maximum sum if the current window sum is larger.
5. After processing all windows, divide the maximum sum by `k` to obtain the maximum average.

---

# Dry Run

Input:

```text
nums = [1, 12, -5, -6, 50, 3]
k = 4
```

### Initial Window

```text
[1, 12, -5, -6]
```

Sum:

```text
1 + 12 - 5 - 6 = 2
```

```text
windowSum = 2
maxSum = 2
```

---

### Step 2

Move the window one position.

Remove:

```text
1
```

Add:

```text
50
```

New window:

```text
[12, -5, -6, 50]
```

New sum:

```text
2 - 1 + 50 = 51
```

```text
maxSum = 51
```

---

### Step 3

Move the window again.

Remove:

```text
12
```

Add:

```text
3
```

New window:

```text
[-5, -6, 50, 3]
```

New sum:

```text
51 - 12 + 3 = 42
```

```text
maxSum = 51
```

---

### Final Answer

Maximum sum:

```text
51
```

Maximum average:

```text
51 / 4 = 12.75
```

Output:

```text
12.75
```

---

# Algorithm

```text
Calculate the sum of the first k elements.

Store it as maxSum.

For every remaining element

    Remove the element leaving the window.

    Add the new element entering the window.

    Update maxSum if the current window sum is larger.

Return maxSum divided by k.
```

---

# Why This Works

Every valid subarray has the same length.

Instead of recomputing the sum of each window from scratch, we update the previous window's sum by removing one element and adding one new element.

This ensures each element is added and removed only once, making the algorithm efficient.

---

# Complexity Analysis

### Time Complexity

```text
O(n)
```

- The first window is computed in `O(k)`.
- The remaining elements are processed once.

Overall complexity is **O(n)**.

---

### Space Complexity

```text
O(1)
```

Only a few integer variables are used regardless of the input size.

---

# Key Takeaways

- This is a **Fixed-Size Sliding Window** problem.
- Adjacent windows share most of their elements.
- Instead of recalculating each window's sum, update it by:
  - Removing the outgoing element.
  - Adding the incoming element.
- Keep track of the maximum window sum during traversal.
- Divide the maximum sum by `k` to get the maximum average.
- The Sliding Window approach reduces the time complexity from **O(n × k)** to **O(n)**.
