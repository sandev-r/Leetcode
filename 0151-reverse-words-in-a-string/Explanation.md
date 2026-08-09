# LeetCode 151 — Reverse Words in a String

## Problem

Given a string `s`, reverse the order of the words.

A word is a sequence of non-space characters. The result must:

* Remove leading spaces.
* Remove trailing spaces.
* Replace multiple spaces between words with a single space.
* Reverse the order of the words.

### Example

**Input:**
`"  hello   world  "`

**Output:**
`"world hello"`

---

# Approach

The solution uses an **in-place character array + reversal technique**.

Instead of directly building the result word by word, the algorithm performs three main operations:

```text
1. Remove unnecessary spaces
        ↓
2. Reverse the entire string
        ↓
3. Reverse each individual word
```

This works because reversing everything reverses both:

* the order of the words
* the characters inside every word

Then reversing each word again restores the characters while keeping the words in reversed order.

---

# Step 1 — Convert the String to a Character Array

The input string is immutable in Java, so it is converted into a character array.

```text
"the sky is blue"

        ↓

['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
```

The array allows the algorithm to modify characters directly.

---

# Step 2 — Remove Extra Spaces In-Place

The solution first removes unnecessary spaces.

It uses two pointers:

```text
read  → scans the original characters
write → places valid characters
```

The `previousWasSpace` flag determines whether the previous accepted character was already a space.

### Example

```text
Input:

"hello   world"

read:

hello___world
     ↑
   spaces

After compression:

"hello world"
```

Whenever multiple consecutive spaces are encountered, only the first one is written.

Because the string was already trimmed before this step, there are no leading or trailing spaces to handle.

### Why do this first?

It guarantees that the meaningful part of the array has this structure:

```text
word1 word2 word3 word4
```

with exactly one space between words.

The variable `write` represents the length of this meaningful portion.

---

# Step 3 — Reverse the Entire String

Now reverse the entire meaningful portion of the array.

For example:

```text
"the sky is blue"

        ↓ reverse

"eulb si yks eht"
```

At this point, the words are in the correct reversed order, but every word itself is backwards.

```text
eulb si yks eht
 ↑     ↑   ↑   ↑
wrong characters
```

---

# Step 4 — Reverse Each Individual Word

Now scan the reversed array and identify each word using spaces.

Whenever a space is found:

```text
start ───────── i-1
        word
```

Reverse that section.

For example:

```text
"eulb si yks eht"

Reverse "eulb"
        ↓

"blue si yks eht"

Reverse "si"
        ↓

"blue is yks eht"

Reverse "yks"
        ↓

"blue is sky eht"

Reverse "eht"
        ↓

"blue is sky the"
```

The final result is:

```text
"blue is sky the"
```

Wait — this demonstrates an important distinction: after reversing the **entire sequence**, the words themselves are reversed but their order is also reversed. Reversing each word therefore gives:

```text
"blue is sky the"
```

which is exactly the words of the original string in reverse order.

---

# Why Does This Work?

Consider:

```text
Original:

"the sky blue"
```

Represent the words as:

```text
A B C
```

Reversing the entire character sequence produces:

```text
C B A
```

but every word is internally reversed:

```text
Cᵣ Bᵣ Aᵣ
```

Reversing each individual word gives:

```text
C B A
```

Therefore:

```text
Original:
A B C

Reverse everything:
Cᵣ Bᵣ Aᵣ

Reverse every word:
C B A
```

So the order of the words is reversed while the characters inside each word are restored.

---

# Example Walkthrough

Consider:

```text
Input:

"  hello   world  "
```

### After trimming

```text
"hello   world"
```

### After removing consecutive spaces

```text
"hello world"
```

### Reverse entire meaningful portion

```text
"dlrow olleh"
```

### Reverse each word

```text
"world hello"
```

### Final result

```text
"world hello"
```

---

# Important Implementation Detail

The algorithm does not necessarily use the entire character array after removing extra spaces.

Suppose the original array has unused characters after compression:

```text
Original array:

[h e l l o _ _ _ w o r l d ...]
                ↑
              unused
```

The `write` pointer tells us where the meaningful portion ends.

Therefore, all reversal operations are restricted to:

```text
index 0 → write - 1
```

and the final string is created only from that meaningful portion.

This avoids accidentally processing leftover characters.

---

# Complexity Analysis

### Time Complexity

**O(n)**

The algorithm performs several linear scans:

1. Remove extra spaces → `O(n)`
2. Reverse the meaningful portion → `O(n)`
3. Reverse each word → `O(n)`

Therefore:

```text
O(n) + O(n) + O(n)
        ↓
      O(n)
```

### Space Complexity

**O(n)**

The input string is converted into a character array.

Apart from that, only a constant number of variables are used.

So the auxiliary algorithmic space is:

```text
O(1)
```

while the character array itself requires:

```text
O(n)
```

---

# Edge Cases

### 1. Single word

```text
Input:
"hello"

Output:
"hello"
```

No word-order change is necessary.

### 2. Leading and trailing spaces

```text
Input:
"   hello world   "

Output:
"world hello"
```

The initial `trim()` removes them.

### 3. Multiple spaces

```text
Input:
"hello     world"

Output:
"world hello"
```

Consecutive spaces are compressed into one.

### 4. Only one word with spaces

```text
Input:
"   hello   "

Output:
"hello"
```

### 5. Empty string

```text
Input:
""

Output:
""
```

---

# Key Pattern

The main technique to remember is:

```text
Normalize
    ↓
Reverse everything
    ↓
Reverse every word
```

This is a classic **string manipulation + reversal** pattern.

The important insight is:

> **Reverse the entire sequence to reverse word order, then reverse each word to restore its characters.**

---

# Takeaway

This solution is efficient because it avoids repeatedly creating substrings or constructing the result word by word.

The core idea is:

```text
"the sky is blue"

        ↓
Remove extra spaces

"the sky is blue"

        ↓
Reverse everything

"eulb si yks eht"

        ↓
Reverse each word

"blue is sky the"
```

The combination of **two-pointer space compression** and **reversal** gives an overall **O(n) time complexity** with in-place character manipulation.
