# LeetCode 2824 — Count Pairs Whose Sum is Less than Target

**Difficulty:** Easy

## Problem Statement

Given an integer array `nums` and an integer `target`, count the number of pairs of indices `(i, j)` such that:

* `i < j`
* `nums[i] + nums[j] < target`

Return the total number of valid pairs.

---

## Intuition

The brute-force approach checks every possible pair, which takes **O(n²)** time.

We can do better by first **sorting the array**.

Once the array is sorted:

* `left` starts at the smallest element.
* `right` starts at the largest element.

Suppose:

```text
nums[left] + nums[right] < target
```

Because the array is sorted, every element between `left + 1` and `right` is **less than or equal to `nums[right]`**.

Therefore:

```text
nums[left] + nums[k] < target
```

for every:

```text
left < k <= right
```

So instead of checking each pair individually, we can count all of them at once.

The number of valid pairs is:

```text
right - left
```

Then we move `left` forward.

If:

```text
nums[left] + nums[right] >= target
```

the largest element is too large to form a valid pair with `nums[left]`.

So we move `right` backward.

---

## Approach

### Step 1 — Sort the Array

Sort `nums` in ascending order.

Example:

```text
nums = [3, 1, 0, 2]

After sorting:

[0, 1, 2, 3]
```

### Step 2 — Initialize Two Pointers

```text
left = 0
right = nums.size() - 1
count = 0
```

The pointers represent the smallest and largest elements currently being considered.

### Step 3 — Compare the Pair

Calculate:

```text
nums[left] + nums[right]
```

#### Case 1: Sum is less than target

If:

```text
nums[left] + nums[right] < target
```

then every element from `left + 1` through `right` can pair with `nums[left]`.

So:

```text
count += right - left
```

Then move:

```text
left++
```

#### Case 2: Sum is greater than or equal to target

If:

```text
nums[left] + nums[right] >= target
```

the largest element cannot form a valid pair with `nums[left]`.

Move:

```text
right--
```

### Step 4 — Stop

Continue while:

```text
left < right
```

When the pointers meet or cross, all possible pairs have been considered.

---

## Example

Consider:

```text
nums = [3, 1, 0, 2]
target = 4
```

After sorting:

```text
[0, 1, 2, 3]
 ↑        ↑
left    right
```

### Iteration 1

```text
0 + 3 = 3 < 4
```

Therefore, `0` can pair with:

```text
1, 2, 3
```

Number of pairs:

```text
right - left
= 3 - 0
= 3
```

```text
count = 3
left++
```

Now:

```text
[0, 1, 2, 3]
    ↑     ↑
   left  right
```

### Iteration 2

```text
1 + 3 = 4
```

Not less than `4`.

So:

```text
right--
```

Now:

```text
[0, 1, 2, 3]
    ↑  ↑
   left right
```

### Iteration 3

```text
1 + 2 = 3 < 4
```

`1` can pair with `2`.

```text
count += 2 - 1
count = 4
```

Move `left`.

Now:

```text
left >= right
```

Stop.

### Answer

```text
4
```

The valid pairs are:

```text
(0, 1) → 0 + 1
(0, 2) → 0 + 2
(0, 3) → 0 + 3
(1, 2) → 1 + 2
```

---

## Complexity

### Time Complexity

Sorting takes:

```text
O(n log n)
```

The two-pointer traversal takes:

```text
O(n)
```

Therefore:

```text
Overall: O(n log n)
```

### Space Complexity

The two-pointer algorithm itself uses:

```text
O(1)
```

extra space, excluding the space used internally by the sorting implementation.

---

## Key Takeaway

The important trick is **counting multiple valid pairs at once**.

After sorting, when:

```text
nums[left] + nums[right] < target
```

we immediately know that:

```text
nums[left] + nums[left + 1]
nums[left] + nums[left + 2]
...
nums[left] + nums[right]
```

are all valid.

Therefore:

```text
count += right - left
```

This turns an **O(n²) brute-force pair checking problem** into an **O(n log n) sorting + two-pointer solution**.

**Pattern to remember:**

> **Sorted array + pair-sum condition → consider two pointers and look for opportunities to count a whole range of pairs at once.**
