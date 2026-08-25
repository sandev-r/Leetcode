# LeetCode 2215 — Find the Difference of Two Arrays

## Difficulty

Easy

## Problem Statement

Given two integer arrays `nums1` and `nums2`, return a list containing two lists:

* The first list contains all **distinct integers present in `nums1` but not in `nums2`**.
* The second list contains all **distinct integers present in `nums2` but not in `nums1`**.

The order of the elements does not matter.

---

## Intuition

The main problem is to find the **difference between two arrays**.

For example:

```text
nums1 = [1, 2, 3, 3]
nums2 = [2, 4, 6]

nums1 but not nums2 → [1, 3]
nums2 but not nums1 → [4, 6]
```

There are two important requirements:

1. We only need **unique elements**.
2. We need to quickly check whether an element exists in the other array.

A `HashSet` is perfect for both requirements.

### Why HashSet?

When we insert the arrays into sets:

```text
nums1 → {1, 2, 3}
nums2 → {2, 4, 6}
```

Duplicates automatically disappear.

Then we can use:

```text
set2.contains(n)
```

to quickly check whether an element from `nums1` exists in `nums2`.

---

## Approach

### Step 1 — Store unique elements of `nums1`

Insert every element of `nums1` into `set1`.

```text
nums1 = [1, 2, 3, 3]

set1 = {1, 2, 3}
```

The duplicate `3` is automatically removed.

### Step 2 — Store unique elements of `nums2`

Insert every element of `nums2` into `set2`.

```text
nums2 = [2, 4, 6]

set2 = {2, 4, 6}
```

### Step 3 — Find elements only in `nums1`

Iterate through `set1`.

For each element:

```text
if it does NOT exist in set2
    add it to first
```

Example:

```text
set1 = {1, 2, 3}
set2 = {2, 4, 6}

1 → not in set2 → add
2 → exists in set2 → skip
3 → not in set2 → add

first = [1, 3]
```

### Step 4 — Find elements only in `nums2`

Do the reverse.

For every element in `set2`:

```text
if it does NOT exist in set1
    add it to second
```

```text
2 → exists in set1 → skip
4 → not in set1 → add
6 → not in set1 → add

second = [4, 6]
```

### Step 5 — Return both lists

The final result is:

```text
[
    [1, 3],
    [4, 6]
]
```

---

## Complexity

Let:

* `n` = length of `nums1`
* `m` = length of `nums2`

### Time Complexity

```text
O(n + m)
```

We traverse both arrays to build the sets and then traverse both sets to find the differences.

`HashSet.contains()` takes **O(1)** average time.

### Space Complexity

```text
O(n + m)
```

We store the unique elements of both arrays in two sets, along with the result lists.

---

## Key Takeaway

When a problem asks for **unique elements** and requires frequent **existence checks**, think of a `HashSet`.

The core idea is:

```text
Array
  ↓
HashSet
  ↓
Remove duplicates
  ↓
contains() → Check existence
  ↓
Find elements missing from the other set
```

This converts the problem from repeatedly searching through arrays into a simple **set difference** operation.
