# 88. Merge Sorted Array

## Problem Statement

You are given two sorted integer arrays:

* `nums1` with a length of `m + n`, where the first `m` elements are valid and the remaining `n` elements are `0` (empty space).
* `nums2` with `n` sorted elements.

Merge `nums2` into `nums1` so that the final array is sorted in non-decreasing order.

The merge must be performed **in-place**, meaning you cannot return a new array.

---

# Intuition

A straightforward idea is to compare elements from the beginning of both arrays and place the smaller one into a new array.

However, this is **not allowed** because the problem requires modifying `nums1` in-place without using extra space.

The key observation is:

* The empty spaces already exist at the **end** of `nums1`.
* If we start filling from the **back**, we will never overwrite any important values.
* Since both arrays are already sorted, the largest remaining element will always be either:

  * the current element in `nums1`, or
  * the current element in `nums2`.

So we repeatedly place the larger element at the last available position.

---

# Approach

Maintain three pointers:

* `i` → Last valid element in `nums1`
* `j` → Last element in `nums2`
* `k` → Last index of `nums1`

### Step 1

Initialize:

* `i = m - 1`
* `j = n - 1`
* `k = m + n - 1`

---

### Step 2

Compare:

* `nums1[i]`
* `nums2[j]`

If:

* `nums1[i] > nums2[j]`

  * Place `nums1[i]` at `nums1[k]`
  * Move `i` left.

Otherwise:

* Place `nums2[j]` at `nums1[k]`
* Move `j` left.

Move `k` left after every placement.

---

### Step 3

Continue until one array becomes empty.

---

### Step 4

If elements still remain in `nums2`, copy them into the front of `nums1`.

There is **no need** to copy remaining elements from `nums1` because they are already in their correct positions.

---

# Dry Run

### Input

```
nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3
```

Initially

```
i = 2 (3)
j = 2 (6)
k = 5
```

---

### Iteration 1

Compare

```
3 vs 6
```

6 is larger.

```
[1,2,3,0,0,6]
```

Move

```
j = 1
k = 4
```

---

### Iteration 2

Compare

```
3 vs 5
```

5 is larger.

```
[1,2,3,0,5,6]
```

Move

```
j = 0
k = 3
```

---

### Iteration 3

Compare

```
3 vs 2
```

3 is larger.

```
[1,2,3,3,5,6]
```

Move

```
i = 1
k = 2
```

---

### Iteration 4

Compare

```
2 vs 2
```

Choose `nums2`.

```
[1,2,2,3,5,6]
```

Move

```
j = -1
```

Loop ends.

Remaining elements in `nums1` are already correctly placed.

---

### Final Output

```
[1,2,2,3,5,6]
```

---

# Why Does This Work?

The algorithm always places the **largest remaining element** into the last available position.

Since we fill from right to left:

* No valid element in `nums1` gets overwritten.
* Every position is filled exactly once.
* The sorted order is preserved throughout the process.

---

# Time Complexity

* Main merge loop: **O(m + n)**
* Copy remaining elements (if any): **O(n)** in the worst case.

Overall Time Complexity:

```
O(m + n)
```

---

# Space Complexity

Only three integer pointers are used.

```
O(1)
```

No extra array is created.

---

# Key Takeaways

* Merge from the **end**, not from the beginning.
* Filling from the back prevents overwriting useful elements.
* Three pointers make the solution simple and efficient.
* Remaining elements of `nums1` never need to be copied.
* This is the optimal solution with **O(m + n)** time and **O(1)** extra space.
