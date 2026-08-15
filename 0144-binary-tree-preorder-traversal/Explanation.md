# LeetCode 144 - Binary Tree Preorder Traversal

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

Given the root of a binary tree, return the **preorder traversal** of its nodes' values.

In **preorder traversal**, we visit nodes in this order:

```text
Root → Left → Right
```

### Example

**Input:**

```text
    1
     \
      2
     /
    3
```

**Output:**

```text
[1, 2, 3]
```

The traversal starts from the root `1`, then visits the left subtree, and finally the right subtree.

---

# 💡 Intuition

The main idea is to follow the definition of **preorder traversal** directly.

For every node:

1. Visit the current node.
2. Traverse its left subtree.
3. Traverse its right subtree.

The important observation is that **each subtree is itself a binary tree**.

So, when we reach a node, we can apply the same three steps recursively:

```text
            Node
           /    \
       Left      Right
        ↓          ↓
      Visit      Visit
```

If the node is `null`, there is nothing to visit, so we simply stop that recursive call.

This makes recursion a natural solution for tree traversal.

---

# 🚀 Approach

### Step 1: Create a result list

Create an empty list to store the preorder traversal.

```text
result = []
```

### Step 2: Start traversal from the root

Call the preorder traversal function with the root node.

### Step 3: Handle the base case

If the current node is `null`, return immediately.

```text
null → stop
```

This prevents us from trying to access a nonexistent node.

### Step 4: Visit the current node

Add the current node's value to the result list.

```text
Root
 ↓
Add value
```

### Step 5: Traverse the left subtree

Recursively perform preorder traversal on the left child.

```text
Left subtree
     ↓
Root → Left → Right
```

### Step 6: Traverse the right subtree

After completely processing the left subtree, recursively process the right subtree.

```text
Right subtree
      ↓
Root → Left → Right
```

### Overall Flow

```text
Preorder(node)

        ↓
   Is node null?
      /      \
    Yes       No
     ↓         ↓
   Return   Add node
               ↓
        Traverse left
               ↓
        Traverse right
```

The traversal continues until every node has been visited exactly once.

---

# 🧠 Dry Run

Consider this binary tree:

```text
        1
       / \
      2   3
     / \
    4   5
```

Preorder means:

```text
Root → Left → Right
```

### Step-by-step

| Step | Current Node | Action    | Result            |
| ---: | -----------: | --------- | ----------------- |
|    1 |            1 | Visit `1` | `[1]`             |
|    2 |            2 | Visit `2` | `[1, 2]`          |
|    3 |            4 | Visit `4` | `[1, 2, 4]`       |
|    4 |         null | Return    | `[1, 2, 4]`       |
|    5 |         null | Return    | `[1, 2, 4]`       |
|    6 |            5 | Visit `5` | `[1, 2, 4, 5]`    |
|    7 |         null | Return    | `[1, 2, 4, 5]`    |
|    8 |         null | Return    | `[1, 2, 4, 5]`    |
|    9 |            3 | Visit `3` | `[1, 2, 4, 5, 3]` |

### Final Result

```text
[1, 2, 4, 5, 3]
```

### Traversal Visualization

```text
        1
       / \
      2   3
     / \
    4   5

    ↓

1 → 2 → 4 → 5 → 3
```

Notice that a node is added to the result **before** its left and right subtrees are processed. That is exactly what makes this **preorder** traversal.

---

# ✅ Correctness

The algorithm correctly produces the preorder traversal because it follows the required order for every node.

For each non-null node:

1. Its value is added to the result first.
2. Its entire left subtree is traversed next.
3. Its entire right subtree is traversed last.

The base case stops traversal when a `null` child is reached.

Because the same process is recursively applied to every subtree, every node is visited **exactly once** and in the required:

```text
Root → Left → Right
```

order.

Therefore, the resulting list is the correct preorder traversal of the binary tree.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Where `n` is the number of nodes in the binary tree.

Every node is visited exactly once.

```text
n nodes → n visits → O(n)
```

### Space Complexity

**O(h)**

Where `h` is the height of the tree.

The recursive calls use the call stack.

* Balanced tree: `O(log n)`
* Completely skewed tree: `O(n)`

The result list itself requires **O(n)** space to store the traversal.

---

# 🎯 Key Takeaways

* **Preorder traversal = Root → Left → Right.**
* Recursion is a natural fit because every subtree is itself a binary tree.
* Always define the **base case** when working with recursive tree problems.
* The current node must be processed **before** its left and right children.
* For `n` nodes, traversal takes **O(n)** time.
* Recursive stack space is **O(h)**, where `h` is the tree height.
* **Interview Tip:** When you see a binary tree traversal question, immediately identify the required order:

  * **Preorder:** Root → Left → Right
  * **Inorder:** Left → Root → Right
  * **Postorder:** Left → Right → Root

---
