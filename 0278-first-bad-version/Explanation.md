# 278. First Bad Version

## Problem Overview

You are given `n` versions of a product numbered from `1` to `n`.

* Once a version becomes **bad**, every version released after it is also bad.
* You are provided with the API:

```java
boolean isBadVersion(version)
```

which returns:

* `true` → the version is bad.
* `false` → the version is good.

Your task is to find the **first bad version** while minimizing the number of API calls.

---

# Intuition

The versions are divided into two parts:

```
Good Versions        Bad Versions
1 2 3 4 5 | 6 7 8 9 10
           ↑
      First Bad Version
```

Notice an important property:

* All versions before the first bad version are **good**.
* The first bad version and every version after it are **bad**.

This forms a **monotonic (sorted) condition**, making **Binary Search** the ideal solution.

Instead of checking every version one by one (`O(n)`), Binary Search repeatedly cuts the search space in half (`O(log n)`).

---

# Approach

Maintain two pointers:

* `start = 1`
* `end = n`

While `start < end`:

1. Find the middle version.
2. Check whether the middle version is bad.

### Case 1: Middle version is bad

```
1 2 3 4 5 6 7 8
      ^
     mid (Bad)
```

If `mid` is bad:

* The first bad version could be `mid` itself.
* It could also be somewhere before `mid`.

So we **cannot discard `mid`**.

Move:

```
end = mid
```

---

### Case 2: Middle version is good

```
1 2 3 4 5 6 7 8
      ^
     mid (Good)
```

If `mid` is good:

* Every version before and including `mid` is guaranteed to be good.
* Therefore, the first bad version must be after `mid`.

Move:

```
start = mid + 1
```

---

Eventually,

```
start == end
```

At this point, only one version remains, which must be the first bad version.

---

# Why `while (start < end)`?

Many Binary Search problems use:

```text
while(start <= end)
```

This problem is different.

Here, we are searching for the **leftmost valid answer**, not merely checking whether a value exists.

When only one element remains:

```
start == end
```

that remaining position is the answer.

So the loop should stop immediately.

Using:

```text
while(start < end)
```

prevents unnecessary iterations and avoids extra boundary checks.

---

# Why `end = mid` instead of `mid - 1`?

Suppose:

```
Versions

1 2 3 4 5 6 7 8
        ^
       mid (Bad)
```

Since `mid` itself could be the **first bad version**, removing it would be incorrect.

If we wrote:

```
end = mid - 1
```

we would completely skip a possible answer.

Instead,

```
end = mid
```

keeps `mid` inside the search range.

---

# Why `start = mid + 1`?

When:

```
mid = Good
```

the first bad version cannot be:

* before `mid`
* at `mid`

So those versions are permanently eliminated.

The search continues from:

```
start = mid + 1
```

---

# Dry Run

### Input

```
n = 5
First Bad Version = 4
```

Initial:

```
start = 1
end = 5
```

### Iteration 1

```
mid = 3

Version 3 -> Good
```

Search right:

```
start = 4
end = 5
```

---

### Iteration 2

```
mid = 4

Version 4 -> Bad
```

Search left including mid:

```
start = 4
end = 4
```

Loop ends.

Answer:

```
4
```

---

# Correctness

At every iteration:

* If `mid` is bad, the first bad version lies in:

```
[start ... mid]
```

* If `mid` is good, the first bad version lies in:

```
[mid + 1 ... end]
```

The search interval always contains the first bad version.

Eventually, the interval shrinks to exactly one version.

That remaining version is guaranteed to be the first bad version.

---

# Time Complexity

* Binary Search halves the search space every iteration.

```
O(log n)
```

---

# Space Complexity

Only a few integer variables are used.

```
O(1)
```

---

# Key Takeaways

* This problem is a classic **Binary Search on the answer**.
* The versions satisfy a monotonic property:

  * Good → Good → Good → Bad → Bad → Bad
* Use `while(start < end)` because we are searching for the leftmost valid answer.
* Use `end = mid` because `mid` may itself be the first bad version.
* Use `start = mid + 1` because a good version can never be the answer.
* Calculate the middle index using:

```
start + (end - start) / 2
```

to avoid integer overflow.
