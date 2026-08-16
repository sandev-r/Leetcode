# LeetCode 104 - Maximum Depth of Binary Tree

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

Given the root of a binary tree, return the **maximum depth** of the binary tree.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

### Example

```text
        3
       / \
      9   20
         /  \
        15   7
```

The longest path is:

```text
3 → 20 → 15
```

or

```text
3 → 20 → 7
```

Therefore, the maximum depth is:

```text
3
```

---

# 💡 Intuition

For every node, we need to know the depth of its **left subtree** and **right subtree**.

The maximum depth of the current node is:

```text
1 + max(left subtree depth, right subtree depth)
```

Why `+1`?

Because the current node itself contributes one level.

For a `null` node, there is no node, so its depth is:

```text
0
```

This naturally leads to a **recursive solution**.

---

# 🚀 Approach

We use **Depth-First Search (DFS)** with recursion.

### Step 1: Check for an empty node

If the current node is `null`, return:

```text
0
```

This is the **base case** that stops the recursion.

---

### Step 2: Find the depth of the left subtree

Recursively calculate:

```text
leftDepth = depth(node.left)
```

This gives the maximum depth of the left subtree.

---

### Step 3: Find the depth of the right subtree

Recursively calculate:

```text
rightDepth = depth(node.right)
```

This gives the maximum depth of the right subtree.

---

### Step 4: Choose the deeper subtree

Take the maximum of the two subtree depths:

```text
max(leftDepth, rightDepth)
```

---

### Step 5: Include the current node

Add `1` for the current node:

```text
1 + max(leftDepth, rightDepth)
```

So the recurrence is:

```text
depth(node) = 1 + max(depth(node.left), depth(node.right))
```

---

# 🧠 Dry Run

Consider this tree:

```text
        3
       / \
      9   20
         /  \
        15   7
```

### Start at `3`

```text
maxDepth(3)
```

We need both subtrees:

```text
left  = maxDepth(9)
right = maxDepth(20)
```

---

### Process node `9`

```text
    9
   / \
null null
```

Both children are `null`.

```text
maxDepth(null) = 0
maxDepth(null) = 0
```

Therefore:

```text
1 + max(0, 0)
= 1
```

So:

```text
depth(9) = 1
```

---

### Process node `20`

```text
        20
       /  \
      15   7
```

For node `15`:

```text
depth(15) = 1
```

For node `7`:

```text
depth(7) = 1
```

Therefore:

```text
depth(20)
= 1 + max(1, 1)
= 2
```

---

### Return to node `3`

We now have:

```text
leftDepth  = 1
rightDepth = 2
```

Therefore:

```text
depth(3)
= 1 + max(1, 2)
= 3
```

Final answer:

```text
3
```

### Recursion Flow

```text
                 3
               /   \
              9     20
                   /  \
                  15   7

              ↓ recursion

        depth(3)
        ├── depth(9)  → 1
        │
        └── depth(20)
            ├── depth(15) → 1
            └── depth(7)  → 1
            
            depth(20) → 2

        depth(3) → 3
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

Every node in the binary tree is visited exactly once.

Where `n` is the number of nodes in the tree.

---

### Space Complexity

```text
O(h)
```

The recursion call stack can contain at most `h` nodes at a time, where `h` is the height of the tree.

* **Balanced tree:** `O(log n)`
* **Skewed tree:** `O(n)`

---

# 🎯 Key Takeaways

* Maximum depth means the **longest root-to-leaf path** measured in number of nodes.
* Use **DFS recursion** to explore both subtrees.
* `null` node → depth `0`.
* Current node → `1 + max(leftDepth, rightDepth)`.
* The core recurrence is:

```text
depth(node) = 1 + max(depth(left), depth(right))
```

* This is a fundamental **binary tree recursion pattern** that appears in many tree problems.
