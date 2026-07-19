# 2011. Final Value of Variable After Performing Operations

## Problem Summary

You are given an array of strings `operations`, where each string represents an operation performed on a variable `X`.

Initially:

```text
X = 0
```

Each operation can be one of the following:

- `"++X"` → Increment `X`
- `"X++"` → Increment `X`
- `"--X"` → Decrement `X`
- `"X--"` → Decrement `X`

Return the final value of `X` after performing all the operations.

---

## Intuition

Instead of checking all four possible operation strings separately, we can observe a simple pattern.

- Every decrement operation (`"--X"` or `"X--"`) has `'-'` either at the **beginning** or at the **end** of the string.
- Every increment operation (`"++X"` or `"X++"`) has `'+'` at both the beginning and the end.

So, if the **first** or **last** character is `'-'`, we decrement `X`. Otherwise, we increment it.

This avoids multiple string comparisons and keeps the solution clean.

---

## Key Observation

The operation type can be identified using only the first and last characters.

| Operation | First Character | Last Character | Action |
|-----------|-----------------|----------------|--------|
| `"++X"` | `+` | `X` | Increment |
| `"X++"` | `X` | `+` | Increment |
| `"--X"` | `-` | `X` | Decrement |
| `"X--"` | `X` | `-` | Decrement |

Therefore,

```java
if (ch.charAt(0) == '-' || ch.charAt(ch.length() - 1) == '-')
```

is enough to detect a decrement operation.

---

## Approach

1. Initialize `X = 0`.
2. Traverse every operation in the array.
3. Check:
   - If the first character or the last character is `'-'`, decrement `X`.
   - Otherwise, increment `X`.
4. Return `X`.

---

## Dry Run

### Input

```text
operations = ["--X","X++","X++"]
```

Initial value:

```text
X = 0
```

| Operation | Check | Action | X |
|-----------|-------|--------|---|
| "--X" | First character is `'-'` | Decrement | -1 |
| "X++" | No `'-'` at first or last | Increment | 0 |
| "X++" | No `'-'` at first or last | Increment | 1 |

Final Answer:

```text
1
```

---

## Algorithm

1. Set `X = 0`.
2. For each operation:
   - If the first character is `'-'` **or** the last character is `'-'`
     - Decrement `X`.
   - Otherwise
     - Increment `X`.
3. Return `X`.

---

## Why This Works

There are only four valid operations.

- Both decrement operations contain `'-'` at either the beginning or the end.
- Neither increment operation satisfies this condition.

Therefore, every operation is correctly classified, and updating `X` accordingly produces the correct final value.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - Each operation is processed exactly once.

- **Space Complexity:** `O(1)`
  - Only one integer variable is used.

---

## Key Takeaways

- Look for patterns instead of comparing every possible string.
- Checking only the first and last characters is enough to determine the operation.
- Simple observations can make the code shorter and easier to read.
- This is a classic simulation problem with linear time and constant space complexity.
