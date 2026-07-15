# 977. Squares of a Sorted Array

## Problem Summary

You are given a **sorted** integer array `nums` in **non-decreasing order**.

Your task is to return a new array containing the **square of each number**, also sorted in **non-decreasing order**.

---

# Intuition

At first glance, it may seem enough to square every element.

Example:

```text
nums = [-4, -1, 0, 3, 10]

After squaring:
[16, 1, 0, 9, 100]
```

This array is **not sorted**.

Why?

Because negative numbers become positive after squaring.

For example:

```text
(-7)² = 49
3² = 9
```

Although `-7 < 3`, after squaring:

```text
49 > 9
```

So simply squaring every element does **not** preserve the order.

---

# Key Observation

Since the original array is already sorted,

```text
Negative numbers  → increasing
Positive numbers  → increasing
```

The **largest square** will always come from either:

* the leftmost element (largest negative), or
* the rightmost element (largest positive).

Example:

```text
[-7, -3, 2, 3, 11]

Squares:

49, 9, 4, 9, 121
```

The maximum square comes from either:

```text
|-7| = 7
or
11
```

So we only need to compare the absolute values at both ends.

---

# Approach (Two Pointers)

Use three pointers:

* `left` → beginning of the array
* `right` → end of the array
* `position` → last index of the answer array

Steps:

1. Compare `|nums[left]|` and `|nums[right]|`.
2. The larger absolute value produces the larger square.
3. Store that square at `answer[position]`.
4. Move the corresponding pointer.
5. Decrease `position`.
6. Repeat until every element is processed.

Because we fill the result from **back to front**, the final array is already sorted.

---

# Dry Run

Input:

```text
nums = [-4, -1, 0, 3, 10]
```

Initial state:

```text
left = 0
right = 4
position = 4

answer = [_, _, _, _, _]
```

### Step 1

Compare:

```text
|-4| = 4
|10| = 10
```

10 is larger.

```text
answer[4] = 100
```

Move right.

```text
answer = [_, _, _, _, 100]
```

---

### Step 2

Compare:

```text
|-4| = 4
|3| = 3
```

4 is larger.

```text
answer[3] = 16
```

Move left.

```text
answer = [_, _, _, 16, 100]
```

---

### Step 3

Compare:

```text
|-1| = 1
|3| = 3
```

3 is larger.

```text
answer[2] = 9
```

Move right.

```text
answer = [_, _, 9, 16, 100]
```

---

### Step 4

Compare:

```text
|-1| = 1
|0| = 0
```

1 is larger.

```text
answer[1] = 1
```

Move left.

```text
answer = [_, 1, 9, 16, 100]
```

---

### Step 5

Only `0` remains.

```text
answer[0] = 0
```

Final result:

```text
[0, 1, 9, 16, 100]
```

---

# Algorithm

```text
Create an answer array.

left = 0
right = n - 1
position = n - 1

While left <= right

    Compare absolute values of nums[left] and nums[right]

    If left value is larger
        Store its square
        Move left forward

    Else
        Store right square
        Move right backward

    Move position backward

Return answer
```

---

# Why This Works

The largest square always comes from the element with the greatest absolute value.

Since the array is sorted, that element must be at one of the two ends.

By always placing the largest square at the end of the answer array, we maintain sorted order without needing an additional sort.

---

# Complexity Analysis

### Time Complexity

```text
O(n)
```

Each element is processed exactly once.

---

### Space Complexity

```text
O(n)
```

An additional array of size `n` is used to store the result.

---

# Key Takeaways

* Squaring a sorted array does **not** keep it sorted.
* The maximum square always comes from one of the two ends.
* Use the **Two Pointer** technique.
* Fill the result array **from right to left**.
* Achieves **O(n)** time instead of sorting after squaring (`O(n log n)`).
