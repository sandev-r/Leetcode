# LeetCode 3110 - Score of a String

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

You are given a string `s`.

The **score** of the string is calculated by finding the **absolute difference between the ASCII values** of every pair of adjacent characters and adding all those differences together.

Return the final score.

### Example

**Input**

```text
s = "hello"
```

**ASCII Values**

```text
h = 104
e = 101
l = 108
l = 108
o = 111
```

**Calculation**

```text
|104 - 101| = 3
|101 - 108| = 7
|108 - 108| = 0
|108 - 111| = 3

Total Score = 3 + 7 + 0 + 3 = 13
```

---

# 💡 Intuition

The problem only asks us to compare **adjacent characters**.

For every neighboring pair:

- Find the difference between their ASCII values.
- Convert the difference to a positive value using `Math.abs()`.
- Add it to the total score.

Since every adjacent pair needs to be processed exactly once, a single traversal of the string is enough.

---

# 🚀 Approach

1. Initialize a variable `score` with `0`.
2. Traverse the string from the first character to the second-last character.
3. For every index:
   - Get the current character.
   - Get the next character.
   - Calculate the absolute difference between their ASCII values.
   - Add the result to `score`.
4. Return the final score.

---

# 🌳 Dry Run

### Input

```text
s = "zaz"
```

### ASCII Values

```text
z = 122
a = 97
z = 122
```

| Index | Characters | Difference | Running Score |
|------:|------------|-----------:|--------------:|
| 0 | z, a | \|122 − 97\| = 25 | 25 |
| 1 | a, z | \|97 − 122\| = 25 | 50 |

### Final Output

```text
50
```

---

# 🔍 Code Explanation

### Step 1

```java
int score = 0;
```

A variable is created to store the final score.

---

### Step 2

```java
for (int i = 0; i < s.length() - 1; i++)
```

The loop runs until the **second-last character** because each iteration compares the current character with the next one (`i + 1`).

If the string length is `n`, there are only `n - 1` adjacent pairs.

---

### Step 3

```java
Math.abs(s.charAt(i) - s.charAt(i + 1))
```

- `charAt(i)` returns the current character.
- `charAt(i + 1)` returns the next character.
- Characters are automatically converted to their ASCII (Unicode) values when arithmetic operations are performed.
- `Math.abs()` ensures the difference is always positive.

Example:

```text
'a' = 97
'd' = 100

97 - 100 = -3
Math.abs(-3) = 3
```

---

### Step 4

```java
score += ...
```

The calculated difference is added to the running total.

---

### Step 5

```java
return score;
```

After processing all adjacent pairs, the final score is returned.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

- The string is traversed exactly once.

### Space Complexity

**O(1)**

- Only one integer variable is used regardless of the input size.

---

# ✅ Why This Works

The algorithm processes every adjacent pair exactly once.

For each pair, it computes the absolute difference of their ASCII values and adds it to the total score. Since every required comparison is included and no pair is skipped or repeated, the final score is computed correctly.

---

# 📚 Key Concepts Learned

- String Traversal
- Adjacent Character Processing
- ASCII (Unicode) Character Values
- `charAt()`
- `Math.abs()`
- Running Sum
- Linear Traversal
- Time Complexity Analysis (`O(n)`)
