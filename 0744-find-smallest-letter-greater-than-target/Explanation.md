# 744. Find Smallest Letter Greater Than Target

## Problem Summary

You are given a **sorted** array of lowercase English letters and a target character.

Your task is to find the **smallest character that is strictly greater than the target**.

If no such character exists (the target is greater than or equal to the last letter), the search should **wrap around** and return the first character in the array.

---

# Intuition

Since the array is already sorted, checking every element one by one would work, but it is not efficient.

Instead, we can use **Binary Search** to locate the **first letter that is greater than the target**.

The idea is:

* Ignore every letter that is **less than or equal to the target** because they can never be the answer.
* Continue searching the left half whenever a letter is greater than the target because there might be a smaller valid answer.
* At the end of the search, the `start` pointer will point to the first element greater than the target.

---

# Approach

We use the **Half-Open Interval Binary Search**.

### Search Range

```
[start, end)
```

* `start` is inclusive.
* `end` is exclusive.

Initially:

```
start = 0
end = letters.length
```

Notice that `end` is **one position beyond the last index**, making it possible for `start` to become `letters.length`.

---

## Step 1

Find the middle index.

```
mid = start + (end - start) / 2
```

This avoids integer overflow.

---

## Step 2

If

```
letters[mid] <= target
```

then this letter **cannot** be the answer.

Why?

Because the problem asks for a letter **strictly greater** than the target.

So we discard the left half including `mid`.

```
start = mid + 1
```

---

## Step 3

Otherwise,

```
letters[mid] > target
```

This letter is a possible answer.

However, there may still be another valid letter on the left that is smaller.

So we continue searching the left half.

```
end = mid
```

Notice that `mid` is **not removed** because it could be the correct answer.

---

## Step 4

The loop stops when

```
start == end
```

At this point, every position before `start` has already been eliminated.

Therefore,

`start` points to the first letter greater than the target.

---

# Handling the Wrap-Around Case

Suppose

```
letters = ['c','f','j']
target = 'j'
```

There is no character greater than `'j'`.

The search ends with

```
start = letters.length
```

Accessing

```
letters[start]
```

would cause an index out of bounds error.

Instead, use

```
start % letters.length
```

When

```
start == letters.length
```

```
letters.length % letters.length = 0
```

So the search automatically wraps around to the first letter.

Example:

```
letters = ['c','f','j']

start = 3

3 % 3 = 0

Answer = letters[0] = 'c'
```

This satisfies the problem requirement.

---

# Example Walkthrough

### Input

```
letters = ['c','f','j']
target = 'd'
```

### Initial State

```
start = 0
end = 3
```

### Iteration 1

```
mid = 1
letters[mid] = 'f'
```

Since

```
'f' > 'd'
```

search the left half.

```
end = 1
```

---

### Iteration 2

```
start = 0
end = 1

mid = 0
letters[mid] = 'c'
```

Since

```
'c' <= 'd'
```

discard it.

```
start = 1
```

---

Loop ends.

```
start = end = 1
```

Answer:

```
letters[1] = 'f'
```

---

# Why `end = mid` Instead of `mid - 1`?

This binary search is looking for the **first valid answer**, not just any occurrence.

When

```
letters[mid] > target
```

the current letter could already be the smallest valid answer.

Removing it using

```
end = mid - 1
```

might skip the correct answer.

Using

```
end = mid
```

keeps it inside the search space.

---

# Time Complexity

```
O(log n)
```

Each iteration cuts the search space in half.

---

# Space Complexity

```
O(1)
```

Only a few variables are used.

---

# Key Takeaways

* Use a **half-open interval** `[start, end)` binary search.
* Discard letters that are **less than or equal to** the target.
* Keep `mid` when it is a possible answer using `end = mid`.
* After the loop, `start` points to the first valid letter.
* Use `start % letters.length` to handle the required wrap-around case.
