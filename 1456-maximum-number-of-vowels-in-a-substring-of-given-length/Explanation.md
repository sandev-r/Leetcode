# LeetCode 1456 - Maximum Number of Vowels in a Substring of Given Length

## 🟢 Difficulty

**Medium**

---

# 📝 Problem Statement

Given a string `s` and an integer `k`, find the **maximum number of vowels** present in any substring of `s` having exactly `k` characters.

The vowels are:

```text
a, e, i, o, u
```

### Example

```text
Input:
s = "abciiidef"
k = 3

Output:
3
```

The substring `"iii"` contains 3 vowels, which is the maximum.

---

# 💡 Intuition

We need to check every substring of length `k` and find the one containing the most vowels.

A brute-force solution would count the vowels again for every substring.

For example:

```text
[a b c]
  [b c i]
    [c i i]
      [i i i]
```

Most characters are repeated between consecutive windows.

There is no need to count them again.

Instead, we can use a **Fixed-Size Sliding Window**.

When the window moves one position:

* One character leaves the window.
* One new character enters the window.
* We only need to update the vowel count for these two characters.

This reduces the time complexity from **O(n × k)** to **O(n)**.

---

# 🚀 Approach

### Step 1: Create the First Window

Take the first `k` characters of the string.

Count how many of them are vowels.

Store this count in `count`.

Also initialize:

```text
maxCount = count
```

---

### Step 2: Slide the Window

Start from index `k`.

For every new character:

1. Identify the character entering the window.
2. Identify the character leaving the window.
3. If the leaving character is a vowel, decrease `count`.
4. If the entering character is a vowel, increase `count`.
5. Update `maxCount`.

The character leaving the window is always:

```text
i - k
```

So:

```text
Entering character = s[i]
Leaving character  = s[i - k]
```

---

### Step 3: Update the Maximum

After updating the current window's vowel count:

```text
maxCount = max(maxCount, count)
```

After all windows have been processed, `maxCount` is the answer.

---

# 🔍 Dry Run

### Input

```text
s = "abciiidef"
k = 3
```

### Initial Window

```text
[a b c]
```

| Character | Action              |
| --------- | ------------------- |
| `a`       | Vowel → `count = 1` |
| `b`       | Consonant           |
| `c`       | Consonant           |

```text
count = 1
maxCount = 1
```

---

### Step 2

Window moves from:

```text
[a b c]
```

to:

```text
[b c i]
```

| Character | Action                     |
| --------- | -------------------------- |
| `a`       | Leaves → vowel → `count--` |
| `i`       | Enters → vowel → `count++` |

```text
count = 1
maxCount = 1
```

---

### Step 3

Window:

```text
[c i i]
```

| Character | Action                     |
| --------- | -------------------------- |
| `b`       | Leaves → consonant         |
| `i`       | Enters → vowel → `count++` |

```text
count = 2
maxCount = 2
```

---

### Step 4

Window:

```text
[i i i]
```

| Character | Action                     |
| --------- | -------------------------- |
| `c`       | Leaves → consonant         |
| `i`       | Enters → vowel → `count++` |

```text
count = 3
maxCount = 3
```

We have found:

```text
[i i i]
```

which contains **3 vowels**.

---

### Step 5

Window:

```text
[i i d]
```

| Character | Action                     |
| --------- | -------------------------- |
| `i`       | Leaves → vowel → `count--` |
| `d`       | Enters → consonant         |

```text
count = 2
maxCount = 3
```

The maximum remains `3`.

---

### Final Output

```text
3
```

---

# ✅ Correctness

The algorithm always maintains the number of vowels in the **current substring of length `k`**.

When the window moves:

* The outgoing character is removed from the count if it is a vowel.
* The incoming character is added to the count if it is a vowel.

Therefore, `count` always represents the exact number of vowels in the current window.

Since `maxCount` is updated after processing every window, it stores the largest vowel count found among all substrings of length `k`.

Therefore, the returned value is correct.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Each character is processed at most twice:

* Once when it enters the window.
* Once when it leaves the window.

Therefore, the total work is linear in the length of the string.

### Space Complexity

**O(1)**

Only a few variables are used:

* `count`
* `maxCount`
* loop variables
* characters

No additional data structure is required.

---

# 🎯 Key Takeaways

1. This is a **Fixed-Size Sliding Window** problem.
2. The window size is always exactly `k`.
3. Don't recount the entire window after every movement.
4. Remove the contribution of the outgoing element and add the contribution of the incoming element.
5. Whenever a problem asks for the maximum/minimum/count inside every subarray or substring of fixed size `k`, **think Sliding Window first**.
