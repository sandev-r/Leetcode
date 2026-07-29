# 1684. Count the Number of Consistent Strings

## Intuition

A string is **consistent** if **every character** in the string exists in the `allowed` string.

Instead of searching through `allowed` for every character of every word, we can first store all allowed characters in a lookup structure.

Since the problem only contains lowercase English letters (`a-z`), a boolean array of size `26` is enough.

- `true` → character is allowed.
- `false` → character is not allowed.

Now, for every word:

- Check each character.
- If any character is not allowed, immediately stop checking that word.
- Otherwise, count it as a consistent string.

This avoids repeated searching and makes every character lookup constant time.

---

## Approach

1. Create a boolean array `allowedArr` of size `26`.
2. Traverse the `allowed` string.
   - Mark each character as `true`.
3. Initialize `count = 0`.
4. Traverse every word.
5. For each word:
   - Assume it is consistent.
   - Check every character.
   - If a character is not marked as allowed:
     - Mark the word as inconsistent.
     - Stop checking the remaining characters.
6. If the word remained consistent, increment the answer.
7. Return the final count.

---

## Dry Run

### Input

```text
allowed = "ab"
words = ["ad","bd","aaab","baa","badab"]
```

### Step 1

Store allowed characters.

```text
Allowed Characters:

a → true
b → true
others → false
```

---

### Step 2

Check each word.

#### Word = "ad"

```text
a → allowed
d → not allowed

Result → Not Consistent
```

Count = **0**

---

#### Word = "bd"

```text
b → allowed
d → not allowed

Result → Not Consistent
```

Count = **0**

---

#### Word = "aaab"

```text
a → allowed
a → allowed
a → allowed
b → allowed

Result → Consistent
```

Count = **1**

---

#### Word = "baa"

```text
b → allowed
a → allowed
a → allowed

Result → Consistent
```

Count = **2**

---

#### Word = "badab"

```text
b → allowed
a → allowed
d → not allowed

Stop immediately.
```

Count = **2**

---

### Final Answer

```text
2
```

---

## Time Complexity

### Building the lookup array

There are at most 26 lowercase letters.

```
O(allowed.length())
```

### Checking all words

Every character of every word is visited at most once.

```
O(total characters in all words)
```

### Overall

```
O(allowed.length() + total characters in all words)
```

---

## Space Complexity

The boolean array always contains exactly **26** elements.

```
O(1)
```

(Constant extra space.)

---

## Why use a Boolean Array?

A boolean array is ideal because:

- Only lowercase English letters exist.
- Character lookup becomes **O(1)**.
- Faster than using `HashSet`.
- Uses only 26 boolean values, making it memory efficient.

This makes the solution both simple and optimal.

---

## Key Takeaways

- Convert repeated membership checks into constant-time lookups.
- Boolean arrays are perfect for fixed-size character sets.
- Stop checking a word as soon as an invalid character is found (Early Break).
- Overall complexity is linear in the total number of characters processed.
