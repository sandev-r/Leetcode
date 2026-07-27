# LeetCode 2000 - Reverse Prefix of Word

## Difficulty
Easy

---

# Problem Statement

You are given:

- A string `word`
- A character `ch`

Your task is to reverse the substring from the beginning of the string up to the **first occurrence** of `ch`.

If `ch` does not exist in the string, return the original string unchanged.

---

# Intuition

The problem only asks us to reverse the prefix until the **first occurrence** of the given character.

Instead of creating multiple strings or using expensive string operations, we can:

1. Convert the string into a character array.
2. Traverse the array to locate the first occurrence of `ch`.
3. Once found, reverse the characters between index `0` and that position using the two-pointer technique.
4. Convert the modified character array back into a string.

Since only one prefix needs to be reversed, there is no need to continue searching after the first occurrence.

---

# Approach

1. Convert the given string into a character array.
2. Traverse the array from left to right.
3. When the first occurrence of `ch` is found:
   - Initialize two pointers:
     - `left = 0`
     - `right = index of ch`
   - Swap the characters at both pointers.
   - Move `left` forward and `right` backward.
   - Continue until both pointers meet or cross.
4. Convert the updated character array into a string and return it.
5. If the character is never found, return the original string.

---

# Dry Run

### Input

```text
word = "abcdefd"
ch = 'd'
```

### Step 1

Character array:

```text
[a, b, c, d, e, f, d]
```

The first occurrence of `'d'` is at index **3**.

Pointers:

```text
left = 0
right = 3
```

---

### Swap 1

Swap index 0 and 3.

```text
[d, b, c, a, e, f, d]
```

Move pointers:

```text
left = 1
right = 2
```

---

### Swap 2

Swap index 1 and 2.

```text
[d, c, b, a, e, f, d]
```

Move pointers:

```text
left = 2
right = 1
```

Loop ends because `left > right`.

---

### Final Output

```text
"dcbaefd"
```

---

# Why the Two-Pointer Technique Works

Reversing a sequence simply means exchanging the first element with the last, the second with the second-last, and so on.

The two-pointer approach performs exactly this operation:

- One pointer starts from the beginning.
- The other starts from the end of the prefix.
- Each swap places two characters in their correct reversed positions.
- The process continues until all characters in the prefix have been reversed.

This method is efficient because every character is swapped at most once.

---

# Time Complexity

### Traversing the string

Finding the first occurrence of `ch` takes:

```text
O(n)
```

where `n` is the length of the string.

### Reversing the prefix

The reversal takes at most:

```text
O(n)
```

In the worst case, the prefix includes the entire string.

### Overall Time Complexity

```text
O(n)
```

---

# Space Complexity

The character array stores all characters of the string.

```text
O(n)
```

No additional data structures proportional to the input size are used beyond the character array.

---

# Key Takeaways

- Convert the string into a character array for easy modification.
- Search only until the first occurrence of the target character.
- Use the two-pointer technique to reverse the required prefix efficiently.
- Return immediately after reversing since only the first occurrence matters.
- If the character is not present, simply return the original string.
