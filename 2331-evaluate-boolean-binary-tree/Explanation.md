# LeetCode 2331 — Evaluate Boolean Binary Tree

**Difficulty:** Easy

## Problem Statement

You are given the root of a binary tree where:

* `0` represents **False**
* `1` represents **True**
* `2` represents the **OR** operation
* `3` represents the **AND** operation

Leaf nodes contain either `0` or `1`, while non-leaf nodes contain either `2` or `3`.

Evaluate the entire boolean expression represented by the binary tree and return the result.

---

## Intuition

This tree is essentially a **Boolean expression tree**.

Each internal node tells us how to combine the results of its two children:

```text
        2 (OR)
       /      \
      1        0

     ↓

   true OR false

     ↓

    true
```

The key observation is:

* If the node is `0`, the result is `false`.
* If the node is `1`, the result is `true`.
* If the node is `2`, evaluate both children and apply `OR`.
* If the node is `3`, evaluate both children and apply `AND`.

Because each internal node depends on its children, **recursion** is a natural fit.

---

## Approach

Use a **recursive Depth-First Search (DFS)**.

### Step 1: Handle leaf nodes

If `root.val == 0`:

```text
return false
```

If `root.val == 1`:

```text
return true
```

These are the base cases of the recursion.

### Step 2: Evaluate both subtrees

For an internal node, recursively evaluate:

```text
left  = evaluateTree(root.left)
right = evaluateTree(root.right)
```

This gives us the Boolean result of each child subtree.

### Step 3: Apply the operation

If `root.val == 2`:

```text
left OR right
```

If `root.val == 3`:

```text
left AND right
```

### Example

Consider:

```text
        2 (OR)
       /      \
   3 (AND)     1
    /   \
   1     0
```

Evaluate from the bottom:

```text
1 AND 0
   ↓
false

false OR true
     ↓
   true
```

So the final result is:

```text
true
```

---

## Complexity

Let `n` be the number of nodes in the binary tree.

**Time Complexity:** `O(n)`

Each node is visited once.

**Space Complexity:** `O(h)`

Where `h` is the height of the tree, due to the recursive call stack.

* Balanced tree: `O(log n)`
* Skewed tree: `O(n)`

---

## Key Takeaway

This problem is a straightforward example of **recursion on a binary expression tree**.

The important pattern is:

```text
Leaf node
   ↓
Return its value

Internal node
   ↓
Evaluate left subtree
   ↓
Evaluate right subtree
   ↓
Apply the operation
```

Whenever a binary tree represents an expression where **internal nodes are operations and leaves are values**, think:

> **Recursively evaluate the children, then apply the current node's operation.**
