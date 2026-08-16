# LeetCode 100 - Same Tree

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

Given the roots of two binary trees `p` and `q`, determine whether the two trees are **identical**.

Two binary trees are considered the same when:

1. They have the **same structure**.
2. The corresponding nodes contain the **same values**.

Return `true` if both trees are the same; otherwise, return `false`.

---

# 💡 Intuition

To determine whether two trees are identical, we need to compare them **node by node**.

At every pair of corresponding nodes, there are only a few possibilities:

* Both nodes are `null` → they match.
* One node is `null` and the other is not → structures are different.
* Both nodes exist but their values are different → values are different.
* Both nodes exist with the same value → compare their left children and right children.

This naturally leads to a **recursive DFS approach**.

The important idea is:

> Two trees are the same only if their roots are the same **and** their left subtrees are the same **and** their right subtrees are the same.

---

# 🚀 Approach

We recursively compare the two trees.

### Step 1: Check if both nodes are `null`

If both current nodes are `null`, there is nothing left to compare.

Therefore, they are identical at this position.

**Return `true`.**

---

### Step 2: Check if only one node is `null`

If one node is `null` and the other exists, the tree structures are different.

**Return `false`.**

Example:

```text
Tree P:        Tree Q:

    1              1
   /                \
  2                  2
```

The corresponding left and right positions are different, so the trees cannot be the same.

---

### Step 3: Compare node values

If both nodes exist, compare their values.

If:

```text
p.val != q.val
```

then the trees are different.

**Return `false`.**

---

### Step 4: Compare the left subtrees

Recursively compare:

```text
p.left
q.left
```

If their left subtrees are different, the entire trees are different.

---

### Step 5: Compare the right subtrees

Recursively compare:

```text
p.right
q.right
```

---

### Step 6: Combine both results

The current pair of nodes is considered identical only when:

```text
Left subtree is same
        AND
Right subtree is same
```

Therefore:

```text
Same Tree
   │
   ├── Same Left Subtree
   │
   └── Same Right Subtree
```

Both conditions must be `true`.

---

# 🧠 Dry Run

Consider:

```text
Tree P:              Tree Q:

      1                   1
     / \                 / \
    2   3               2   3
```

### Comparison

| Step | `p`    | `q`    | Result                 |
| ---- | ------ | ------ | ---------------------- |
| 1    | `1`    | `1`    | Values same → continue |
| 2    | `2`    | `2`    | Values same → continue |
| 3    | `null` | `null` | Same → `true`          |
| 4    | `null` | `null` | Same → `true`          |
| 5    | `3`    | `3`    | Values same → continue |
| 6    | `null` | `null` | Same → `true`          |
| 7    | `null` | `null` | Same → `true`          |

Every corresponding node matches.

Therefore:

```text
true
```

---

### Example Where Trees Are Different

```text
Tree P:              Tree Q:

      1                   1
     /                   /
    2                   3
```

Comparison:

```text
1 == 1  → continue
2 != 3  → false
```

So the result is:

```text
false
```

---

# ✅ Correctness

The algorithm correctly determines whether two binary trees are identical because it checks **every corresponding position** in both trees.

For each pair of nodes:

1. If both are `null`, that position matches.
2. If exactly one is `null`, their structures differ.
3. If their values differ, the trees differ.
4. Otherwise, the algorithm recursively checks both the left and right subtrees.

A tree is identical only when all corresponding nodes have the same values and structure.

Therefore, the algorithm returns `true` **if and only if** the two binary trees are the same.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

Where `n` is the number of nodes that need to be compared.

Each corresponding node is visited at most once.

---

### Space Complexity

**O(h)**

Where `h` is the height of the tree.

The recursion stack stores calls for the current path from the root to a leaf.

* Balanced tree → **O(log n)**
* Skewed tree → **O(n)**

---

# 🎯 Key Takeaways

* Same Tree is a classic **binary tree recursion** problem.
* Compare two trees **simultaneously**, rather than traversing them separately.
* Always handle the **`null` cases first**.
* After confirming both nodes exist, compare their values.
* Both the **left and right subtrees** must match.
* The core recursive condition is:

```text
Same Tree =
    Same Left Subtree
    AND
    Same Right Subtree
    AND
    Same Current Node
```

### Interview Takeaway

This problem teaches an important tree-recursion pattern:

> **When comparing two trees, recursively compare corresponding nodes and their corresponding subtrees at the same time.**

This pattern is useful for many other binary-tree problems involving **structural comparison, symmetry, serialization, and recursive tree validation**.
