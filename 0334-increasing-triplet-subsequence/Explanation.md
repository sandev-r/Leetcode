# LeetCode 334 — Increasing Triplet Subsequence

**Difficulty:** Medium

## Problem Statement

Given an integer array `nums`, determine whether there exist three indices `i`, `j`, and `k` such that:

* `i < j < k`
* `nums[i] < nums[j] < nums[k]`

Return `true` if such an increasing triplet exists; otherwise, return `false`.

### Example

**Input:**
`[1, 2, 3, 4, 5]`

**Output:**
`true`

Because `1 < 2 < 3`.

---

## Intuition

We need to find **three increasing values in their original order**.

A straightforward approach would be to try every possible triplet, but that would take `O(n³)` time.

Instead, we only need to remember two important values:

* `first` → the smallest value found so far
* `second` → the smallest possible value that can come after `first`

Then, when we find a value greater than both:

`first < second < current`

we have found an increasing triplet.

The important idea is:

> **Always keep `first` and `second` as small as possible.**

Smaller values give us a better chance of finding a third larger value later.

---

## Approach

Initialize:

* `first = Integer.MAX_VALUE`
* `second = Integer.MAX_VALUE`

Then scan the array from left to right.

For every `current` value:

### Case 1 — `current <= first`

Update `first`.

This means we found an even smaller candidate for the first element.

```text
first = current
```

### Case 2 — `first < current <= second`

Update `second`.

This means `current` can become the second element of our increasing sequence.

```text
second = current
```

### Case 3 — `current > second`

Now we have:

```text
first < second < current
```

Therefore, an increasing triplet exists.

Return `true`.

If we finish scanning the entire array without finding such a value, return `false`.

---

## Dry Run

### Input

```text
nums = [2, 1, 5, 0, 4, 6]
```

Initial state:

```text
first  = ∞
second = ∞
```

### Iteration 1

```text
current = 2
```

`2 <= first`

Update:

```text
first = 2
second = ∞
```

---

### Iteration 2

```text
current = 1
```

`1 <= first`

Update:

```text
first = 1
second = ∞
```

We replace `2` because `1` is a better smaller starting value.

---

### Iteration 3

```text
current = 5
```

`5 > first`, but `5 <= second` is false because `second = ∞`.

So:

```text
second = 5
```

State:

```text
first  = 1
second = 5
```

---

### Iteration 4

```text
current = 0
```

`0 <= first`

Update:

```text
first = 0
second = 5
```

Again, we found an even better first value.

---

### Iteration 5

```text
current = 4
```

`4 > first` and `4 <= second`

Update:

```text
second = 4
```

Now:

```text
first  = 0
second = 4
```

This is better than having `second = 5`.

---

### Iteration 6

```text
current = 6
```

`6 > second`

Therefore:

```text
0 < 4 < 6
```

An increasing triplet exists.

### Final Output

```text
true
```

---

## Why This Works

The algorithm does **not** need to store the actual triplet.

It only maintains the best possible candidates for the first two positions.

Suppose we have:

```text
first = 2
second = 5
```

and later encounter:

```text
3
```

Instead of keeping `5` as `second`, we replace it:

```text
first = 2
second = 3
```

This is better because any future number greater than `5` is also greater than `3`, but now we have a much easier condition to satisfy.

Similarly, if we encounter a smaller `first`, we replace it.

So throughout the scan:

```text
first  → smallest possible first value
second → smallest possible second value after first
```

Once a number is greater than `second`, we necessarily have:

```text
first < second < current
```

which proves the existence of an increasing triplet.

---

## Algorithm

```text
1. Set first = infinity.
2. Set second = infinity.
3. Traverse every value current in nums:
   a. If current <= first:
      - Update first = current.
   b. Else if current <= second:
      - Update second = current.
   c. Else:
      - An increasing triplet exists.
      - Return true.
4. Return false.
```

---

## Complexity Analysis

### Time Complexity

```text
O(n)
```

The array is traversed exactly once.

### Space Complexity

```text
O(1)
```

Only two variables, `first` and `second`, are used regardless of the input size.

---

## Key Takeaways

* The goal is to find **three increasing values in order**, not necessarily consecutive values.
* Maintain only two candidates: `first` and `second`.
* Always make `first` and `second` as small as possible.
* `first` represents the best candidate for the first value.
* `second` represents the best candidate for the second value.
* When `current > second`, we have:

```text
first < second < current
```

* The entire problem can be solved in **one pass** with **constant space**.

### Interview Tip

Remember this pattern:

```text
smallest first
        ↓
smallest second
        ↓
anything bigger → triplet found
```

The key question to ask yourself is:

> **"Can I keep the first two values as small as possible so that finding the third value becomes easier?"**

That is the core idea behind this `O(n)` solution.
