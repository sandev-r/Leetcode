# LeetCode 1768 - Merge Strings Alternately

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

You are given two strings, `word1` and `word2`.

Your task is to merge them **alternately**, starting with a character from `word1`.

For example:

* `word1 = "abc"`
* `word2 = "pqr"`

The result should be:

`"apbqcr"`

If one string is longer than the other, append the remaining characters of the longer string at the end.

### Example

**Input:**

* `word1 = "abc"`
* `word2 = "pqrs"`

**Output:**

* `"apbqcrs"`

The characters are taken in this order:

`a → p → b → q → c → r → s`

---

# 💡 Intuition

The main idea is simple:

> Take one character from `word1`, then one character from `word2`, and repeat.

We need to handle two cases:

1. Both strings still have a character at the current position.
2. One string has already ended, so we only take characters from the other string.

Instead of using two separate loops, we can use **one loop** that continues until we reach the end of the longer string.

---

# 🚀 Approach

### Step 1: Convert both strings into character arrays

The strings are converted into character arrays so that we can access individual characters using an index.

For example:

`"abc"` → `['a', 'b', 'c']`

`"pqrs"` → `['p', 'q', 'r', 's']`

---

### Step 2: Find the length of the longer string

We need to continue the loop until **both strings have been completely processed**.

Therefore, we use:

**maximum length = longer string's length**

For:

* `word1.length = 3`
* `word2.length = 4`

The loop runs `4` times.

---

### Step 3: Create an output array

The final result contains every character from both strings.

Therefore:

**output size = word1.length + word2.length**

For:

* `"abc"` → 3 characters
* `"pqrs"` → 4 characters

Total:

**3 + 4 = 7 characters**

---

### Step 4: Process each position

For every index `i`:

#### First, check `word1`

If:

`i < word1.length`

then the character from `word1` is added to the result.

#### Then, check `word2`

If:

`i < word2.length`

then the character from `word2` is added to the result.

This order is important because the problem says to **start with `word1`**.

---

### Step 5: Continue until the longer string ends

Suppose:

`word1 = "abc"`

`word2 = "pqrs"`

At `i = 3`:

* `word1` has no character at index `3`
* `word2` has `'s'`

So only `'s'` is added.

This automatically handles the extra characters of the longer string.

---

### Step 6: Convert the result into a String

After all characters have been placed into the output array, the character array is converted back into a `String`.

---

# 🔍 Dry Run

Let's take:

```text
word1 = "abc"
word2 = "pqrs"
```

Lengths:

```text
word1.length = 3
word2.length = 4
```

Therefore, the loop runs **4 times**.

| `i` | `word1[i]` | `word2[i]` | Added to output | Output    |
| --: | :--------: | :--------: | :-------------- | :-------- |
|   0 |     `a`    |     `p`    | `a → p`         | `ap`      |
|   1 |     `b`    |     `q`    | `b → q`         | `apbq`    |
|   2 |     `c`    |     `r`    | `c → r`         | `apbqcr`  |
|   3 |      —     |     `s`    | `s`             | `apbqcrs` |

At `i = 3`, `word1` is already finished, so only the character from `word2` is added.

### Final Result

```text
"apbqcrs"
```

---

# ✅ Correctness

The algorithm correctly produces the required merged string because:

1. At every index, it adds the character from `word1` first.
2. It then adds the character from `word2`.
3. It checks whether each string still contains a character before accessing it.
4. The loop continues until the longer string is completely processed.
5. Therefore, every character from both strings appears exactly once and in the required order.

So the resulting string is a valid **alternating merge** of the two input strings.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n + m)**

Where:

* `n` = length of `word1`
* `m` = length of `word2`

Every character from both strings is processed exactly once.

---

### Space Complexity

**O(n + m)**

The output array stores all characters from both strings.

---

# 🎯 Key Takeaways

* Use the **longer string's length** to control the loop.
* At every index, process `word1` first and `word2` second.
* Use boundary checks like `i < word1.length` before accessing a character.
* The boundary checks automatically handle strings of different lengths.
* The output size is always:

**`word1.length + word2.length`**

### Remember the Pattern

```text
word1 → word2 → word1 → word2 → ...
```

When one string finishes:

```text
remaining characters → directly append
```

The key idea is:

> **Loop through the longer string, and independently check whether each string still has a character at that index.**
