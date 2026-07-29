# LeetCode 771 - Jewels and Stones

## 🟢 Difficulty
Easy

---

# 📝 Problem Statement

You are given two strings:

- `jewels` → Each character represents a type of jewel.
- `stones` → Each character represents a stone you own.

Your task is to determine **how many stones are also jewels**.

Each character is case-sensitive, meaning `'a'` and `'A'` are considered different characters.

---

# 💡 Idea

Instead of checking every jewel for every stone, we first **mark all jewel characters**.

We create a boolean array of size `256`, where:

- Index = ASCII value of a character.
- Value = `true` if the character is a jewel.
- Value = `false` otherwise.

Then we iterate through every stone:

- If that stone is marked as a jewel, increase the count.

This allows every lookup to happen in **constant time O(1)**.

---

# 🪜 Step-by-Step Algorithm

### Step 1

Create a boolean array of size `256`.

```text
boolean[] charCount = new boolean[256];
```

Initially, every value is `false`.

---

### Step 2

Traverse every character in `jewels`.

Example:

```text
jewels = "aA"
```

Mark them as jewels.

```text
charCount['a'] = true
charCount['A'] = true
```

Now the array remembers which characters are jewels.

---

### Step 3

Initialize the answer.

```text
count = 0
```

---

### Step 4

Traverse every character in `stones`.

Example:

```text
stones = "aAAbbbb"
```

For every stone:

- Check

```text
charCount[stone]
```

If it is `true`, then this stone is a jewel.

Increase the count.

---

### Step 5

Return the final count.

---

# 🔍 Dry Run

### Input

```text
jewels = "aA"
stones = "aAAbbbb"
```

### After Marking Jewels

```text
'a' → true
'A' → true
```

---

### Traverse Stones

| Stone | Jewel? | Count |
|-------|---------|------:|
| a | ✅ Yes | 1 |
| A | ✅ Yes | 2 |
| A | ✅ Yes | 3 |
| b | ❌ No | 3 |
| b | ❌ No | 3 |
| b | ❌ No | 3 |
| b | ❌ No | 3 |

Final Answer

```text
3
```

---

# 🎯 Why This Works

The boolean array acts like a lookup table.

Instead of searching through the `jewels` string for every stone, we already know whether a character is a jewel by checking:

```text
charCount[ch]
```

This lookup takes **O(1)** time, making the entire solution very efficient.

---

# ⏱️ Complexity Analysis

### Time Complexity

Marking jewels:

```text
O(J)
```

Checking stones:

```text
O(S)
```

Overall:

```text
O(J + S)
```

where:

- `J` = length of `jewels`
- `S` = length of `stones`

---

### Space Complexity

Boolean array size:

```text
256
```

This size is fixed and does not depend on the input size.

Therefore,

```text
O(1)
```

(Constant Space)

---

# 🔑 Key Takeaways

- Use a boolean array as a **lookup table**.
- Character lookup becomes **O(1)**.
- Avoid nested loops by preprocessing the jewels.
- The solution is **case-sensitive**, so `'a'` and `'A'` are treated as different characters.
- Since the array size is fixed (`256`), the extra space is **constant**.

---

# 📚 Concepts Used

- Arrays
- Boolean Lookup Table
- Character ASCII Indexing
- String Traversal
- Counting
- Time Optimization
- Constant-Time Lookup
