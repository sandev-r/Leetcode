# LeetCode 1679 - Max Number of K-Sum Pairs

## 🟢 Difficulty

Medium

---

# 📝 Problem Statement

Given an integer array `nums` and an integer `k`, find the **maximum number of operations** you can perform.

In one operation, you must:

* Choose two numbers from `nums`.
* Their sum must be exactly `k`.
* Remove both numbers from the array.

Return the maximum number of such operations.

### Example

```text
Input:
nums = [1, 2, 3, 4]
k = 5

Output:
2
```

The valid pairs are:

```text
1 + 4 = 5
2 + 3 = 5
```

So we can perform **2 operations**.

---

# 💡 Intuition

For every number, we need to find its **complement**.

If the current number is:

```text
current = 3
k = 8
```

Then the required number is:

```text
needed = k - current
needed = 8 - 3
needed = 5
```

So, whenever we encounter `3`, we want to know:

> "Have I already seen a `5` that has not been used?"

A `HashMap` is perfect for this because it stores the frequency of numbers we have already seen.

### Two possible situations

**1. The needed number exists**

```text
current = 3
needed = 5

Map contains 5
```

We can form a pair:

```text
3 + 5 = k
```

So:

* Increase the operation count.
* Decrease the frequency of `5`.
* Remove `5` from the map if its frequency becomes `0`.

**2. The needed number does not exist**

We cannot form a pair yet.

So we store the current number in the map:

```text
map[current]++
```

This allows a future number to pair with it.

---

# 🚀 Approach

### 1. Create a frequency map

Maintain a `HashMap` containing numbers that have appeared but have **not yet been used in a pair**.

```text
Map<Integer, Integer>
```

The value represents how many unused occurrences of that number are available.

---

### 2. Traverse the array

Process every number from left to right.

For each number:

```text
current = nums[i]
```

---

### 3. Calculate the required complement

The pair must sum to `k`.

Therefore:

```text
current + needed = k
```

So:

```text
needed = k - current
```

---

### 4. Check whether the complement exists

If the map contains `needed`, we can immediately create a valid pair.

For example:

```text
k = 10
current = 6

needed = 10 - 6
needed = 4
```

If `4` exists in the map:

```text
4 + 6 = 10
```

We found one operation.

---

### 5. Consume the complement

Once a number is used in a pair, it cannot be reused.

Therefore, decrease its frequency:

```text
frequency(needed)--
```

If the frequency becomes `0`, remove it from the map.

This is important because the map represents **only unused numbers**.

---

### 6. Otherwise, store the current number

If the required complement does not exist yet:

```text
map[current]++
```

We keep the current number available for a future element.

---

### 7. Return the operation count

Every time a valid pair is found:

```text
operation++
```

After processing the entire array, `operation` is the maximum number of valid pairs.

---

# 🧠 Dry Run

### Example

```text
nums = [1, 2, 3, 4]
k = 5
```

Initial state:

```text
Map = {}
Operations = 0
```

| Current | Needed | Map Before   | Action                | Map After    | Operations |
| ------: | -----: | ------------ | --------------------- | ------------ | ---------: |
|       1 |      4 | `{}`         | 4 not found → store 1 | `{1=1}`      |          0 |
|       2 |      3 | `{1=1}`      | 3 not found → store 2 | `{1=1, 2=1}` |          0 |
|       3 |      2 | `{1=1, 2=1}` | 2 found → pair `3+2`  | `{1=1}`      |          1 |
|       4 |      1 | `{1=1}`      | 1 found → pair `4+1`  | `{}`         |          2 |

### Final Result

```text
Operations = 2
```

The two pairs are:

```text
2 + 3 = 5
1 + 4 = 5
```

Therefore:

```text
Output = 2
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the array once.

HashMap operations such as:

* `containsKey()`
* `get()`
* `put()`
* `remove()`

take **O(1)** average time.

Therefore:

```text
O(n)
```

---

### Space Complexity

```text
O(n)
```

In the worst case, the map can contain almost every element if no valid pairs are found.

Therefore:

```text
O(n)
```

---

# 🎯 Key Takeaways

* The main idea is **complement searching**: `needed = k - current`.
* A `HashMap` lets us efficiently track unused numbers.
* Store a number only when its complement is not currently available.
* When a complement is found, immediately consume it because each element can be used only once.
* Frequency counting is necessary because duplicate values can form multiple pairs.
* This approach avoids sorting and solves the problem in **O(n)** average time.

### 💼 Interview Tip

When you see:

> "Find pairs whose sum equals a target"

immediately think:

```text
needed = target - current
```

Then ask yourself whether you should use:

```text
HashMap → O(n) average
```

or

```text
Sorting + Two Pointers → O(n log n)
```

For this problem, the `HashMap` approach gives a linear-time solution.
