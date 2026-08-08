# LeetCode 1071 — Greatest Common Divisor of Strings

## Problem

Given two strings `str1` and `str2`, return the **largest string** that can divide both strings.

A string `t` divides another string `s` if `s` can be formed by concatenating `t` with itself one or more times.

If there is no common divisor string, return an empty string.

### Example

```text
str1 = "ABCABC"
str2 = "ABC"

Answer = "ABC"
```

Because:

```text
"ABC" + "ABC" = "ABCABC"
"ABC" = "ABC"
```

---

# Approach

The solution uses two important ideas:

1. Check whether both strings have the **same repeating pattern**.
2. Find the **GCD of their lengths** to determine the size of the largest common divisor.

---

## 1. Check Whether Both Strings Have the Same Pattern

The key observation is:

```text
str1 + str2 == str2 + str1
```

If this condition is false, there cannot be a common divisor string.

### Example

```text
str1 = "ABCABC"
str2 = "ABC"
```

Concatenating in both orders:

```text
str1 + str2 = "ABCABCABC"

str2 + str1 = "ABCABCABC"
```

Both are equal.

This means both strings are constructed from the same repeating pattern.

---

### Counter Example

```text
str1 = "ABAB"
str2 = "ABAC"
```

Now:

```text
str1 + str2 = "ABABABAC"

str2 + str1 = "ABACABAB"
```

They are different.

Therefore, there is no common divisor string.

So the answer is:

```text
""
```

---

# 2. Find the GCD of the String Lengths

If the strings have the same repeating pattern, the length of the largest common divisor must divide both string lengths.

Therefore:

```text
GCD(str1.length, str2.length)
```

gives the length of the answer.

### Example

```text
str1 = "ABCABC"
length = 6

str2 = "ABC"
length = 3
```

Therefore:

```text
GCD(6, 3) = 3
```

So the answer must have length `3`.

The first `3` characters of `str1` are:

```text
"ABC"
```

Therefore:

```text
Answer = "ABC"
```

---

# 3. Why Does GCD Work?

Suppose:

```text
str1 = "ABABAB"
str2 = "ABAB"
```

Their lengths are:

```text
6 and 4
```

The largest length that can divide both is:

```text
GCD(6, 4) = 2
```

A string of length `2` can be:

```text
"AB"
```

And:

```text
"AB" × 3 = "ABABAB"

"AB" × 2 = "ABAB"
```

Therefore, `"AB"` is the largest common divisor string.

The GCD determines the **maximum possible length** of the common repeating unit.

---

# 4. Euclidean Algorithm

The GCD is calculated using the **Euclidean Algorithm**.

The main rule is:

```text
GCD(a, b) = GCD(b, a % b)
```

Continue until `b` becomes `0`.

At that point:

```text
GCD(a, 0) = a
```

### Example

Find:

```text
GCD(6, 4)
```

First:

```text
6 % 4 = 2
```

So:

```text
GCD(6, 4)
→ GCD(4, 2)
```

Next:

```text
4 % 2 = 0
```

So:

```text
GCD(4, 2)
→ GCD(2, 0)
```

Therefore:

```text
GCD = 2
```

---

# 5. Dry Run

Consider:

```text
str1 = "ABABAB"
str2 = "ABAB"
```

### Step 1 — Check the Pattern

```text
str1 + str2
= "ABABABABAB"

str2 + str1
= "ABABABABAB"
```

They are equal.

Therefore, a common divisor exists.

---

### Step 2 — Find the GCD

```text
length(str1) = 6
length(str2) = 4
```

Calculate:

```text
GCD(6, 4)
```

Using the Euclidean Algorithm:

```text
6 % 4 = 2
4 % 2 = 0
```

Therefore:

```text
GCD = 2
```

---

### Step 3 — Extract the Prefix

Take the first `2` characters of `str1`:

```text
"AB"
```

Verify:

```text
"AB" + "AB" + "AB" = "ABABAB"

"AB" + "AB" = "ABAB"
```

Therefore:

```text
Answer = "AB"
```

---

# 6. Why We Cannot Use Only GCD

A common mistake is to calculate only:

```text
GCD(str1.length, str2.length)
```

That is not enough.

Consider:

```text
str1 = "ABAB"
str2 = "ABAC"
```

Both strings have length `4`.

Therefore:

```text
GCD(4, 4) = 4
```

But `"ABAB"` cannot construct `"ABAC"`.

The strings do not have the same repeating pattern.

That's why the concatenation check is necessary **before** calculating the answer.

---

# 7. Algorithm

The complete algorithm is:

### Step 1

Check whether:

```text
str1 + str2 == str2 + str1
```

If they are not equal, return an empty string.

### Step 2

Calculate:

```text
GCD(str1.length, str2.length)
```

### Step 3

Take the prefix of `str1` whose length equals the calculated GCD.

### Step 4

Return that prefix.

---

# 8. Complexity Analysis

Let:

* `n` = length of `str1`
* `m` = length of `str2`

### Time Complexity

The concatenation comparison processes the characters of both strings:

```text
O(n + m)
```

The Euclidean Algorithm takes:

```text
O(log(min(n, m)))
```

Extracting the substring takes at most:

```text
O(min(n, m))
```

Therefore, the overall time complexity is:

```text
O(n + m)
```

### Space Complexity

Apart from temporary strings created during concatenation and substring operations, the algorithm uses constant extra variables:

```text
O(1)
```

---

# 9. Key Insight

The entire problem can be reduced to two observations:

```text
Same repeating pattern
        ↓
str1 + str2 == str2 + str1
        ↓
Find common length
        ↓
GCD(str1.length, str2.length)
        ↓
Extract that prefix
```

The important insight is that **GCD is applied to the lengths of the strings, not directly to the strings themselves**.

---

# 10. Takeaway

This problem combines **string manipulation** with a classic mathematical algorithm.

The key lessons are:

* Use concatenation equality to verify that two strings share the same repeating pattern.
* Use the GCD of their lengths to find the largest possible common divisor length.
* Use the Euclidean Algorithm to calculate the GCD efficiently.
* Avoid checking every possible substring because that would be unnecessary work.

### Pattern to Remember

> **Same repeating pattern → GCD of lengths → Extract prefix**
