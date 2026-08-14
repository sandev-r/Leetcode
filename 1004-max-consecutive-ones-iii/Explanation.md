# LeetCode 1004 - Max Consecutive Ones III

## 🟢 Difficulty

**Medium**

---

# 📝 Problem Statement

You are given a binary array `nums` containing only `0`s and `1`s, along with an integer `k`.

You are allowed to change at most `k` zeros into ones.

Your task is to find the **maximum length of a contiguous subarray** that can contain only `1`s after making at most `k` such changes.

### Example

```text
Input:
nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

Output:
6
```

The longest valid subarray contains at most `2` zeros. Those zeros can be flipped to `1`s, giving a consecutive sequence of `1`s of length `6`.

---

# 💡 Intuition

This problem is a classic **Sliding Window** problem.

Instead of actually changing the zeros into ones, we can simply **count how many zeros exist inside the current window**.

The window is valid when:

```text
number of zeros <= k
```

When the window contains more than `k` zeros, it is no longer valid.

So we move the left side of the window forward until the number of zeros becomes valid again.

### Core Idea

```text
slow                         fast
 ↓                             ↓
[ 1  1  0  1  0  1  1  1 ]
      ←------ window ------→

zeroCount = 2
k = 2

Valid window
```

If another `0` enters:

```text
slow                            fast
 ↓                                ↓
[ 1  1  0  1  0  1  0  1 ]
      ←--------- window --------→

zeroCount = 3
k = 2

Invalid window
```

We then move `slow` forward until one zero leaves the window.

---

# 🚀 Approach

We use two pointers:

* `slow` → left boundary of the window
* `fast` → right boundary of the window
* `zeroCount` → number of zeros inside the current window
* `maxCount` → longest valid window found so far

### Step 1: Initialize the window

Start both pointers at the beginning:

```text
slow = 0
fast = 0
zeroCount = 0
maxCount = 0
```

---

### Step 2: Expand the window

Move `fast` through the array.

Whenever `nums[fast]` is `0`, increase `zeroCount`.

```text
if nums[fast] == 0
    zeroCount++
```

This means the current window `[slow ... fast]` now contains one additional zero.

---

### Step 3: Check whether the window is valid

The window can contain at most `k` zeros.

```text
zeroCount <= k
```

If:

```text
zeroCount > k
```

the current window is invalid.

---

### Step 4: Shrink the window

Move `slow` forward until the window becomes valid again.

Whenever `nums[slow]` is `0`, decrease `zeroCount`.

```text
while zeroCount > k:
    if nums[slow] == 0
        zeroCount--
    slow++
```

After this loop:

```text
zeroCount <= k
```

So the window is valid again.

---

### Step 5: Update the maximum length

The current window length is:

```text
fast - slow
```

after `fast` has been moved to the next position.

Therefore:

```text
maxCount = max(maxCount, fast - slow)
```

We repeat this process until `fast` reaches the end of the array.

---

# 🧠 Dry Run

### Example

```text
Input:
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
```

### Execution

We maintain:

```text
slow → left boundary
fast → right boundary
zeroCount → zeros in window
maxCount → maximum valid length
```

| `fast` | Value | `zeroCount` | Window after adjustment | Length | `maxCount` |
| -----: | ----: | ----------: | ----------------------- | -----: | ---------: |
|      0 |     1 |           0 | `[1]`                   |      1 |          1 |
|      1 |     1 |           0 | `[1,1]`                 |      2 |          2 |
|      2 |     1 |           0 | `[1,1,1]`               |      3 |          3 |
|      3 |     0 |           1 | `[1,1,1,0]`             |      4 |          4 |
|      4 |     0 |           2 | `[1,1,1,0,0]`           |      5 |          5 |
|      5 |     0 |           3 | Shrink window           |      5 |          5 |
|      6 |     1 |           2 | Valid window            |      6 |          6 |
|      7 |     1 |           2 | Valid window            |      7 |          7 |
|      8 |     1 |           2 | Valid window            |      8 |          8 |
|      9 |     1 |           2 | Valid window            |      9 |          9 |
|     10 |     0 |           3 | Shrink window           |      9 |          9 |

The maximum valid window has length:

```text
9
```

### Final Output

```text
9
```

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Although there is a `while` loop inside the main loop, each element is processed by `slow` at most once and by `fast` at most once.

Therefore, the total number of pointer movements is linear:

```text
O(n)
```

---

### Space Complexity

**O(1)**

Only a few variables are used:

```text
slow
fast
zeroCount
maxCount
```

No additional data structure is required.

---

# 🎯 Key Takeaways

* This is a **Sliding Window** problem.
* Maintain a window containing **at most `k` zeros**.
* `fast` expands the window.
* `slow` shrinks the window when the number of zeros becomes greater than `k`.
* There is no need to actually flip zeros; simply count them.
* Each element is processed a constant number of times, giving **O(n)** time.
* The important pattern is:

```text
Expand → Violation → Shrink → Update Answer
```

### Interview Tip

When a problem asks for the **longest/shortest contiguous subarray** while allowing a limited number of violations, replacements, or changes, immediately consider **Sliding Window + Two Pointers**.
