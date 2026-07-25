# LeetCode 20 - Valid Parentheses

## 🟢 Difficulty
Easy

---

# 📝 Problem Statement

You are given a string containing only the following characters:

- `(`
- `)`
- `{`
- `}`
- `[`
- `]`

Your task is to determine whether every opening bracket has a matching closing bracket of the same type and whether they are closed in the correct order.

Return:

- `true` if the string is valid.
- `false` otherwise.

---

# 💡 Intuition

Whenever we encounter an opening bracket, we don't know when it will be closed.

So instead of immediately matching it, we **remember** it.

The most recently opened bracket must always be closed first.

This behavior follows the **Last In, First Out (LIFO)** principle, which is exactly how a **Stack** works.

Example:

`({[]})`

- Open `(`
- Open `{`
- Open `[`
- Close `]`
- Close `}`
- Close `)`

Notice that the latest opening bracket is always the first one to close.

---

# 🚀 Approach

### Step 1

Create an empty stack.

The stack stores all opening brackets.

---

### Step 2

Traverse each character in the string.

---

### Step 3

If the current character is:

- `(`
- `[`
- `{`

Push it into the stack.

---

### Step 4

If the current character is a closing bracket:

First check whether the stack is empty.

If it is empty, there is no opening bracket to match.

Return `false`.

---

### Step 5

Pop the top element from the stack.

This is the most recent opening bracket.

Check whether it matches the current closing bracket.

Examples:

- `(` should match `)`
- `[` should match `]`
- `{` should match `}`

If they don't match, return `false`.

---

### Step 6

Continue until all characters are processed.

---

### Step 7

Finally, check the stack.

- If the stack is empty, every opening bracket found its matching closing bracket.
- Otherwise, some opening brackets remain unmatched.

Return `stack.isEmpty()`.

---

# 🔍 Dry Run

### Input

```
s = "({[]})"
```

| Character | Stack | Action |
|-----------|--------|--------|
| ( | ( | Push |
| { | ( { | Push |
| [ | ( { [ | Push |
| ] | ( { | Pop `[` ✔ |
| } | ( | Pop `{` ✔ |
| ) | Empty | Pop `(` ✔ |

Stack is empty.

Answer = **true**

---

### Example 2

```
s = "(]"
```

| Character | Stack | Action |
|-----------|--------|--------|
| ( | ( | Push |
| ] | Empty | Pop `(` → Doesn't match `]` ❌ |

Answer = **false**

---

# ✅ Correctness

The algorithm is correct because:

- Every opening bracket is stored.
- Every closing bracket must match the most recent opening bracket.
- Invalid ordering is immediately detected.
- Extra closing brackets are detected when the stack is empty.
- Extra opening brackets are detected because the stack won't be empty at the end.

Therefore, the algorithm correctly determines whether the parentheses are valid.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

- We visit each character exactly once.
- Each push and pop operation takes O(1).

---

### Space Complexity

**O(n)**

In the worst case (all opening brackets), every character is stored in the stack.

Example:

```
"(((([{{{"
```

---

# 🎯 Key Takeaways

- A **Stack** is the perfect data structure for matching parentheses.
- Opening brackets are pushed onto the stack.
- Closing brackets must match the most recently opened bracket.
- If a mismatch occurs, immediately return `false`.
- The stack must be empty after processing the entire string for the input to be valid.
```
