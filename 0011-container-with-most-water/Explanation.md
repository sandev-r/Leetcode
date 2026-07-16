# 11. Container With Most Water

## Problem Summary

You are given an integer array `height`, where `height[i]` represents the height of a vertical line drawn at index `i`.

Choose any two lines such that, together with the x-axis, they form a container capable of holding water.

Return the **maximum amount of water** the container can store.

### Example

```text
Input:
height = [1,8,6,2,5,4,8,3,7]

Output:
49
```

---

# Intuition

The amount of water a container can hold depends on:

- The **shorter** of the two lines.
- The **distance** (width) between them.

Formula:

```text
Area = min(leftHeight, rightHeight) × (right - left)
```

A brute-force solution checks every pair of lines, calculates the area, and keeps the maximum. However, this requires **O(n²)** time.

Notice that the **shorter line always limits the water level**. Even if the taller line becomes taller, the water level cannot increase unless the shorter line also becomes taller.

This observation allows us to use the **Two Pointer** technique.

---

# Key Observation

Suppose the current container is formed by:

```text
Left Height = 5
Right Height = 8
Width = 6

Area = min(5,8) × 6
     = 30
```

The shorter line is `5`.

If we move the **right pointer**:

```text
Width decreases.

The minimum height can never become greater than 5 unless the left pointer also changes.

So the area cannot improve.
```

Instead, move the **left pointer**.

You may find a taller left line that increases the minimum height enough to compensate for the reduced width.

### Rule

- If `height[left] < height[right]` → Move `left`.
- Otherwise → Move `right`.

---

# Approach

1. Initialize two pointers:
   - `left = 0`
   - `right = height.length - 1`
2. Calculate the area formed by the two pointers.
3. Update the maximum area.
4. Move the pointer pointing to the shorter line.
5. Repeat until both pointers meet.
6. Return the maximum area found.

---

# Dry Run

### Input

```text
height = [1,8,6,2,5,4,8,3,7]
```

### Initial State

```text
L = 0
R = 8
Max Area = 0
```

---

### Iteration 1

```text
Left Height  = 1
Right Height = 7

Width = 8

Area = min(1,7) × 8
     = 8

Max Area = 8
```

Since `1 < 7`, move the left pointer.

```text
L = 1
```

---

### Iteration 2

```text
Left Height  = 8
Right Height = 7

Width = 7

Area = min(8,7) × 7
     = 49

Max Area = 49
```

Since `7 < 8`, move the right pointer.

```text
R = 7
```

---

### Iteration 3

```text
Left Height  = 8
Right Height = 3

Width = 6

Area = 3 × 6
     = 18

Max Area = 49
```

Move the right pointer.

---

### Iteration 4

```text
Left Height  = 8
Right Height = 8

Width = 5

Area = 8 × 5
     = 40

Max Area = 49
```

Move either pointer.

Continue until `left == right`.

### Final Answer

```text
49
```

---

# Algorithm

```text
1. Set left = 0
2. Set right = n - 1
3. Set maxArea = 0

4. While left < right
      width = right - left
      minHeight = min(height[left], height[right])
      area = width × minHeight
      maxArea = max(maxArea, area)

      If height[left] < height[right]
            left++
      Else
            right--

5. Return maxArea
```

---

# Why This Works

At every step:

- The current width is the **largest possible** for the current pair of heights.
- The shorter line limits the amount of water.
- Moving the taller line only decreases the width while keeping the limiting height unchanged or worse.
- Therefore, the only chance of finding a larger area is to move the **shorter** pointer and look for a taller line.

Since every pointer moves only once across the array, all useful possibilities are considered without checking every pair.

---

# Complexity Analysis

### Time Complexity

```text
O(n)
```

Each pointer moves at most `n` times.

### Space Complexity

```text
O(1)
```

Only a few extra variables are used.

---

# Key Takeaways

- Water stored depends on:
  - Minimum of the two heights.
  - Distance between them.
- The shorter line always limits the container.
- Always move the pointer pointing to the shorter line.
- The Two Pointer technique eliminates unnecessary comparisons.
- Time complexity improves from **O(n²)** (brute force) to **O(n)**.
- This is one of the most important Two Pointer problems asked in coding interviews.
