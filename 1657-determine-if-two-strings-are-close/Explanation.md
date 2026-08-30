# LeetCode 1657 - Determine if Two Strings Are Close

## 🟢 Difficulty

Medium

---

# 📝 Problem Statement

You are given two strings, `word1` and `word2`. Your task is to determine whether they are **close strings**.

Two strings are considered close if we can transform one string into the other by:

* Swapping any two existing characters.
* Swapping all occurrences of one existing character with all occurrences of another existing character.

The important thing is to check whether both strings contain the same characters and whether their character frequencies can be rearranged to match each other.

---

# 💡 Intuition

What should we notice first?

The order of characters does not matter because we are allowed to swap characters.

What really matters is:

1. Both strings must contain exactly the same set of characters.
2. The frequency distribution of those characters must be the same.

For example:

`word1 = "abbccc"`

Frequencies → `a = 1, b = 2, c = 3`

`word2 = "aaabcc"`

Frequencies → `a = 3, b = 1, c = 2`

Even though each character has a different frequency, both strings have the same frequency distribution: `[1, 2, 3]`.

Therefore, they can be transformed into each other.

---

# 🚀 Approach

Step-by-step explanation.

1. First, check whether both strings have the same length. If not, return `false`.

2. Create two frequency arrays of size `26` to store the frequency of each lowercase English character.

3. Traverse both strings and count the occurrences of every character.

4. Check whether both strings contain the same set of characters.

   * If a character exists in one string but does not exist in the other, return `false`.

5. Sort both frequency arrays.

6. Compare the sorted frequency arrays.

   * If they are equal, return `true`.
   * Otherwise, return `false`.

Each step helps us verify whether the characters and their frequency distributions can be transformed into each other.

---

# 🧠 Dry Run

Example:

Input

```text
word1 = "abbccc"
word2 = "aaabcc"
```

Execution

```text
Frequency of word1:
a → 1
b → 2
c → 3

Frequency of word2:
a → 3
b → 1
c → 2
```

Iteration 1

```text
Check whether both strings contain the same characters.

word1 → {a, b, c}
word2 → {a, b, c}

Both contain the same characters.
```

Iteration 2

```text
Sort frequency arrays.

word1 → [1, 2, 3]
word2 → [1, 2, 3]

Both frequency distributions are equal.
```

Final Output

```text
true
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse both strings to count character frequencies. Sorting arrays of fixed size `26` takes constant time.

### Space Complexity

```text
O(1)
```

We use two fixed-size arrays of length `26`, so the extra space remains constant.

---

# 🎯 Key Takeaways

* The order of characters does not matter because characters can be swapped.
* Both strings must contain exactly the same set of characters.
* The sorted frequency distributions must be equal.
* Interview tip: When character transformations are allowed, focus on character presence and frequency distribution instead of the original order.
