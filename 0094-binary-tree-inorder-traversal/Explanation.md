# LeetCode 94 - Binary Tree Inorder Traversal

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

Given the root of a binary tree, return the **inorder traversal** of its nodes' values.

In an **inorder traversal**, we visit every node in this order:

**Left → Root → Right**

### Example

```text
Input:

        1
         \
          2
         /
        3

Output:
[1, 3, 2]
```

The traversal happens as:

```text
1 → Left
3 → Root
2 → Right
```

So the result is:

```text
[1, 3, 2]
```

---

# 💡 Intuition

The most important thing to understand is the **inorder traversal pattern**:

```text
        Root
       /    \
    Left    Right
```

We must always process:

```text
1. Left subtree
2. Current node
3. Right subtree
```

For every node, we repeat the same process.

For example:

```text
        1
       / \
      2   3
     / \
    4   5
```

Start at `1`.

We cannot add `1` immediately because inorder means **Left → Root → Right**.

So we first go to the left subtree:

```text
        2
       / \
      4   5
```

For `2`, we again go left:

```text
4
```

Node `4` has no left child, so we visit `4`.

Then we return to `2` and visit `2`.

Then we visit `5`.

Finally, we return to `1` and visit `1`.

Then we process the right subtree and visit `3`.

The final order is:

```text
[4, 2, 5, 1, 3]
```

The key idea is that **recursion naturally follows the tree structure**.

---

# 🚀 Approach

We use **recursive DFS traversal**.

### Step 1: Create the result list

Create an empty list to store the nodes in inorder.

```text
result = []
```

### Step 2: Start traversal from the root

Call the inorder traversal function with the root node.

### Step 3: Handle the base case

If the current node is `null`, there is nothing to visit.

Simply return.

```text
null → return
```

### Step 4: Traverse the left subtree

Recursively process the current node's left child.

```text
Left
```

This ensures every node in the left subtree appears before the current node.

### Step 5: Visit the current node

After completely processing the left subtree, add the current node's value to the result.

```text
Root
```

### Step 6: Traverse the right subtree

Finally, recursively process the right child.

```text
Right
```

Therefore, every node follows:

```text
        Current Node
        /          \
     Left         Right

      ↓             ↓
   process       process

        Left → Root → Right
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

### Traversal sequence

| Step | Current Node | Action                   | Result            |
| ---: | -----------: | ------------------------ | ----------------- |
|    1 |            1 | Go to left subtree       | `[]`              |
|    2 |            2 | Go to left subtree       | `[]`              |
|    3 |            4 | No left child, visit `4` | `[4]`             |
|    4 |            2 | Visit `2`                | `[4, 2]`          |
|    5 |            5 | Visit `5`                | `[4, 2, 5]`       |
|    6 |            1 | Visit `1`                | `[4, 2, 5, 1]`    |
|    7 |            3 | Visit `3`                | `[4, 2, 5, 1, 3]` |

Final result:

```text
[4, 2, 5, 1, 3]
```

### Recursion flow

```text
inorder(1)
│
├── inorder(2)
│   │
│   ├── inorder(4)
│   │   ├── left → null
│   │   ├── visit 4
│   │   └── right → null
│   │
│   ├── visit 2
│   │
│   └── inorder(5)
│       ├── left → null
│       ├── visit 5
│       └── right → null
│
├── visit 1
│
└── inorder(3)
    ├── left → null
    ├── visit 3
    └── right → null
```

So:

```text
4 → 2 → 5 → 1 → 3
```

---

# ✅ Correctness

The algorithm is correct because it follows the exact definition of **inorder traversal**.

For every node:

1. It completely traverses the **left subtree**.
2. It then visits the **current node**.
3. It completely traverses the **right subtree**.

The same process is recursively applied to every subtree.

Therefore, every node is added to the result in the required order:

```text
Left → Root → Right
```

Each node is visited exactly once, so the resulting list is the correct inorder traversal of the binary tree.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Where `n` is the number of nodes in the binary tree.

Every node is visited exactly once.

```text
n nodes
↓
each node processed once
↓
O(n)
```

### Space Complexity

**O(h)** for the recursion stack, where `h` is the height of the tree.

For a balanced tree:

```text
O(log n)
```

For a completely skewed tree:

```text
O(n)
```

The result list itself requires **O(n)** space because it stores every node's value.

---

# 🎯 Key Takeaways

* **Inorder traversal = Left → Root → Right**
* Recursion fits tree traversal naturally because every subtree is itself a smaller binary tree.
* Always identify the **base case** first: `null → return`.
* The order of the three operations determines the traversal type:

  * **Preorder:** Root → Left → Right
  * **Inorder:** Left → Root → Right
  * **Postorder:** Left → Right → Root
* For a **Binary Search Tree (BST)**, inorder traversal produces values in **sorted ascending order**.
* This problem is a fundamental DFS/tree-recursion problem and is worth mastering before moving to iterative tree traversals.
