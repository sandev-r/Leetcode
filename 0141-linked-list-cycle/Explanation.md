# 141. Linked List Cycle

**Difficulty:** Easy

---

# Problem Summary

You are given the `head` of a singly linked list.

Determine whether the linked list contains a **cycle**.

A cycle exists if a node can be reached again by continuously following the `next` pointers.

Return:

- `true` → if a cycle exists.
- `false` → otherwise.

---

# Intuition

A normal linked list eventually reaches `null`.

If a cycle exists, traversing the list will never reach `null` because the nodes keep repeating.

Instead of storing visited nodes (which requires extra memory), we can use **two pointers**:

- A **slow pointer** moves **one step** at a time.
- A **fast pointer** moves **two steps** at a time.

If there is a cycle, the fast pointer will eventually catch the slow pointer.

If there is no cycle, the fast pointer will reach `null`.

---

# Key Observation

There are only two possible situations:

### Case 1: No Cycle

The fast pointer reaches the end of the list.

```
1 → 2 → 3 → 4 → null

Slow: 1 → 2 → 3 → 4
Fast: 1 → 3 → null
```

Result: **false**

---

### Case 2: Cycle Exists

The fast pointer keeps moving around the cycle and eventually meets the slow pointer.

```
1 → 2 → 3
    ↑     ↓
    5 ← 4
```

Result: **true**

---

# Approach

1. Initialize two pointers:
   - `slow = head`
   - `fast = head`
2. Traverse the list while `fast` and `fast.next` are not `null`.
3. Move:
   - `slow` by one node.
   - `fast` by two nodes.
4. If both pointers become equal, a cycle exists.
5. If the loop ends, no cycle exists.

This algorithm is called **Floyd's Cycle Detection Algorithm** (Tortoise and Hare Algorithm).

---

# Dry Run

### Example

```
3 → 2 → 0 → -4
    ↑       ↓
    ← ← ← ←
```

Initially

```
Slow = 3
Fast = 3
```

### Iteration 1

```
Slow → 2
Fast → 0
```

---

### Iteration 2

```
Slow → 0
Fast → 2
```

---

### Iteration 3

```
Slow → -4
Fast → -4
```

Both pointers meet.

Return

```
true
```

---

# Algorithm

1. Set `slow` and `fast` to `head`.
2. While `fast != null` and `fast.next != null`:
   - Move `slow` one step.
   - Move `fast` two steps.
   - If `slow == fast`, return `true`.
3. Return `false`.

---

# Why This Works

If there is **no cycle**, the fast pointer eventually reaches `null`, so the traversal stops.

If there **is a cycle**, the fast pointer moves one node faster than the slow pointer inside the loop. Since both pointers continue moving around the same cycle, the distance between them decreases until they meet.

Therefore:

- Meeting point → Cycle exists.
- Fast pointer reaches `null` → No cycle.

---

# Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |

**Time Complexity:** `O(n)` because each pointer traverses the list at most once.

**Space Complexity:** `O(1)` because only two pointers are used.

---

# Key Takeaways

- A linked list without a cycle always ends at `null`.
- Floyd's Cycle Detection Algorithm uses two pointers moving at different speeds.
- If the pointers meet, a cycle exists.
- No extra memory is required.
- This is the optimal solution with **O(n)** time and **O(1)** space.
