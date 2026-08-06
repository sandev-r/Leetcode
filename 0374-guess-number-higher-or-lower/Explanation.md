# 374. Guess Number Higher or Lower

## Problem Explanation

You are playing a guessing game where a number is secretly chosen between **1** and **n**.

You do **not** know the chosen number directly. Instead, you are given a predefined API:

* `guess(num)` returns:

  * `-1` → Your guess is **higher** than the picked number.
  * `1` → Your guess is **lower** than the picked number.
  * `0` → Your guess is **correct**.

Your task is to determine the picked number using the fewest possible guesses.

---

# Intuition

Since the numbers are sorted from **1 to n**, we do not need to check every number one by one.

Instead, after making a guess, the API immediately tells us whether the answer is:

* on the **left side**
* on the **right side**
* or exactly the current number.

This is exactly the situation where **Binary Search** is the most efficient algorithm.

At every step:

* Guess the middle number.
* If the guess is correct, return it.
* If the guess is too small, search the right half.
* If the guess is too large, search the left half.

Each guess eliminates **half of the remaining search space**, making the solution extremely efficient.

---

# Algorithm

1. Initialize:

   * `start = 1`
   * `end = n`

2. Repeat while `start <= end`:

   * Find the middle index:

     ```
     mid = start + (end - start) / 2
     ```

   * Call:

     ```
     pick = guess(mid)
     ```

   * If `pick == 0`

     * The correct number is found.
     * Return `mid`.

   * If `pick == 1`

     * The picked number is larger.
     * Move to the right half:

       ```
       start = mid + 1
       ```

   * Otherwise (`pick == -1`)

     * The picked number is smaller.
     * Move to the left half:

       ```
       end = mid - 1
       ```

3. If the loop finishes, return `-1`.
   (This case will never occur according to the problem constraints.)

---

# Dry Run

### Example

```
n = 10
Picked Number = 6
```

Initial:

```
start = 1
end = 10
```

### Iteration 1

```
mid = 5
guess(5) = 1
```

Meaning:

```
Picked number is greater than 5.
```

Move right.

```
start = 6
end = 10
```

---

### Iteration 2

```
mid = 8
guess(8) = -1
```

Meaning:

```
Picked number is smaller than 8.
```

Move left.

```
start = 6
end = 7
```

---

### Iteration 3

```
mid = 6
guess(6) = 0
```

Correct answer found.

Return:

```
6
```

---

# Why do we initialize `start = 1` instead of `0`?

The problem clearly states that the secret number is chosen **between `1` and `n`**, inclusive.

Therefore, the valid search space is:

```
1, 2, 3, ..., n
```

The value `0` is **not a possible answer**.

If we initialize:

```
start = 0
```

Binary Search may still eventually find the correct answer because `0` is simply outside the valid range. However, it unnecessarily expands the search space with an impossible value.

Following the problem constraints exactly is the correct approach:

```
start = 1
end = n
```

This keeps the algorithm searching only within valid candidates.

---

# Why use

```
mid = start + (end - start) / 2
```

instead of

```
(start + end) / 2
```

If `start` and `end` are very large, adding them together may exceed the maximum value an `int` can store, causing **integer overflow**.

The safer formula computes the distance first:

```
end - start
```

which always stays within range.

This makes the algorithm safe even for extremely large inputs.

---

# Time Complexity

* Each iteration removes half of the remaining search space.

```
Time Complexity: O(log n)
```

---

# Space Complexity

Only a few integer variables are used.

```
Space Complexity: O(1)
```

---

# Key Takeaways

* This is a classic **Binary Search** problem.
* The `guess()` API tells us which half to eliminate.
* Always search within the valid range **1 to n**.
* Use the overflow-safe midpoint formula.
* Binary Search reduces the search space by half every iteration, giving an **O(log n)** solution.
