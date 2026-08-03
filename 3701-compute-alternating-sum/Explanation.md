# 3701. Compute Alternating Value

**Difficulty:** Easy

---

## Problem Statement

You are given an integer array `nums`.

The **alternating value** of the array is calculated by:

* Adding the elements at **even indices** (`0, 2, 4, ...`)
* Subtracting the elements at **odd indices** (`1, 3, 5, ...`)

Return the alternating value of the array.

---

## Intuition

The position (index) of each element determines whether it should be added or subtracted.

* **Even index** → Add the element.
* **Odd index** → Subtract the element.

Since every element is processed exactly once, a single loop is enough.

---

## Approach

1. Initialize a variable `alterSum` to `0`.
2. Traverse the array from index `0` to `n - 1`.
3. For each element:

   * If the index is even, add the element to `alterSum`.
   * Otherwise, subtract the element from `alterSum`.
4. Return `alterSum`.

---

## Dry Run

### Example

**Input**

```text
nums = [5, 2, 7, 1, 4]
```

| Index | Element | Operation | Alternating Sum |
| :---: | :-----: | :-------: | :-------------: |
|   0   |    5    |     +5    |        5        |
|   1   |    2    |     -2    |        3        |
|   2   |    7    |     +7    |        10       |
|   3   |    1    |     -1    |        9        |
|   4   |    4    |     +4    |        13       |

**Output**

```text
13
```

---

## Algorithm

1. Set `alterSum = 0`.
2. Iterate through every index of the array.
3. If the current index is even:

   * Add the current element to `alterSum`.
4. Otherwise:

   * Subtract the current element from `alterSum`.
5. Return `alterSum`.

---

## Correctness

The algorithm visits every element exactly once.

* Every element at an **even index** is added.
* Every element at an **odd index** is subtracted.

This exactly matches the definition of the alternating value. Therefore, the algorithm always produces the correct answer.

---

## Complexity Analysis

### Time Complexity

**O(n)**

* The array is traversed once.

### Space Complexity

**O(1)**

* Only one extra variable is used.

---

## Key Takeaways

* The operation depends on the **index**, not the value.
* Even indices contribute positively.
* Odd indices contribute negatively.
* The problem is solved efficiently using a single traversal with constant extra space.
