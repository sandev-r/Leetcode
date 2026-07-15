# 26. Remove Duplicates from Sorted Array

## 📌 Problem
Given a sorted integer array `nums`, remove the duplicates **in-place** such that each unique element appears only once.

The relative order of the elements should be maintained.

Return the number of unique elements `k`, where the first `k` elements of `nums` contain the unique values.

---

## 💡 Intuition

Since the array is already sorted, duplicate values always appear next to each other.

Instead of creating another array, maintain:

- A **read pointer** to scan every element.
- A **write pointer** to track the position where the next unique element should be placed.

Whenever a new unique element is found, move it to the next available position.

---

## 🚀 Approach

1. Initialize `writePointer = 0`.
2. Traverse the array using `readPointer` from index `1`.
3. Compare the current element with the last unique element.
4. If they are different:
   - Move the unique element to the next position.
   - Increment `writePointer`.
5. Return `writePointer + 1`, which represents the number of unique elements.

---

## 🧠 Algorithm

1. Start with the first element as unique.
2. Scan the remaining elements.
3. Whenever a new value appears:
   - Increase the write pointer.
   - Copy the value.
4. Ignore duplicate values.
5. Return the total number of unique elements.

---

## 📊 Complexity Analysis

| Operation | Complexity |
|-----------|------------|
| Time | **O(n)** |
| Space | **O(1)** |

---

## 🔑 Key Concepts

- Array
- Two Pointers
- In-place Modification
- Sorted Array

---

## 🎯 What I Learned

- How the **Two Pointer** technique performs in-place array modification.
- Why sorted arrays allow duplicate detection using adjacent comparisons.
- How to optimize space by avoiding extra data structures.
- The difference between the **read pointer** (scanning) and **write pointer** (updating).

---

## 🏷️ Tags

`Array` `Two Pointers`

---


## ✍️ Author

Maintained by **Sandev** as part of the Java DSA & LeetCode Journey.
