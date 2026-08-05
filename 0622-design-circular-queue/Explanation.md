# 622. Design Circular Queue

## Problem

Design your implementation of the Circular Queue. The circular queue is a linear data structure where the operations are performed based on the **FIFO (First In, First Out)** principle, and the last position is connected back to the first position to make a circle.

Implement the following operations:

* `enQueue(value)` – Insert an element into the circular queue.
* `deQueue()` – Delete an element from the circular queue.
* `Front()` – Get the front item.
* `Rear()` – Get the last item.
* `isEmpty()` – Check whether the circular queue is empty.
* `isFull()` – Check whether the circular queue is full.

---

# Intuition

A normal queue wastes space after multiple dequeue operations because the front keeps moving forward, leaving unused positions behind.

Example:

```
Capacity = 5

Initial
[1][2][3][4][5]

After removing 1 and 2

[X][X][3][4][5]
       ↑
     Front

Rear is already at the end.
Even though two spaces are empty, we cannot insert new elements.
```

A **Circular Queue** solves this problem.

Instead of stopping at the last index, the rear pointer wraps back to index `0`.

This wrapping is achieved using the modulo operator:

```
(nextIndex) = (currentIndex + 1) % capacity
```

When the rear reaches the last position, it automatically moves back to the beginning if space is available.

This allows complete utilization of the array without shifting elements.

---

# Approach

We maintain five variables:

* `arr` → stores queue elements.
* `front` → points to the first element.
* `rear` → points to the last inserted element.
* `size` → current number of elements.
* `capacity` → maximum size of the queue.

### 1. Initialization

* Create an array of size `k`.
* Set `front = 0`.
* Set `rear = -1`.
* Set `size = 0`.

---

### 2. enQueue(value)

Before inserting:

* Check whether the queue is full.
* If full, return `false`.

Otherwise:

* Move the rear pointer using circular indexing.
* Store the new value.
* Increase the size.
* Return `true`.

---

### 3. deQueue()

Before removing:

* Check whether the queue is empty.
* If empty, return `false`.

Otherwise:

* Move the front pointer to the next circular position.
* Decrease the size.
* Return `true`.

Notice that no element is physically deleted from the array.

Only the pointers move.

---

### 4. Front()

If the queue is empty:

* Return `-1`.

Otherwise:

* Return the element at the `front` index.

---

### 5. Rear()

If the queue is empty:

* Return `-1`.

Otherwise:

* Return the element at the `rear` index.

---

### 6. isEmpty()

The queue is empty when:

```
size == 0
```

---

### 7. isFull()

The queue is full when:

```
size == capacity
```

Using `size` eliminates the ambiguity that occurs when `front == rear`, making empty and full conditions easy to distinguish.

---

# Dry Run

### Capacity = 3

Initial

```
Queue = [_, _, _]

front = 0
rear = -1
size = 0
```

---

### Operation 1

```
enQueue(10)
```

```
rear = (−1 + 1) % 3 = 0

Queue

[10, _, _]

front = 0
rear = 0
size = 1
```

---

### Operation 2

```
enQueue(20)
```

```
rear = (0 + 1) % 3 = 1

Queue

[10, 20, _]

front = 0
rear = 1
size = 2
```

---

### Operation 3

```
enQueue(30)
```

```
rear = (1 + 1) % 3 = 2

Queue

[10,20,30]

front = 0
rear = 2
size = 3
```

Queue is now full.

---

### Operation 4

```
deQueue()
```

Remove front element.

```
front = (0 + 1) % 3 = 1

Queue

[10,20,30]

Logical Queue:

20 → 30

front = 1
rear = 2
size = 2
```

Notice:

The value `10` still exists inside the array, but it is ignored because the `front` pointer has moved.

---

### Operation 5

```
enQueue(40)
```

```
rear = (2 + 1) % 3 = 0
```

Rear wraps around.

```
Queue

[40,20,30]

front = 1
rear = 0
size = 3
```

Logical queue:

```
20 → 30 → 40
```

This demonstrates why it is called a **Circular Queue**.

---

### Operation 6

```
Front()
```

Returns

```
20
```

---

### Operation 7

```
Rear()
```

Returns

```
40
```

---

# Why Modulo (%) is Used

The modulo operator allows the pointers to wrap around automatically.

Formula:

```
(nextIndex) = (currentIndex + 1) % capacity
```

Example:

```
capacity = 5

Current Rear = 4

(4 + 1) % 5

= 5 % 5

= 0
```

Instead of moving outside the array, the pointer returns to index `0`.

This is the key idea behind a circular queue.

---

# Complexity Analysis

### enQueue()

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

### deQueue()

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

### Front()

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

### Rear()

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

### isEmpty()

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

### isFull()

* Time Complexity: **O(1)**
* Space Complexity: **O(1)**

---

# Key Takeaways

* Circular Queue efficiently utilizes the entire array.
* The modulo operator (`%`) is used to wrap pointers back to the beginning.
* No elements are shifted during insertion or deletion.
* The `size` variable makes checking **empty** and **full** conditions straightforward.
* All queue operations execute in **constant O(1) time**, making this implementation highly efficient.
