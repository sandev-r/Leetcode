# LeetCode 203 - Remove Linked List Elements

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

Given the head of a singly linked list and an integer `val`, remove **every node** whose value is equal to `val`.

After removing all such nodes, return the head of the updated linked list.

The challenge is that the node to be removed can appear anywhere in the list, including the **first node (head)**.

---

# 💡 Intuition

The first idea is to traverse the linked list and check every node.

Whenever we find a node whose value equals `val`, we remove it by changing the previous node's `next` pointer.

However, there is one problem:

If the **head itself** needs to be removed, we lose the starting point of the list.

To avoid writing separate logic for removing the head, we create a **dummy node** before the actual head.

This dummy node always stays before the list, making every deletion look exactly the same, whether it's the first node or any other node.

---

# 🚀 Approach

1. Create a **dummy node** and connect it to the original head.

2. Maintain two pointers:
   - `prev` → points to the previous node.
   - `head` → points to the current node.

3. Traverse the linked list until `head` becomes `null`.

4. If the current node's value equals `val`:
   - Skip that node by connecting `prev.next` to `head.next`.
   - Move only the `head` pointer forward because `prev` should remain at the previous valid node.

5. Otherwise:
   - Move both `prev` and `head` forward since the current node is kept in the list.

6. After the traversal is complete, return `dummy.next`, which points to the new head of the modified list.

---

# 🧠 Dry Run

### Example

Input

```text
head = [1,2,6,3,4,5,6]
val = 6
```

### Execution

```
Initial List

Dummy → 1 → 2 → 6 → 3 → 4 → 5 → 6

prev = Dummy
head = 1
```

### Iteration 1

```
Current Node = 1

1 != 6

Move both pointers.

prev = 1
head = 2
```

### Iteration 2

```
Current Node = 2

2 != 6

Move both pointers.

prev = 2
head = 6
```

### Iteration 3

```
Current Node = 6

6 == val

Remove the node.

2 → 6 → 3

becomes

2 ─────→ 3

Move only head.

prev = 2
head = 3
```

### Iteration 4

```
Current Node = 3

Keep it.

prev = 3
head = 4
```

### Iteration 5

```
Current Node = 4

Keep it.

prev = 4
head = 5
```

### Iteration 6

```
Current Node = 5

Keep it.

prev = 5
head = 6
```

### Iteration 7

```
Current Node = 6

Remove it.

5 → 6 → null

becomes

5 → null

head = null
```

### Final Output

```text
[1,2,3,4,5]
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the linked list only once, visiting each node exactly one time.

### Space Complexity

```text
O(1)
```

Only a dummy node and a few pointer variables are used. No extra data structures are created.

---

# 🎯 Key Takeaways

- A **dummy node** is a common technique to simplify linked list deletion problems.
- Always keep track of the **previous node** when deleting nodes in a singly linked list.
- After deleting a node, **do not move the `prev` pointer** because its `next` has changed.
- Returning `dummy.next` correctly handles cases where the original head is removed.
- **Interview tip:** Whenever a linked list problem involves inserting or deleting nodes near the head, think about using a **dummy node** to eliminate special-case handling.
