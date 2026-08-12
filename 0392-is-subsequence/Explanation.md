# LeetCode 392 - Is Subsequence

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

Given two strings `s` and `t`, determine whether `s` is a **subsequence** of `t`.

A subsequence is formed by deleting zero or more characters from a string **without changing the relative order** of the remaining characters.

### Example

```text
s = "abc"
t = "ahbgdc"

Output: true
```

`a`, `b`, and `c` appear in `t` in the same order.

---

# 💡 Intuition

The key requirement is **order**.

We don't need the characters of `s` to be next to each other in `t`.

We only need to find them from **left to right**.

For example:

```text
s = "abc"
t = "ahbgdc"

a → found
b → found
c → found
```

So `s` is a subsequence of `t`.

This naturally leads to the **two-pointer technique**.

* One pointer tracks the current character we need from `s`.
* The other pointer scans through `t`.
* When both characters match, we move the `s` pointer.
* The `t` pointer always moves forward.

---

# 🚀 Approach

Use two pointers:

```text
i → points to s
j → points to t
```

Initially:

```text
i = 0
j = 0
```

### Step 1: Compare the characters

Compare:

```text
s[i] and t[j]
```

### Step 2: If they match

We successfully found the current character of `s`.

Move `i` forward:

```text
i++
```

### Step 3: Always move through `t`

Whether the characters match or not, move:

```text
j++
```

We never need to revisit a character in `t`.

### Step 4: Check whether all characters were matched

When the loop ends, check:

```text
i == s.length()
```

If true, every character of `s` was found in the correct order.

Therefore, `s` is a subsequence of `t`.

---

# 🧠 Dry Run

Consider:

```text
s = "abc"
t = "ahbgdc"
```

| Step | `i` | `j` | `s[i]` | `t[j]` | Action        |
| ---: | --: | --: | :----: | :----: | ------------- |
|    1 |   0 |   0 |    a   |    a   | Match → `i++` |
|    2 |   1 |   1 |    b   |    h   | No match      |
|    3 |   1 |   2 |    b   |    b   | Match → `i++` |
|    4 |   2 |   3 |    c   |    g   | No match      |
|    5 |   2 |   4 |    c   |    d   | No match      |
|    6 |   2 |   5 |    c   |    c   | Match → `i++` |

Now:

```text
i = 3
s.length() = 3
```

Therefore:

```text
i == s.length()
```

So the answer is:

```text
true
```

### Another Example

```text
s = "axc"
t = "ahbgdc"
```

We find:

```text
a → found
x → not found
```

`t` is exhausted before `x` can be matched.

Therefore:

```text
i != s.length()
```

So the answer is:

```text
false
```

---

# ✅ Correctness

The algorithm is correct because it maintains the relative order of characters.

When `s[i] == t[j]`, that character is matched and `i` moves forward.

The pointer `j` only moves forward, so a character matched later in `s` can never come from an earlier position in `t`.

Therefore, every matched character of `s` appears in `t` in the same relative order.

If `i` reaches `s.length()`, all characters of `s` have been successfully matched.

Hence:

> `s` is a subsequence of `t` if and only if `i == s.length()` after the scan.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

where `n` is the length of `t`.

The pointer `j` moves through `t` at most once.

### Space Complexity

**O(1)**

Only two integer pointers are used.

No additional data structure is required.

---

# 🎯 Key Takeaways

* A **subsequence does not require contiguous characters**.
* The **relative order must remain unchanged**.
* The two-pointer technique is a natural solution for subsequence problems.
* The pointer for `t` always moves forward.
* The pointer for `s` moves only when a character is successfully matched.
* The final condition `i == s.length()` tells us whether every character was found.
* This is a classic **Two Pointers + String** pattern worth recognizing in interviews.

### Pattern to Remember

```text
Match:
    move both pointers

No match:
    move only the pointer scanning the larger/source string
```

This pattern is useful for many **subsequence, string matching, and two-pointer** problems.
