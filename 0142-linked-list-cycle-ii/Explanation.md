# Explanation

## Problem Summary

Given the `head` of a linked list, determine whether the linked list contains a cycle. If a cycle exists, return the node where the cycle begins. Otherwise, return `null`.

A cycle occurs when a node's `next` pointer points back to a previous node, forming a loop.

---

## Intuition

A brute-force solution would store every visited node in a `HashSet`. If we visit the same node again, we have found the cycle.

However, this requires **O(n)** extra space.

A better solution is **Floyd's Cycle Detection Algorithm (Tortoise and Hare Algorithm)**, which uses two pointers moving at different speeds.

- `slow` moves **one step** at a time.
- `fast` moves **two steps** at a time.

If a cycle exists, both pointers will eventually meet inside the cycle.

The next challenge is finding the **starting node of the cycle**.

---

## Key Observation

Once `slow` and `fast` meet:

- Create another pointer `ptr` starting from the `head`.
- Move both `ptr` and `slow` one step at a time.
- The node where they meet is the **starting node of the cycle**.

This works because of Floyd's mathematical proof.

---

## Approach

### Step 1

Initialize two pointers:

- `slow = head`
- `fast = head`

---

### Step 2

Move the pointers until:

- `fast` reaches the end → no cycle.
- `slow == fast` → cycle detected.

```text
slow -> 1 step
fast -> 2 steps
```

---

### Step 3

Once both pointers meet:

Create another pointer:

```java
ListNode ptr = head;
```

---

### Step 4

Move both pointers one step at a time.

```text
ptr = ptr.next;
slow = slow.next;
```

Eventually,

```text
ptr == slow
```

This node is the beginning of the cycle.

---

## Dry Run

### Example

```text
3 → 2 → 0 → -4
    ↑       |
    |_______|
```

Cycle starts at node **2**.

### Initial State

```text
slow = 3
fast = 3
```

---

### Iteration 1

```text
slow -> 2
fast -> 0
```

---

### Iteration 2

```text
slow -> 0
fast -> 2
```

---

### Iteration 3

```text
slow -> -4
fast -> -4
```

Pointers meet.

---

Create

```text
ptr = head (3)
```

Now move both one step.

### Step 1

```text
ptr -> 2
slow -> 2
```

They meet.

Return

```text
2
```

which is exactly the beginning of the cycle.

---

## Algorithm

1. Initialize `slow` and `fast` at `head`.
2. Move:
   - `slow` by one step.
   - `fast` by two steps.
3. If they never meet, return `null`.
4. If they meet:
   - Create `ptr = head`.
   - Move both `ptr` and `slow` one step at a time.
5. When both pointers meet again, return that node.

---

## Why This Works

Assume:

- Distance from head to cycle start = **L**
- Distance from cycle start to meeting point = **X**
- Remaining cycle length = **C - X**

When `slow` and `fast` meet:

```text
Distance(slow) = L + X
Distance(fast) = L + X + k × C
```

Since `fast` moves twice as fast:

```text
2(L + X) = L + X + kC
```

Simplifying,

```text
L + X = kC
```

which means

```text
L = kC - X
```

This tells us:

- Starting one pointer from the **head**
- Starting the other from the **meeting point**

and moving both one step at a time causes them to meet exactly at the **cycle's starting node**.

That is why the second phase of Floyd's Algorithm always works.

---

## Complexity Analysis

### Time Complexity

- Detecting the cycle: **O(n)**
- Finding the cycle start: **O(n)**

Overall:

```text
O(n)
```

---

### Space Complexity

Only three pointers are used.

```text
O(1)
```

---

## Key Takeaways

- Floyd's Cycle Detection Algorithm uses two pointers moving at different speeds.
- If `slow` and `fast` meet, a cycle exists.
- Reset another pointer to `head`.
- Move both pointers one step at a time.
- Their meeting point is always the **starting node of the cycle**.
- No extra memory is required, making this an **O(n)** time and **O(1)** space solution.
