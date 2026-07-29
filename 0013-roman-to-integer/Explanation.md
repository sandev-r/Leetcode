# LeetCode 13 - Roman to Integer

## 🟢 Difficulty
Easy

---

# 📝 Problem Statement

Roman numerals are represented using the following symbols:

| Symbol | Value |
|--------|------:|
| I | 1 |
| V | 5 |
| X | 10 |
| L | 50 |
| C | 100 |
| D | 500 |
| M | 1000 |

Normally, Roman numerals are written from largest to smallest. However, in some cases, a smaller numeral appears before a larger numeral, indicating that it should be subtracted instead of added.

Examples:

- `IV = 4`
- `IX = 9`
- `XL = 40`
- `XC = 90`
- `CD = 400`
- `CM = 900`

Given a Roman numeral string `s`, convert it into its integer representation.

---

# 💡 Intuition

The straightforward idea is to add the value of every Roman numeral.

For example:

```
VIII = 5 + 1 + 1 + 1 = 8
```

However, Roman numerals also use **subtractive notation**, where a smaller value placed before a larger value should be subtracted.

Example:

```
IV = 5 - 1 = 4
```

Instead of checking all six subtractive combinations (`IV`, `IX`, `XL`, `XC`, `CD`, `CM`), we only need one simple observation:

> If the previous numeral has a smaller value than the current numeral, then the previous value should be subtracted. Otherwise, it should be added.

This allows us to solve the problem by scanning the string only once.

---

# ⚙️ Approach

### Step 1

Create a helper method that returns the integer value of each Roman character.

---

### Step 2

Initialize:

- `sum = 0`
- `prev = value of the first character`

---

### Step 3

Traverse the string starting from the second character.

For each character:

- Find its integer value (`curr`).
- Compare `prev` and `curr`.

---

### Case 1: `prev < curr`

The previous numeral is part of a subtractive pair.

Example:

```
IV

1 < 5
```

Subtract the previous value from the answer.

---

### Case 2: `prev >= curr`

The previous numeral follows the normal Roman numeral rule.

Example:

```
VI

5 > 1
```

Add the previous value to the answer.

---

### Step 4

Update:

```
prev = curr
```

Continue until the end of the string.

---

### Step 5

After the loop finishes, the last Roman numeral has not yet been processed.

Add it to the answer and return the final result.

---

# 🔍 Dry Run

## Example

```
s = "MCMXCIV"
```

| Previous | Current | Action | Sum |
|----------|---------|--------|----:|
| M (1000) | C (100) | +1000 | 1000 |
| C (100) | M (1000) | -100 | 900 |
| M (1000) | X (10) | +1000 | 1900 |
| X (10) | C (100) | -10 | 1890 |
| C (100) | I (1) | +100 | 1990 |
| I (1) | V (5) | -1 | 1989 |

Finally, add the last value:

```
1989 + 5 = 1994
```

Output:

```
1994
```

---

# 🌳 Algorithm

1. Convert the first Roman numeral into its integer value.
2. Store it as the previous value.
3. Traverse the string from the second character.
4. Convert the current Roman numeral into its integer value.
5. If the previous value is smaller than the current value, subtract the previous value.
6. Otherwise, add the previous value.
7. Update the previous value to the current value.
8. After the traversal, add the last stored value.
9. Return the final answer.

---

# ✅ Correctness

The algorithm processes each Roman numeral exactly once.

For every adjacent pair:

- If the previous numeral is smaller than the current numeral, it belongs to a subtractive pair and is subtracted.
- Otherwise, it follows the normal Roman numeral rule and is added.

Since every Roman numeral is processed exactly once and the final numeral is added after the loop, every symbol contributes the correct value to the answer.

Therefore, the algorithm always returns the correct integer representation of the Roman numeral.

---

# ⏱️ Complexity Analysis

### Time Complexity

```
O(n)
```

- The string is traversed exactly once.

---

### Space Complexity

```
O(1)
```

- Only a few integer variables are used regardless of the input size.

---

# 🎯 Key Takeaways

- Roman numerals are usually added from left to right.
- A smaller numeral before a larger numeral indicates subtraction.
- Comparing adjacent values is enough to identify subtractive pairs.
- Each character is processed exactly once.
- The algorithm achieves **O(n)** time complexity with **O(1)** extra space.
