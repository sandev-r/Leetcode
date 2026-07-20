# 206. Reverse Linked List

## Problem Summary

You are given the **head** of a singly linked list.

Your task is to reverse the linked list and return the new head.

For example:

**Original List**

```
1 → 2 → 3 → 4 → 5 → null
```

**Reversed List**

```
5 → 4 → 3 → 2 → 1 → null
```

---

## Intuition

Instead of reversing the list from the beginning, we let recursion travel all the way to the last node.

Once the recursion reaches the last node, it starts returning back. During this return phase, every node reverses its connection with the next node.

This naturally reverses the entire linked list without using any extra data structure.

---

## Key Observation

The last node of the original list becomes the new head of the reversed list.

During recursion:

- We first move to the end of the list.
- While returning from each recursive call, the current node is attached after its next node.
- Finally, the original head becomes the last node, so its `next` reference must be set to `null`.

---

## Approach

1. If the list is empty or contains only one node, return it because it is already reversed.
2. Recursively move to the last node of the linked list.
3. The last node becomes the new head.
4. While returning from recursion:
   - Reverse the connection between the current node and its next node.
   - Remove the old forward connection to avoid creating a cycle.
5. Return the new head obtained from the recursive calls.

---

## Dry Run

### Input

```
1 → 2 → 3 → null
```

### Recursive Calls

```
reverse(1)
    ↓
reverse(2)
    ↓
reverse(3)
```

Node `3` is the last node.

Return:

```
newHead = 3
```

---

### Returning to Node 2

Current structure:

```
2 → 3 → null
```

Reverse the connection:

```
3 → 2
```

Remove the old forward link:

```
2 → null
```

Now the list becomes:

```
3 → 2 → null
```

---

### Returning to Node 1

Current structure:

```
1 → 2 → null
```

Reverse the connection:

```
2 → 1
```

Remove the old forward link:

```
1 → null
```

Final list:

```
3 → 2 → 1 → null
```

Return:

```
3
```

---

## Algorithm

1. Check whether the list is empty or has only one node.
2. Recursively move to the last node.
3. Store the new head returned by the recursive call.
4. Reverse the link between the current node and its next node.
5. Disconnect the current node from its original next node.
6. Return the new head.

---

## Why This Works

The recursion first reaches the last node, which becomes the new head of the reversed list.

As each recursive call finishes, the current node is placed after its next node, reversing one connection at a time.

Removing the original forward link prevents cycles from forming.

When all recursive calls finish, every link has been reversed, producing the complete reversed linked list.

---

## Complexity Analysis

### Time Complexity

**O(n)**

- Every node is visited exactly once.

### Space Complexity

**O(n)**

- The recursion stack stores one function call for each node.

---

## Key Takeaways

- This solution uses **recursion** instead of iteration.
- The recursion first reaches the last node before performing any reversal.
- The last node automatically becomes the new head.
- Links are reversed while the recursive calls return.
- The original forward connection must be removed to prevent cycles.
- Although elegant, the recursive solution uses **O(n)** extra stack space, whereas the iterative approach uses **O(1)** space.
