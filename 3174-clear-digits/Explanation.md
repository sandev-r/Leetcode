# LeetCode 3174 - Clear Digits

## 🟢 Difficulty
Easy

---

# 📝 Problem Statement

You are given a string containing lowercase English letters and digits.

Whenever a digit appears, you must remove that digit and also remove the **closest letter to its left** that has not already been removed.

After processing the entire string, return the remaining letters as the final string.

---

# 💡 Intuition

The important observation is that every digit always removes the **most recently kept letter**.

Think about the string as you're reading it from left to right.

- Every letter is temporarily kept.
- Whenever a digit appears, it removes the latest letter that hasn't been removed yet.

This follows the **Last In, First Out (LIFO)** principle.

A **Stack** is the perfect data structure for this behavior. Instead of using Java's `Stack`, we can use a `StringBuilder` because:

- Adding a character is like **pushing** onto a stack.
- Removing the last character is like **popping** from a stack.

This makes the solution both simple and efficient.

---

# 🚀 Approach

### Step 1

Create an empty `StringBuilder`.

It will store all the letters that are currently kept.

---

### Step 2

Traverse every character in the string from left to right.

---

### Step 3

If the current character is a letter:

Append it to the `StringBuilder`.

---

### Step 4

If the current character is a digit:

Remove the last character from the `StringBuilder`.

This simulates removing the closest letter to the left.

---

### Step 5

Continue until every character has been processed.

---

### Step 6

Return the contents of the `StringBuilder` as the final answer.

---

# 🔍 Dry Run

### Input

```text
s = "abc3d2"
```

| Character | StringBuilder | Action |
|-----------|---------------|--------|
| a | a | Append |
| b | ab | Append |
| c | abc | Append |
| 3 | ab | Remove last letter (`c`) |
| d | abd | Append |
| 2 | ab | Remove last letter (`d`) |

The traversal is complete.

---

### Final Output

```text
"ab"
```

---

# ✅ Correctness

The algorithm is correct because:

- Every letter is stored when it is encountered.
- Every digit immediately removes the most recently stored letter, which is exactly the closest available letter to its left.
- Each character is processed only once.
- Every removal matches the problem's requirement.
- After processing the entire string, the `StringBuilder` contains exactly the letters that were never removed.

Therefore, the algorithm always returns the correct final string.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

We traverse the string exactly once, and each append or remove-last operation takes **O(1)** time.

---

### Space Complexity

**O(n)**

In the worst case, the string contains only letters, so all characters are stored in the `StringBuilder`.

---

# 🎯 Key Takeaways

- Every digit removes the **most recently added** letter.
- The problem follows the **LIFO (Last In, First Out)** principle.
- `StringBuilder` can efficiently simulate stack operations.
- Each character is processed only once, making the solution efficient.
- The overall solution runs in **O(n)** time with **O(n)** extra space.
