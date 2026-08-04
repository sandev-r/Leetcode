# 83. Remove Duplicates from Sorted List

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

Given the head of a **sorted linked list**, delete all duplicate nodes so that each unique value appears only once. Return the modified linked list.

---

# 💡 Intuition

Since the linked list is **already sorted**, duplicate values will always be placed **next to each other**.

Instead of creating a new linked list or using an extra data structure, we can simply compare each node with its next node.

* If both nodes have the same value, remove the duplicate node.
* Otherwise, move to the next node.

Because duplicates are consecutive, a single traversal is sufficient.

---

# 🚀 Approach

### Step 1

Create a pointer named `current` and initialize it with the head of the linked list.

### Step 2

Traverse the linked list while both `current` and `current.next` are not `null`.

### Step 3

Compare the value of the current node with the next node.

* If both values are equal:

  * Remove the duplicate by connecting the current node directly to the node after the duplicate.
  * Do **not** move the current pointer because there may be more duplicates.

* Otherwise:

  * Move the current pointer to the next node.

### Step 4

Continue this process until the end of the linked list.

### Step 5

Return the original head of the linked list.

---

# 🔍 Dry Run

### Input

```text
1 → 1 → 2 → 3 → 3
```

| Step | Current Node | Next Node | Action                             | Linked List   |
| ---- | ------------ | --------- | ---------------------------------- | ------------- |
| 1    | 1            | 1         | Duplicate found → Remove next node | 1 → 2 → 3 → 3 |
| 2    | 1            | 2         | Different → Move current           | 1 → 2 → 3 → 3 |
| 3    | 2            | 3         | Different → Move current           | 1 → 2 → 3 → 3 |
| 4    | 3            | 3         | Duplicate found → Remove next node | 1 → 2 → 3     |

### Final Output

```text
1 → 2 → 3
```

---

# ✅ Correctness

The algorithm correctly removes duplicate nodes because:

* The linked list is sorted, so duplicate values always appear consecutively.
* Every node is compared only with its immediate next node.
* Whenever two adjacent nodes have the same value, the duplicate node is removed by updating the pointer.
* The current pointer is not moved after deletion, ensuring that multiple consecutive duplicates are also removed.
* After the traversal finishes, every unique value appears exactly once in the linked list.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

* Each node is visited at most once during the traversal.

### Space Complexity

**O(1)**

* No extra data structures are used.
* The linked list is modified in place.

---

# 🎯 Key Takeaways

* The sorted property of the linked list makes duplicate removal simple.
* Compare each node only with its next node.
* Remove duplicates by updating pointers instead of creating a new linked list.
* Do not move the current pointer immediately after deleting a duplicate.
* This is an **in-place** solution with **O(n)** time and **O(1)** space complexity.
