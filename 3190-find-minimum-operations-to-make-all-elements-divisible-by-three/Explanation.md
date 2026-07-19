# 3190. Find Minimum Operations to Make All Elements Divisible by Three

## Problem Summary

You are given an integer array `nums`.

In one operation, you can increase or decrease any element by **1**.

Your goal is to find the **minimum number of operations** needed to make **every element divisible by 3**.

---

## Intuition

A number is divisible by **3** only when its remainder is **0**.

- If `num % 3 == 0`, it already satisfies the condition.
- If `num % 3 == 1`, changing it by **1** makes it divisible by 3.
- If `num % 3 == 2`, changing it by **1** also makes it divisible by 3.

So, every number that is **not divisible by 3** contributes exactly **one operation** to the answer.

---

## Key Observation

There are only three possible remainders when dividing a number by `3`.

| Remainder | Operations Needed |
|-----------|-------------------|
| 0 | 0 |
| 1 | 1 |
| 2 | 1 |

Therefore, the answer is simply the count of numbers whose remainder is **not 0**.

---

## Approach

1. Initialize a variable `count` to store the number of required operations.
2. Traverse each element in the array.
3. Check whether the element is divisible by `3`.
4. If it is **not divisible**, increment `count`.
5. Return `count` after processing all elements.

---

## Dry Run

### Example

```text
nums = [1, 2, 3, 4]
```

| Element | Remainder (`% 3`) | Divisible by 3? | Operations | Count |
|---------:|:-----------------:|:---------------:|:----------:|------:|
| 1 | 1 | ❌ | 1 | 1 |
| 2 | 2 | ❌ | 1 | 2 |
| 3 | 0 | ✅ | 0 | 2 |
| 4 | 1 | ❌ | 1 | 3 |

**Final Answer:** `3`

---

## Algorithm

1. Initialize `count = 0`.
2. Iterate through every element in the array.
3. If `num % 3 != 0`, increment `count`.
4. Return `count`.

---

## Why This Works

A number divisible by `3` has a remainder of `0`.

If the remainder is `1` or `2`, we can always make it divisible by changing the number by **one** (either increasing or decreasing it by `1`).

Since every non-divisible element always requires exactly **one** operation, counting all such elements directly gives the minimum total operations.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`  
  We visit each element exactly once.

- **Space Complexity:** `O(1)`  
  Only a single counter variable is used.

---

## Key Takeaways

- Use the modulo (`%`) operator to check divisibility by `3`.
- Every element with remainder `1` or `2` needs exactly **one** operation.
- Simply count the elements that are **not divisible by 3**.
- The solution is optimal with **O(n)** time and **O(1)** extra space.
