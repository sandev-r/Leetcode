# LeetCode 2390 — Removing Stars From a String

## Difficulty

**Medium**

## Problem Statement

You are given a string `s` containing lowercase English letters and the `*` character.

Whenever a `*` appears:

* Remove the `*`.
* Remove the **closest non-`*` character to its left**.

Continue this process for every `*` in the string.

Return the resulting string after all stars have been removed.

It is guaranteed that the input is valid, meaning there is always a character available to remove when a `*` is encountered.

---

## Intuition

The key observation is that every `*` removes the **most recently added character** that has not already been removed.

That is exactly **Last-In, First-Out (LIFO)** behavior.

For example:

```text
s = "leet**cod*e"

Read characters from left to right:

l → le → lee → leet
* → remove t
* → remove e
c → leec
o → leeco
d → leecod
* → remove d
e → leecoe

Result = "lecoe"
```

We need a data structure that can efficiently:

* Add a character to the end.
* Remove the most recently added character.

A `StringBuilder` works perfectly because its last character can be removed directly.

---

## Approach

Use a `StringBuilder` as the result being constructed.

### Step 1: Traverse the string

Process every character from left to right.

### Step 2: If the character is not `*`

Append it to the `StringBuilder`.

```text
Input:  a b c
Result: a b c
```

The characters are stored in the same order as they appear.

### Step 3: If the character is `*`

The star itself should not be added.

Instead, remove the last character currently stored in the `StringBuilder`.

```text
Result before *: "abc"

* appears

Remove last character:
"ab"
```

This works because the last stored character is the closest non-star character to the left that has not already been removed.

### Step 4: Return the remaining characters

After processing the entire string, the `StringBuilder` contains exactly the characters that remain after applying all star operations.

---

## Complexity

Let `n` be the length of the input string.

### Time Complexity

**O(n)**

Each character is processed once, and appending or deleting the last character from a `StringBuilder` takes constant time.

### Space Complexity

**O(n)**

In the worst case, the `StringBuilder` stores almost all characters from the input.

---

## Key Takeaway

The important pattern is:

> **When an operation repeatedly removes the most recently added element, think LIFO → Stack.**

For this problem, a `StringBuilder` can act like a stack:

```text
append()          → push
delete last char  → pop
```

So the problem is essentially a **stack simulation**, with `StringBuilder` providing an efficient way to implement that behavior while building the final string.
