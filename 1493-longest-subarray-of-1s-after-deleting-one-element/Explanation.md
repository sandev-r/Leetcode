# LeetCode 1493 - Longest Subarray of 1's After Deleting One Element

## 🟢 Difficulty

**Medium**

---

# 📝 Problem Statement

Given a binary array `nums`, you must delete exactly **one element** from the array.

After deleting one element, return the length of the longest contiguous subarray containing only `1`s.

### Example

```text
Input:  nums = [1,1,0,1,1,1]

Output: 5
```

Delete the `0`:

```text
[1,1,0,1,1,1]
     ↓
[1,1,1,1,1]
```

The longest subarray of `1`s has length `5`.

---

# 💡 Intuition

This problem is essentially a **Sliding Window** problem.

The important observation is:

> Since we must delete exactly one element, our window can contain at most **one `0`**.

For example:

```text
[1, 1, 0, 1, 1]
      ↑
   one zero
```

If the window contains only one `0`, we can delete that `0` and all remaining elements become `1`.

So we maintain a window `[slow ... fast]` that contains **at most one zero**.

### What happens when we find another zero?

Suppose the window becomes:

```text
[1, 1, 0, 1, 0]
            ↑
         2nd zero
```

We cannot delete both zeros because we are allowed to delete only **one element**.

Therefore, we move `slow` forward until the window contains only one zero again.

---

# 🚀 Approach

Use two pointers:

* `slow` → left boundary of the window
* `fast` → right boundary of the window
* `zeroCount` → number of zeros currently inside the window
* `maxCount` → longest valid subarray after deleting one element

### Step 1: Expand the window

Move `fast` from left to right.

Whenever `nums[fast] == 0`, increase `zeroCount`.

```text
zeroCount++
```

---

### Step 2: Keep at most one zero

If:

```text
zeroCount > 1
```

the current window is invalid.

Move `slow` forward until the number of zeros becomes `1` again.

Whenever the element leaving the window is `0`, decrease `zeroCount`.

```text
zeroCount--
```

---

### Step 3: Calculate the valid length

The current window contains at most one zero.

Because we **must delete exactly one element**, the answer for the current window is:

```text
window length - 1
```

The window length is:

```text
fast - slow + 1
```

Therefore:

```text
(fast - slow + 1) - 1
```

which simplifies to:

```text
fast - slow
```

In the implementation, `fast` is incremented before calculating the length, so it uses:

```text
(fast - slow) - 1
```

The subtraction of `1` represents the element that must be deleted.

---

# 🧠 Dry Run

Consider:

```text
nums = [1, 1, 0, 1, 1, 0, 1]
```

We can have at most one `0` inside the window.

| `fast` | Element | `zeroCount` | Window        | Current Length |
| -----: | ------: | ----------: | ------------- | -------------: |
|      0 |       1 |           0 | `[1]`         |              0 |
|      1 |       1 |           0 | `[1,1]`       |              1 |
|      2 |       0 |           1 | `[1,1,0]`     |              2 |
|      3 |       1 |           1 | `[1,1,0,1]`   |              3 |
|      4 |       1 |           1 | `[1,1,0,1,1]` |              4 |
|      5 |       0 |           2 | Invalid       |              — |

At `fast = 5`, we have two zeros:

```text
[1,1,0,1,1,0]
```

So we move `slow`.

After removing the first zero:

```text
[1,1,0,1,1,0]
      ↑
    removed
```

The window becomes:

```text
[1,1,0,1,1,0]
      ↑       ↑
    slow     fast
```

After shrinking sufficiently, we get:

```text
[1,1,0,1,1]
```

with only one zero remaining.

Then we continue expanding.

The longest valid window corresponds to deleting one zero, giving the maximum number of consecutive `1`s.

---

# ✅ Correctness

The algorithm maintains the following invariant:

> At every iteration, the sliding window contains at most one `0`.

### Case 1: The new element is `1`

Adding it cannot violate the invariant.

The window remains valid.

### Case 2: The new element is `0`

`zeroCount` increases.

If it becomes `2`, the window is invalid.

We move `slow` forward until one of the zeros leaves the window, restoring:

```text
zeroCount <= 1
```

Therefore, the window is always valid after shrinking.

Since every valid window contains at most one zero, deleting that zero produces a subarray containing only `1`s.

If the window contains no zero, we still subtract one because the problem requires **exactly one element to be deleted**.

Finally, `maxCount` records the largest possible result among all valid windows.

Therefore, the algorithm returns the length of the longest subarray of `1`s obtainable after deleting exactly one element.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Both `slow` and `fast` move only from left to right.

* `fast` visits every element once.
* `slow` also visits every element at most once.

Therefore:

```text
O(n + n) = O(n)
```

### Space Complexity

**O(1)**

Only a few integer variables are used:

```text
slow
fast
zeroCount
maxCount
k
```

No additional data structure is required.

---

# 🎯 Key Takeaways

* This is a classic **Sliding Window** problem.
* The key condition is **at most one zero inside the window**.
* When the window contains two zeros, move the left pointer until only one zero remains.
* Because **exactly one element must be deleted**, subtract `1` from the window size.
* Both pointers move only forward, giving **O(n) time and O(1) space**.
* The important pattern is:

```text
Expand → Check constraint → Shrink if invalid → Update answer
```

This same pattern appears in many LeetCode sliding-window problems.
