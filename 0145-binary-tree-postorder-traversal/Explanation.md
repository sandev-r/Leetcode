# 🔍 LeetCode 145 — Binary Tree Postorder Traversal

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

Given the root of a binary tree, return the values of its nodes in **postorder traversal**.

In **postorder traversal**, we visit every node in this order:

**Left → Right → Root**

### Example

For the binary tree:

```text
        1
         \
          2
         /
        3
```

The postorder traversal is:

```text
[3, 2, 1]
```

---

# 💡 Intuition

The main idea is to understand what **postorder** means.

For every node:

1. First, process its **left subtree**.
2. Then, process its **right subtree**.
3. Finally, process the **current node**.

The important part is that the node's value is added to the result **only after both subtrees have been completely processed**.

This naturally matches **recursion** because each subtree is itself a smaller binary tree.

---

# 🚀 Approach

We use a recursive helper function to traverse the tree.

### Step 1 — Start from the root

Begin the traversal with the root node.

### Step 2 — Handle the base case

If the current node is `null`, there is nothing to process.

Simply return.

### Step 3 — Traverse the left subtree

Recursively visit the current node's left child.

This ensures that all nodes in the left subtree are added first.

### Step 4 — Traverse the right subtree

After the left subtree is completed, recursively visit the right child.

This ensures that all nodes in the right subtree are added next.

### Step 5 — Add the current node

Only after both subtrees are processed, add the current node's value to the result.

Therefore, the traversal follows:

```text
Left → Right → Root
```

---

# 🧠 Dry Run

Consider this tree:

```text
        1
       / \
      2   3
     / \
    4   5
```

### Traversal process

| Step | Current Node | Action                       | Result            |
| ---: | -----------: | ---------------------------- | ----------------- |
|    1 |            1 | Go to left subtree           | `[]`              |
|    2 |            2 | Go to left subtree           | `[]`              |
|    3 |            4 | No left/right child, add `4` | `[4]`             |
|    4 |            2 | Go to right subtree          | `[4]`             |
|    5 |            5 | No left/right child, add `5` | `[4, 5]`          |
|    6 |            2 | Left & right done, add `2`   | `[4, 5, 2]`       |
|    7 |            1 | Go to right subtree          | `[4, 5, 2]`       |
|    8 |            3 | No left/right child, add `3` | `[4, 5, 2, 3]`    |
|    9 |            1 | Left & right done, add `1`   | `[4, 5, 2, 3, 1]` |

### Final Result

```text
[4, 5, 2, 3, 1]
```

The important observation is that **2 is added only after 4 and 5**, and **1 is added only after the entire left and right subtrees are finished**.

---

# ✅ Correctness

The algorithm is correct because every node is processed according to the definition of postorder traversal.

For each node:

* The recursive call on the left child processes the entire left subtree first.
* The recursive call on the right child processes the entire right subtree second.
* The current node is added only after both recursive calls finish.

Therefore, every node follows:

```text
Left → Right → Root
```

Since this is done recursively for every subtree, the complete tree is traversed in **postorder**.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Each node in the binary tree is visited exactly once.

Where `n` is the number of nodes in the tree.

```text
n nodes → each visited once → O(n)
```

### Space Complexity

**O(h)** for the recursion stack, where `h` is the height of the tree.

* Balanced tree → `O(log n)`
* Completely skewed tree → `O(n)`

The result list itself requires **O(n)** space to store the traversal values.

Therefore:

```text
Auxiliary Space: O(h)
Output Space:    O(n)
```

---

# 🎯 Key Takeaways

* **Postorder = Left → Right → Root**
* Recursion naturally fits tree traversal because every subtree is another smaller tree.
* The current node must be added **after** both recursive calls.
* The base case is `node == null`.
* A balanced tree uses `O(log n)` recursion stack space.
* A skewed tree can use `O(n)` recursion stack space.
* The overall traversal takes **O(n)** time because every node is visited exactly once.

---
