# 876. Middle of the Linked List

## Problem Summary

Given the `head` of a singly linked list, return the **middle node** of the linked list.

- If the list has **odd** number of nodes, return the exact middle node.
- If the list has **even** number of nodes, return the **second middle** node.

---

## Intuition

If we traverse the linked list once to count the number of nodes, we would need another traversal to reach the middle.

Instead, we can solve it in **one traversal** using two pointers:

- **Slow Pointer** → Moves one step at a time.
- **Fast Pointer** → Moves two steps at a time.

Since the fast pointer moves twice as quickly, by the time it reaches the end of the list, the slow pointer will be exactly at the middle.

---

## Key Observation

- Every iteration:
  - `slow` moves **1 node**
  - `fast` moves **2 nodes**

Therefore:

- When `fast` reaches the end,
- `slow` has covered only half the distance,
- which means `slow` is pointing to the middle node.

For even-length lists, `fast` becomes `null`, leaving `slow` on the **second middle node**, exactly as required.

---

## Approach

1. Initialize two pointers:
   - `slow = head`
   - `fast = head`
2. Traverse the list while:
   - `fast != null`
   - `fast.next != null`
3. In every iteration:
   - Move `slow` by one node.
   - Move `fast` by two nodes.
4. When the loop ends, return `slow`.

---

## Dry Run

### Example 1

**Input**

```
1 → 2 → 3 → 4 → 5
```

| Iteration | Slow | Fast |
|-----------|------|------|
| Start | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 5 |

`fast.next == null`

**Answer:** Node `3`

---

### Example 2

**Input**

```
1 → 2 → 3 → 4 → 5 → 6
```

| Iteration | Slow | Fast |
|-----------|------|------|
| Start | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 5 |
| 3 | 4 | null |

Loop ends.

**Answer:** Node `4` (second middle node)

---

## Algorithm

1. Set `slow` and `fast` to `head`.
2. While `fast` and `fast.next` are not `null`:
   - Move `slow = slow.next`
   - Move `fast = fast.next.next`
3. Return `slow`.

---

## Why This Works

The fast pointer travels twice as fast as the slow pointer.

- After `k` iterations:
  - `slow` has moved `k` nodes.
  - `fast` has moved `2k` nodes.

When `fast` reaches the end of the list, `slow` has traveled exactly half the distance, placing it at the middle.

This works for both odd and even length linked lists without needing to know the length beforehand.

---

## Complexity Analysis

### Time Complexity

- **O(n)**

Each node is visited at most once.

### Space Complexity

- **O(1)**

Only two pointers are used.

---

## Key Takeaways

- The **Fast & Slow Pointer** technique is one of the most important linked list patterns.
- It finds the middle in **one traversal**.
- No extra memory is required.
- The same technique is also used in problems like:
  - Detect Cycle in Linked List
  - Find Beginning of Cycle
  - Happy Number
  - Reorder List
  - Palindrome Linked List
```
