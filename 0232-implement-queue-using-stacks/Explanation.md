# 232. Implement Queue using Stacks

## Problem

Implement a **First In First Out (FIFO)** queue using only stacks.

The queue should support the following operations:

* `push(x)` → Insert an element at the back of the queue.
* `pop()` → Remove and return the front element.
* `peek()` → Return the front element without removing it.
* `empty()` → Return whether the queue is empty.

---

# Intuition

A stack follows **LIFO (Last In First Out)**, while a queue follows **FIFO (First In First Out)**.

The challenge is to make two LIFO structures behave like one FIFO structure.

The idea is:

* One stack stores newly inserted elements.
* Another stack is used to remove elements in queue order.

When the output stack becomes empty, move every element from the input stack into the output stack.

This reversal changes:

```
Input Stack:
Top
3
2
1

↓

Transfer

↓

Output Stack:
Top
1
2
3
```

Now the oldest element is on top, allowing queue operations.

---

# Approach

Maintain two stacks:

* **Input Stack**

  * Used only for insertion.
  * Every new element is pushed here.

* **Output Stack**

  * Used for `pop()` and `peek()`.
  * If it is empty, transfer every element from the input stack.

### Push

Simply push the element into the input stack.

---

### Pop

* If the output stack is empty:

  * Transfer all elements from the input stack.
* Pop from the output stack.

---

### Peek

* If the output stack is empty:

  * Transfer all elements.
* Return the top element of the output stack.

---

### Empty

The queue is empty only when **both stacks are empty**.

---

# Example

```
push(1)
Input : [1]
Output: []

push(2)
Input : [1,2]
Output: []

peek()

Transfer

Input : []
Output: [2,1]

Front = 1

pop()

Output: [2]

Returns 1

push(3)

Input : [3]
Output: [2]

pop()

Returns 2

Output becomes empty

Next pop requires another transfer.
```

---

# Why Transfer Only When Needed?

Suppose we transferred after every insertion.

```
push(1)
Transfer

push(2)
Transfer

push(3)
Transfer
```

Every insertion would move many elements repeatedly, making the implementation inefficient.

Instead, we wait until the output stack becomes empty.

This allows many `pop()` operations to happen without moving elements again.

---

# Amortized Analysis

At first glance, transferring looks expensive because it moves every element.

However, observe an important fact:

* Every element is pushed into the input stack **once**.
* It is transferred to the output stack **once**.
* It is popped from the output stack **once**.

An element is **never transferred multiple times**.

For **n** inserted elements:

* Push into input stack → **n operations**
* Transfer to output stack → **n operations**
* Pop from output stack → **n operations**

Total work = **3n**

Average work per queue operation:

```
3n / n = 3
```

Ignoring constants,

**Amortized Time = O(1)**

Although a single transfer may take **O(n)** time, that cost is spread across many future operations.

---

# Time Complexity

| Operation | Time           |
| --------- | -------------- |
| Push      | O(1)           |
| Pop       | O(1) Amortized |
| Peek      | O(1) Amortized |
| Empty     | O(1)           |

---

# Space Complexity

* Two stacks together store every element exactly once.

**Space Complexity: O(n)**

where **n** is the number of elements in the queue.

---

# Key Takeaways

* Two stacks can simulate a queue.
* The input stack stores newly added elements.
* The output stack provides FIFO order.
* Elements are transferred **only when the output stack becomes empty**.
* Transfer reverses the order, making the oldest element accessible.
* `pop()` and `peek()` achieve **O(1) amortized** time because each element is transferred only once.
