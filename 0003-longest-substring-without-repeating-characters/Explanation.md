# 3. Longest Substring Without Repeating Characters

## Problem Summary

Given a string `s`, return the **length of the longest substring** that contains **no repeated characters**.

A **substring** is a continuous part of a string.

### Example

**Input:**
```text
s = "abcabcbb"
```

**Output:**
```text
3
```

**Explanation:**

The longest substring without repeating characters is `"abc"`, whose length is `3`.

---

## Intuition

We need to find the longest continuous substring where every character appears only once.

A brute force approach would generate every possible substring and check for duplicates, but that takes **O(n²)** or worse.

Instead, we can use a **Sliding Window**.

Think of the window as a box that expands to include new characters.

- If the new character is unique, keep expanding.
- If the character already exists inside the window, remove characters from the left until it becomes unique again.
- Keep track of the maximum window size.

This allows us to process each character only once.

---

## Key Observation

- We only care about the **current substring**.
- A `HashSet` quickly tells us whether a character already exists in the current window.
- Every character is added and removed at most once.

This makes the solution **O(n)**.

---

## Approach

1. Create a `HashSet` to store characters in the current window.
2. Initialize two pointers:
   - `left` → start of window
   - `right` → end of window
3. Move `right` forward.
4. If `s[right]` is **not** in the set:
   - Add it.
   - Update the maximum length.
5. If `s[right]` **already exists**:
   - Remove characters from the left until the duplicate disappears.
6. Continue until `right` reaches the end.

---

## Dry Run

### Input

```text
s = "abcabcbb"
```

| Step | Left | Right | Window | Max Length |
|------|------|-------|--------|------------|
| Add a | 0 | 0 | "a" | 1 |
| Add b | 0 | 1 | "ab" | 2 |
| Add c | 0 | 2 | "abc" | 3 |
| Duplicate a | 1 | 3 | "bca" | 3 |
| Duplicate b | 2 | 4 | "cab" | 3 |
| Duplicate c | 3 | 5 | "abc" | 3 |
| Duplicate b | 5 | 6 | "cb" | 3 |
| Duplicate b | 7 | 7 | "b" | 3 |

Final Answer:

```text
3
```

---

## Algorithm

```text
Create an empty HashSet

left = 0
maxLength = 0

For right from 0 to n-1

    While current character exists in the HashSet
        Remove s[left]
        left++

    Add current character

    maxLength = max(maxLength, right - left + 1)

Return maxLength
```

---

## Why This Works

The sliding window always maintains a valid substring containing unique characters.

When a duplicate appears:

- Remove characters from the left.
- Continue until the duplicate is removed.
- Expand again.

Since each character enters and leaves the window at most once, the algorithm remains efficient.

---

## Complexity Analysis

### Time Complexity

- Each character is added once.
- Each character is removed once.

**Time Complexity:** `O(n)`

---

### Space Complexity

The `HashSet` stores only unique characters in the current window.

- Worst case: all characters are unique.

**Space Complexity:** `O(min(n, charset))`

For English ASCII characters, this is effectively **O(1)**.

---

## Key Takeaways

- This is a classic **Variable Size Sliding Window** problem.
- A `HashSet` provides **O(1)** lookup, insertion, and deletion.
- Expand the window when characters are unique.
- Shrink the window when a duplicate appears.
- Each character is processed at most twice, giving **O(n)** time complexity.
- This pattern is commonly used in substring and string optimization problems.
