# LeetCode 724 — Find Pivot Index

**Difficulty:** Easy

## Problem Statement

Given an integer array `nums`, find the **pivot index**.

The pivot index is the index where the sum of all elements strictly to the **left** is equal to the sum of all elements strictly to the **right**.

* The leftmost index should be returned if multiple pivot indices exist.
* If no pivot index exists, return `-1`.
* For the first index, the left sum is `0`.
* For the last index, the right sum is `0`.

---

## Intuition

For every index `i`, we need to compare:

```text
left sum == right sum
```

A straightforward approach would calculate both sums separately for every index. That would repeatedly traverse the array and lead to **O(n²)** time.

Instead, we can calculate the **total sum of the entire array once**.

For the current index:

```text
right sum = total sum - left sum - nums[i]
```

Why?

```text
          left        current        right
       ───────────      ↓       ─────────────
nums = [  1   2   3    4    6    2   1  ]

total = left + nums[i] + right
```

Therefore:

```text
right = total - left - nums[i]
```

After checking the current index, add `nums[i]` to `left` so that the next iteration has the correct left-side sum.

---

## Approach

### Step 1 — Calculate the total sum

Traverse the array once and store the sum of all elements.

```text
total = sum of every element
```

### Step 2 — Maintain the left sum

Start with:

```text
left = 0
```

At index `i`, calculate:

```text
right = total - left - nums[i]
```

### Step 3 — Check the pivot condition

If:

```text
left == right
```

then `i` is the pivot index.

Return `i` immediately because the problem asks for the **leftmost pivot index**.

### Step 4 — Update the left sum

If the current index is not a pivot:

```text
left += nums[i]
```

Then continue to the next index.

### Example

Consider:

```text
nums = [1, 7, 3, 6, 5, 6]
```

Total sum:

```text
total = 28
```

At index `3`:

```text
left  = 1 + 7 + 3 = 11
right = 28 - 11 - 6
      = 11
```

Therefore:

```text
left == right
11 == 11
```

So the answer is:

```text
3
```

### Core Pattern

The important idea is:

```text
             total
        ┌───────────────┐
        ↓               ↓
     left sum        right sum
                       ↑
              total - left - current
```

You don't need a separate `left[]` and `right[]` array.

You only need:

```text
total → fixed
left  → continuously updated
right → calculated when needed
```

---

## Complexity

**Time Complexity:** `O(n)`

* First loop calculates the total sum: `O(n)`
* Second loop finds the pivot: `O(n)`
* `O(n) + O(n) = O(n)`

**Space Complexity:** `O(1)`

Only a few variables are used regardless of the input size.

---

## Key Takeaway

The main optimization is recognizing that you **don't need to calculate the left and right sums independently**.

Once you know:

```text
total = left + current + right
```

you can derive:

```text
right = total - left - current
```

This converts a potentially `O(n²)` solution into an **O(n) time and O(1) space** solution.

The bigger DSA lesson is:

> **When you need two sides of an array, look for a relationship between them before creating extra arrays or repeatedly traversing the data.**
