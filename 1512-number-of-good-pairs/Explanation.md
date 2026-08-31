# LeetCode 1512 - Number of Good Pairs

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

Given an integer array `nums`, find the number of **good pairs**.

A pair `(i, j)` is considered good when:

* `nums[i] == nums[j]`
* `i < j`

In simple terms, we need to count how many pairs of equal numbers exist in the array.

---

# 💡 Intuition

The main thing to notice is that every time we encounter a number, it can form a good pair with all its previous occurrences.

For example:

```text
nums = [1, 2, 3, 1, 1, 3]
```

When we encounter the second `1`, there is already one `1` before it, so we get:

```text
1 new pair
```

When we encounter the third `1`, there are already two `1`s before it, so we get:

```text
2 new pairs
```

So instead of checking every possible pair using nested loops, we can keep track of how many times each number has appeared.

---

# 🚀 Approach

1. Create a frequency array to store how many times each number has appeared.

2. Traverse through the `nums` array.

3. For each number:

   * The number of previous occurrences represents how many new good pairs can be formed.
   * Add its current frequency to the answer.

4. Increment the frequency of the current number.

5. After processing all elements, return the total number of good pairs.

---

# 🧠 Dry Run

Example:

Input

```text
nums = [1, 2, 3, 1, 1, 3]
```

Execution

```text
Initial:
count = 0
frequency = {}
```

### Iteration 1

```text
num = 1

Previous occurrences of 1 = 0

New pairs = 0

count = 0

frequency[1] = 1
```

### Iteration 2

```text
num = 2

Previous occurrences of 2 = 0

New pairs = 0

count = 0

frequency[2] = 1
```

### Iteration 3

```text
num = 3

Previous occurrences of 3 = 0

New pairs = 0

count = 0

frequency[3] = 1
```

### Iteration 4

```text
num = 1

Previous occurrences of 1 = 1

New pairs = 1

count = 1

frequency[1] = 2
```

### Iteration 5

```text
num = 1

Previous occurrences of 1 = 2

New pairs = 2

count = 3

frequency[1] = 3
```

### Iteration 6

```text
num = 3

Previous occurrences of 3 = 1

New pairs = 1

count = 4

frequency[3] = 2
```

Final Output

```text
4
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse through the array only once.

### Space Complexity

```text
O(n)
```

In the worst case, we may store the frequency of every unique element.

---

# 🎯 Key Takeaways

* A frequency array can help avoid checking every possible pair.
* Each previous occurrence of the current number creates one new good pair.
* Instead of using nested loops with `O(n²)` time complexity, we can solve it in `O(n)`.
* Interview tip: When a problem asks you to count pairs involving equal elements, think about using frequencies.
