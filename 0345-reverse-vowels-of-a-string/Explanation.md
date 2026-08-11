# 345. Reverse Vowels of a String

**Difficulty:** Easy

---

## Problem Statement

Given a string `s`, reverse **only the vowels** in the string.

The vowels are:

* `a, e, i, o, u`
* `A, E, I, O, U`

All consonants and other characters must remain in their original positions.

### Example

**Input:**
`hello`

**Output:**
`holle`

The vowels are `e` and `o`, so they are swapped while the consonants remain unchanged.

---

## Intuition

The important observation is that we **do not need to move every character**.

We only care about vowels.

Use **two pointers**:

* `start` → begins from the left
* `end` → begins from the right

The goal is to find:

> **the first vowel from the left and the first vowel from the right, then swap them.**

After swapping:

* Move `start` forward.
* Move `end` backward.
* Repeat until the pointers meet.

This naturally reverses the order of the vowels.

### Visual Idea

```text
h e l l o
  ↑     ↑
start   end

e and o are vowels → swap

h o l l e
```

The consonants are never intentionally moved.

---

## Approach

### Step 1: Convert the String into a Character Array

Strings in Java are immutable, so directly changing characters inside the string is not possible.

Convert the string into a character array so individual characters can be modified.

---

### Step 2: Initialize Two Pointers

Set:

* `start = 0`
* `end = length - 1`

So:

```text
start → beginning
end   → end
```

---

### Step 3: Find a Vowel from the Left

Check the character at `start`.

If it is **not a vowel**:

* Move `start` one position forward.

Continue until:

* `start` reaches a vowel, or
* the pointers meet.

---

### Step 4: Find a Vowel from the Right

Check the character at `end`.

If it is **not a vowel**:

* Move `end` one position backward.

Continue until `end` reaches a vowel.

---

### Step 5: Swap the Two Vowels

Once both pointers are pointing at vowels:

```text
start → vowel
end   → vowel
```

Swap those two characters.

Then move both pointers:

```text
start++
end--
```

This ensures the next pair of vowels is processed.

---

### Step 6: Repeat

Continue the process while:

```text
start < end
```

When the pointers meet or cross, every required vowel has been reversed.

---

## Dry Run

Let's take:

```text
s = "hello"
```

Initial state:

```text
h e l l o
↑       ↑
S       E
```

### Iteration 1

`start` points to `h`.

`h` is not a vowel.

Move `start`:

```text
h e l l o
  ↑     ↑
  S     E
```

Now `start` points to `e`, which is a vowel.

`end` points to `o`, which is also a vowel.

Swap them:

```text
h o l l e
```

Then:

```text
start++
end--
```

---

### Iteration 2

```text
h o l l e
    ↑ ↑
    S E
```

`l` is not a vowel, so `start` moves forward.

`l` is still not a vowel, so `start` moves again.

The pointers now meet.

No more swapping is required.

### Final Result

```text
"holle"
```

---

## Dry Run Table

| Step | `start` | `end` | Left Character | Right Character | Action               |
| ---- | ------: | ----: | -------------- | --------------- | -------------------- |
| 1    |       0 |     4 | `h`            | `o`             | Move `start`         |
| 2    |       1 |     4 | `e`            | `o`             | Both vowels → Swap   |
| 3    |       2 |     3 | `l`            | `l`             | Move `start`         |
| 4    |       3 |     3 | `l`            | `l`             | Pointers meet → Stop |

Final string:

```text
holle
```

---

## Another Example

Consider:

```text
s = "leetcode"
```

Vowels are:

```text
e e o e
```

Reversed order:

```text
e o e e
```

The algorithm swaps the vowels from the outside toward the center:

```text
l e e t c o d e
  ↑           ↑
  e           e

l e e t c o d e
    ↑       ↑
    e       o
```

After the required swaps:

```text
leotcede
```

The consonants remain in their original positions.

---

## Correctness

We need to prove that the algorithm correctly reverses only the vowels.

### 1. Non-vowels are never swapped

The algorithm moves the pointers past characters that are not vowels.

Therefore, a swap only happens when both `start` and `end` point to vowels.

So consonants remain in their original positions.

### 2. The outermost vowels are swapped first

`start` finds the first vowel from the left.

`end` finds the first vowel from the right.

These are the first and last vowels in the string, so swapping them puts them in their reversed positions.

### 3. The process continues inward

After every swap:

```text
start++
end--
```

Therefore, the next pair of vowels is found inside the already-processed region.

### 4. Every vowel gets its reversed position

The process continues until the pointers meet.

Thus, every vowel is paired with the corresponding vowel from the opposite side.

Therefore, the final string contains all vowels in reverse order while all non-vowels remain unchanged.

---

## Time Complexity

**O(n)**

Each character is visited at most a constant number of times by the two pointers.

Therefore, for a string of length `n`:

```text
Time = O(n)
```

---

## Space Complexity

**O(n)**

The string is converted into a character array of size `n`.

Therefore:

```text
Space = O(n)
```

The two pointers themselves use only constant space, but the character array requires `O(n)` space.

---

## Key Takeaways

* Use the **two-pointer technique** when processing elements from both ends.
* When only specific characters matter, skip everything else.
* Here, the pointers search specifically for vowels.
* Swap the leftmost and rightmost vowels.
* Move both pointers inward after every swap.
* Converting the string to a character array allows in-place character modification.
* The important pattern is:

```text
Find → Find → Swap → Move inward → Repeat
```

This is a classic **Two Pointers** problem.
