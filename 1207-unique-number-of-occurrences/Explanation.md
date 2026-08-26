# LeetCode 1207 — Unique Number of Occurrences

## Difficulty

Easy

## Problem Statement

Given an array of integers `arr`, determine whether the number of occurrences of each value is unique.

Return `true` if every distinct value appears a different number of times. Otherwise, return `false`.

### Example

```text
Input:  arr = [1,2,2,1,1,3]

Occurrences:
1 → 3 times
2 → 2 times
3 → 1 time

All occurrence counts are unique.

Output: true
```

---

## Intuition

The problem has **two separate things to track**:

1. **How many times each number appears**
2. **Whether those occurrence counts are already used**

For example:

```text
arr = [1,2,2,1,1,3]

        Count
1  ───────────► 3
2  ───────────► 2
3  ───────────► 1
```

A `HashMap` is useful for the first part because it stores:

```text
number → frequency
```

Then we need to check whether the frequencies themselves are unique.

For that, we use a `HashSet`:

```text
HashMap                      HashSet

1 → 3                        {3}
2 → 2                        {3, 2}
3 → 1                        {3, 2, 1}
```

If a frequency is already present in the set, two different numbers have the same occurrence count, so we return `false`.

---

## Approach

### Step 1: Count the frequency of every number

Create a `HashMap<Integer, Integer>`.

For every number in the array:

```text
countMap.put(i, countMap.getOrDefault(i, 0) + 1);
```

`getOrDefault(i, 0)` means:

* If `i` already exists → get its current count.
* If `i` doesn't exist → use `0`.

Example:

```text
arr = [1,2,2,1,1,3]

countMap:

1 → 3
2 → 2
3 → 1
```

---

### Step 2: Check whether the frequencies are unique

Create a `HashSet<Integer>` to store frequencies that have already appeared.

Traverse `countMap.values()`:

```text
3
2
1
```

For every frequency:

```text
if (set.contains(i))
    return false;

set.add(i);
```

The logic is:

```text
Frequency already exists?
        │
   ┌────┴────┐
  YES        NO
   │          │
 false     add it
```

For example:

```text
Frequencies: [3, 2, 1]

3 → not present → add 3
2 → not present → add 2
1 → not present → add 1

All are unique → true
```

But:

```text
Frequencies: [3, 2, 3]

3 → add
2 → add
3 → already exists → false
```

---

## Complexity

### Time Complexity

**O(n)**

* Counting frequencies takes `O(n)`.
* Checking all unique frequencies takes at most `O(n)`.

Therefore:

```text
O(n) + O(n) = O(n)
```

### Space Complexity

**O(n)**

The `HashMap` and `HashSet` can store up to `n` elements in the worst case.

---

## Key Takeaway

The key idea is to use **two different data structures for two different jobs**:

```text
HashMap
   ↓
number → frequency

HashSet
   ↓
frequency → check uniqueness
```

The important observation is:

> We are not checking whether the numbers are unique. We are checking whether their **frequencies** are unique.

So the overall pattern is:

```text
Array
  ↓
Count frequencies with HashMap
  ↓
Extract frequencies
  ↓
Check duplicates with HashSet
  ↓
Duplicate frequency? → false
No duplicate?        → true
```
