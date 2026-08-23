# LeetCode 2236 — Root Equals Sum of Children

**Difficulty:** Easy

## Problem Statement

Given the root of a binary tree with exactly three nodes:

* The root node
* The root's left child
* The root's right child

Return `true` if the value of the root is equal to the sum of the values of its two children. Otherwise, return `false`.

In other words:

```text
root.val = root.left.val + root.right.val
```

## Intuition

The problem is extremely straightforward because the tree is guaranteed to contain exactly three nodes.

We only need to compare:

```text
       root
      /    \
   left    right
```

with:

```text
root.val == left.val + right.val
```

If the equation is true, return `true`. Otherwise, return `false`.

There is no need for recursion, traversal, or any other tree algorithm.

## Approach

1. Access the value of the root node using `root.val`.
2. Access the left child's value using `root.left.val`.
3. Access the right child's value using `root.right.val`.
4. Add the two child values.
5. Compare the sum with the root value.
6. Return the result of the comparison.

The comparison itself produces a boolean value, so no additional `if-else` statement is required.

## Complexity

* **Time Complexity:** `O(1)`
* **Space Complexity:** `O(1)`

Only three node values are accessed, regardless of the input values.

## Key Takeaway

This problem tests whether you can recognize when a binary tree problem **does not require traversal**.

Because the tree contains exactly three nodes, directly check:

```text
root.val == root.left.val + root.right.val
```

The important lesson is: **don't use a complicated tree algorithm when the problem can be solved with a direct relationship between nodes.**
