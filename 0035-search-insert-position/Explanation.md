# 35. Search Insert Position

## Problem Statement

Given a **sorted array** of distinct integers `nums` and a target value `target`, return the **index** if the target is found.

If the target is **not present**, return the index where it **would be inserted** so that the array remains sorted.

---

## Intuition

Since the array is already **sorted**, we do not need to check every element one by one.

Instead, we can repeatedly divide the search space into two halves.

* If the middle element is equal to the target, we have found the answer.
* If the target is greater than the middle element, it must exist on the right half.
* If the target is smaller than the middle element, it must exist on the left half.

Eventually, the search range becomes empty.

At that moment, the `start` pointer represents the exact position where the target should be inserted while maintaining the sorted order.

---

## Algorithm

1. Initialize two pointers:

   * `start = 0`
   * `end = nums.length - 1`

2. Repeat while `start <= end`:

   * Calculate the middle index.
   * If the middle element equals the target, return its index.
   * If the target is greater than the middle element, move `start` to `mid + 1`.
   * Otherwise, move `end` to `mid - 1`.

3. If the loop ends, the target does not exist.

   * Return `start`, since it indicates the correct insertion position.

---

## Dry Run

### Example 1

**Input**

```
nums = [1,3,5,6]
target = 5
```

| start | end | mid | nums[mid] | Action                               |
| ----: | --: | --: | --------: | ------------------------------------ |
|     0 |   3 |   1 |         3 | Target is larger → Search right half |
|     2 |   3 |   2 |         5 | Target found → Return 2              |

**Output**

```
2
```

---

### Example 2

**Input**

```
nums = [1,3,5,6]
target = 2
```

| start | end | mid | nums[mid] | Action                               |
| ----: | --: | --: | --------: | ------------------------------------ |
|     0 |   3 |   1 |         3 | Target is smaller → Search left half |
|     0 |   0 |   0 |         1 | Target is larger → Search right half |

Loop ends:

```
start = 1
end = 0
```

Return:

```
1
```

The target should be inserted at index **1**.

---

### Example 3

**Input**

```
nums = [1,3,5,6]
target = 7
```

| start | end | mid | nums[mid] | Action            |
| ----: | --: | --: | --------: | ----------------- |
|     0 |   3 |   1 |         3 | Search right half |
|     2 |   3 |   2 |         5 | Search right half |
|     3 |   3 |   3 |         6 | Search right half |

Loop ends:

```
start = 4
end = 3
```

Return:

```
4
```

The target should be inserted at the end of the array.

---

## Why Returning `start` Works

When Binary Search finishes without finding the target:

* Every element before `start` is **smaller** than the target.
* Every element after `start` is **greater** than the target.

Therefore, `start` is exactly where the target should be inserted to keep the array sorted.

---

## Time Complexity

* **Best Case:** `O(1)` (Target found at the middle immediately)
* **Average Case:** `O(log n)`
* **Worst Case:** `O(log n)`

---

## Space Complexity

* **O(1)**

Only a few integer variables are used regardless of the input size.

---

## Key Takeaways

* The array must be **sorted**.
* Binary Search reduces the search space by half in every iteration.
* If the target exists, return its index.
* If the target does not exist, return `start`.
* `start` always represents the correct insertion position after the loop terminates.
