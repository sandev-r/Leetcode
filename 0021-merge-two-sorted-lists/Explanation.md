# 21. Merge Two Sorted Lists

## Problem Summary

You are given the heads of two **sorted** linked lists, `list1` and `list2`.

Merge both lists into a single **sorted linked list** by rearranging the existing nodes (without creating new nodes for each value).

Return the head of the merged linked list.

---

## Intuition

Since both linked lists are already sorted, we don't need to search for the correct position of every element.

At any moment:

- The smaller node between `list1` and `list2` must be the next node in the merged list.
- After selecting that node, move its pointer forward.
- Continue until one list becomes empty.
- Finally, attach the remaining nodes from the other list.

A **dummy node** is used to simplify handling the head of the merged list.

---

## Key Observation

- Both lists are already sorted.
- We only compare the current nodes of each list.
- Every comparison permanently places one node into the answer.
- No extra nodes are created (except the dummy node).

---

## Approach

1. Create a dummy node.
2. Create a `tail` pointer pointing to the dummy.
3. Compare the current nodes of both lists.
4. Attach the smaller node to `tail.next`.
5. Move both:
   - `tail` forward.
   - The selected list forward.
6. Repeat until one list becomes empty.
7. Attach the remaining nodes from the non-empty list.
8. Return `dummy.next`.

---

## Dry Run

### Input

```
list1: 1 → 2 → 4
list2: 1 → 3 → 4
```

### Initial State

```
dummy → null
tail = dummy

list1 → 1 → 2 → 4
list2 → 1 → 3 → 4
```

---

### Step 1

Compare

```
1 <= 1
```

Attach list1 node.

```
dummy → 1
          ↑
        tail

list1 → 2 → 4
list2 → 1 → 3 → 4
```

---

### Step 2

Compare

```
2 > 1
```

Attach list2 node.

```
dummy → 1 → 1
              ↑
            tail

list1 → 2 → 4
list2 → 3 → 4
```

---

### Step 3

Compare

```
2 < 3
```

Attach list1 node.

```
dummy → 1 → 1 → 2
                  ↑
                tail

list1 → 4
list2 → 3 → 4
```

---

### Step 4

Compare

```
4 > 3
```

Attach list2 node.

```
dummy → 1 → 1 → 2 → 3
                      ↑
                    tail

list1 → 4
list2 → 4
```

---

### Step 5

Compare

```
4 <= 4
```

Attach list1 node.

```
dummy → 1 → 1 → 2 → 3 → 4
                          ↑
                        tail

list1 → null
list2 → 4
```

---

### Remaining Nodes

`list1` is empty.

Attach remaining nodes from `list2`.

```
dummy → 1 → 1 → 2 → 3 → 4 → 4
```

Return

```
dummy.next
```

---

## Algorithm

1. Create a dummy node.
2. Let `tail = dummy`.
3. While both lists are not empty:
   - Compare current values.
   - Attach the smaller node.
   - Move `tail`.
   - Move the chosen list.
4. Attach the remaining nodes of `list1`, if any.
5. Attach the remaining nodes of `list2`, if any.
6. Return `dummy.next`.

---

## Why This Works

At every step:

- The first node of each list is the smallest remaining node in that list.
- Comparing only those two nodes guarantees choosing the smallest available node overall.
- Once a node is attached, it never needs to be moved again because all future nodes are greater than or equal to it.

The dummy node allows us to build the list without worrying about special cases for the first node.

---

## Complexity Analysis

### Time Complexity

- Every node is visited exactly once.

**O(n + m)**

where

- `n` = length of `list1`
- `m` = length of `list2`

---

### Space Complexity

No extra data structures are used.

Only two pointers (`dummy` and `tail`) are maintained.

**O(1)**

---

# Key Takeaways

- Dummy nodes simplify linked list construction.
- The `tail` pointer always points to the last node of the merged list.
- Compare only the current nodes because both lists are already sorted.
- Every node is processed exactly once.
- This is the optimal solution with **O(n + m)** time and **O(1)** extra space.
```
