# LeetCode 700 — Search in a Binary Search Tree

**Difficulty:** Easy

## Problem Statement

Given the root of a Binary Search Tree (BST) and an integer `val`, find the node in the BST whose value is equal to `val`.

If the node exists, return the subtree rooted at that node. If the value does not exist, return `null`.

A **Binary Search Tree** follows this property:

* Values in the left subtree are **smaller** than the current node.
* Values in the right subtree are **greater** than the current node.

---

## Intuition

The key is to use the **BST property** instead of searching every node.

At each node:

```text
              8
             / \
            4   10
           / \    \
          2   6    12
```

Suppose we are searching for `6`.

Start at `8`:

```text
6 < 8
↓
Go LEFT
```

At `4`:

```text
6 > 4
↓
Go RIGHT
```

At `6`:

```text
6 == 6
↓
Found
```

So we never need to visit nodes that cannot contain the target.

---

## Approach

We use **recursion**.

### Step 1 — Check the base cases

If:

```text
root == null
```

the value does not exist, so return `null`.

If:

```text
root.val == val
```

we found the required node, so return `root`.

### Step 2 — Search the left subtree

If:

```text
val < root.val
```

the target must be somewhere in the left subtree.

```text
return searchBST(root.left, val);
```

### Step 3 — Search the right subtree

Otherwise:

```text
val > root.val
```

the target must be somewhere in the right subtree.

```text
return searchBST(root.right, val);
```

### Flow

```text
              root
                │
        ┌───────┴────────┐
        │                │
   root == null      root.val == val
        │                │
      return           return root
       null
        │
        ▼
   val < root.val?
      /       \
    YES        NO
     │          │
   LEFT       RIGHT
     │          │
     ▼          ▼
 searchBST   searchBST
 (root.left) (root.right)
```

---

## Complexity

### Time Complexity

**Average case:** `O(log n)`

For a balanced BST, each comparison eliminates roughly half of the remaining tree.

**Worst case:** `O(n)`

If the BST is completely skewed:

```text
1
 \
  2
   \
    3
     \
      4
       \
        5
```

we may need to visit every node.

### Space Complexity

**Average case:** `O(log n)`

**Worst case:** `O(n)`

The recursive calls use the call stack, whose depth depends on the height of the tree.

---

## Key Takeaway

The important idea is **not recursion itself**. The important idea is exploiting the **Binary Search Tree property**.

```text
target < current → LEFT
target > current → RIGHT
target == current → FOUND
```

Because each comparison tells us exactly which subtree can contain the answer, we avoid unnecessary traversal.

**Pattern to remember:**

> In a BST, compare the target with the current node and eliminate one entire subtree at every step.
