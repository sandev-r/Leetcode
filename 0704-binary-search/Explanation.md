# 704. Binary Search

**Difficulty:** Easy
**Topic:** Array, Binary Search

---

# Explanation

The given array is **sorted in ascending order**, which allows us to use **Binary Search** instead of checking every element one by one.

Binary Search repeatedly divides the search space into two halves until the target is found or no elements remain.

Instead of searching every element sequentially, we compare the target with the middle element.

* If the middle element is the target, return its index.
* If the target is greater than the middle element, search the right half.
* If the target is smaller than the middle element, search the left half.
* Continue until the search space becomes empty.

This approach reduces the number of comparisons significantly.

---

# Intuition

Think of searching for a word in a dictionary.

You don't start from the first page.

Instead:

1. Open the middle page.
2. Compare the word.
3. If your word comes after it, move to the right half.
4. Otherwise, move to the left half.
5. Repeat until the word is found.

Binary Search follows exactly the same idea.

---

# Algorithm

1. Initialize two pointers:

   * `start = 0`
   * `end = nums.length - 1`
2. While `start <= end`:

   * Find the middle index.
   * If the middle element equals the target, return the index.
   * If the middle element is smaller than the target:

     * Search the right half by moving `start`.
   * Otherwise:

     * Search the left half by moving `end`.
3. If the loop finishes, the target does not exist.
4. Return `-1`.

---

# Dry Run

### Input

```text
nums = [-1, 0, 3, 5, 9, 12]
target = 9
```

### Initial State

```text
start = 0
end = 5
```

---

### Iteration 1

```text
mid = 0 + (5 - 0) / 2
    = 2

nums[mid] = 3
```

```text
3 < 9

Search Right Half

start = mid + 1 = 3
end = 5
```

Remaining Search Space

```text
[5, 9, 12]
```

---

### Iteration 2

```text
start = 3
end = 5

mid = 3 + (5 - 3) / 2
    = 4

nums[mid] = 9
```

```text
nums[mid] == target
```

Return

```text
4
```

---

# Why use

* Much faster than Linear Search for sorted arrays.
* Eliminates half of the remaining elements after every comparison.
* Ideal when the data is already sorted.

---

# Time Complexity

| Operation    | Complexity   |
| ------------ | ------------ |
| Best Case    | **O(1)**     |
| Average Case | **O(log n)** |
| Worst Case   | **O(log n)** |

---

# Space Complexity

| Type                    | Complexity |
| ----------------------- | ---------- |
| Iterative Binary Search | **O(1)**   |

---

# Key Takeaways

* Works **only on sorted data**.
* Divide the search space into two halves after every comparison.
* Use `start + (end - start) / 2` instead of `(start + end) / ` to avoid integer overflow.
* If the target is found, return its index immediately.
* If `start` becomes greater than `end`, the target is not present, so return `-1`.
