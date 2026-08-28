# 872. Leaf-Similar Trees

## Difficulty

Easy

## Problem Statement

Given the roots of two binary trees, `root1` and `root2`, determine whether the two trees are **leaf-similar**.

Two binary trees are leaf-similar if the sequence of leaf node values, read from **left to right**, is the same in both trees.

A **leaf node** is a node that has no left child and no right child.

For example, if the leaves of the first tree are:

`6 → 7 → 4 → 9 → 8`

and the leaves of the second tree are:

`6 → 7 → 4 → 9 → 8`

then the trees are leaf-similar.

## Intuition

The actual structure of the two trees does not matter.

We only care about the values of their **leaf nodes in left-to-right order**.

So, for each tree:

1. Traverse the tree.
2. Whenever a node has no left and right child, it is a leaf.
3. Store that leaf's value.
4. Continue traversing from left to right.

After doing this for both trees, compare the two lists.

If the lists are equal, the trees are leaf-similar. Otherwise, they are not.

The recursive traversal naturally gives us the required left-to-right order because we visit the left subtree before the right subtree.

## Approach

Use **Depth-First Search (DFS)** to collect the leaf values of each tree.

### Step 1: Create two lists

Create one list for the leaves of `root1` and another for the leaves of `root2`.

### Step 2: Traverse the first tree

Recursively traverse `root1`.

* If the current node is `null`, return.
* If both `left` and `right` are `null`, the node is a leaf, so add its value to the list.
* Otherwise, recursively traverse the left subtree.
* Then recursively traverse the right subtree.

### Step 3: Traverse the second tree

Perform the same DFS traversal for `root2` and store its leaf values in the second list.

### Step 4: Compare the leaf sequences

Compare the two lists.

If both contain exactly the same values in the same order, return `true`.

Otherwise, return `false`.

The important point is that we are **not comparing the trees themselves**. Two completely different tree structures can still be leaf-similar as long as their leaf sequences match.

## Complexity

Let `n` be the number of nodes in the first tree and `m` be the number of nodes in the second tree.

* **Time Complexity:** `O(n + m)`

  * Every node in both trees is visited once.

* **Space Complexity:** `O(n + m)`

  * The lists store the leaf values.
  * The recursive call stack also requires space proportional to the tree height.

## Key Takeaway

For problems involving **leaf similarity**, ignore the internal structure of the trees.

The key is to extract the **leaf sequence from left to right** using DFS and compare the resulting sequences.

**Pattern to remember:**

`Tree → DFS → Collect Leaves → Compare Sequences`
