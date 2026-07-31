# 1290. Convert Binary Number in a Linked List to Integer

## Problem Statement

You are given the `head` of a singly linked list. Each node contains either `0` or `1`, representing a binary number.

The head of the linked list is the **most significant bit (MSB)**.

Return the decimal value of the binary number represented by the linked list.

---

# Intuition

A binary number is processed from **left to right**.

Whenever we read a new binary digit:

1. Shift the current decimal value one bit to the left.
2. Add the current node's value (`0` or `1`).

This is exactly how binary numbers are built.

Example:

Binary Number: `101`

Start with:

```
0
```

Read `1`

```
0 << 1 = 0
0 + 1 = 1
```

Read `0`

```
1 << 1 = 2
2 + 0 = 2
```

Read `1`

```
2 << 1 = 4
4 + 1 = 5
```

Final Answer:

```
5
```

---

# Approach

1. Initialize an integer variable `binary` to `0`.
2. Traverse the linked list from head to tail.
3. For every node:

   * Left shift the current value by one bit.
   * Add the current node's value.
4. Continue until the linked list ends.
5. Return the final decimal value.

---

# Dry Run

### Input

```
head = [1,0,1]
```

### Step 1

Current Value

```
0
```

Current Node

```
1
```

Calculation

```
(0 << 1) + 1 = 1
```

Current Value

```
1
```

---

### Step 2

Current Node

```
0
```

Calculation

```
(1 << 1) + 0 = 2
```

Current Value

```
2
```

---

### Step 3

Current Node

```
1
```

Calculation

```
(2 << 1) + 1 = 5
```

Current Value

```
5
```

---

Final Answer

```
5
```

---

# Why Left Shift Works

A left shift (`<< 1`) multiplies a number by **2**.

Example:

```
3 << 1 = 6
5 << 1 = 10
8 << 1 = 16
```

Building a binary number follows this rule:

```
newValue = currentValue × 2 + currentBit
```

Using the left shift operator is simply a faster way to perform the multiplication.

---

# Time Complexity

* **O(n)**

We traverse the linked list exactly once.

---

# Space Complexity

* **O(1)**

Only a single integer variable is used regardless of the input size.

---

# Key Takeaways

* A binary number can be built while traversing from left to right.
* Left shift (`<< 1`) is equivalent to multiplying the current value by `2`.
* After shifting, add the current binary digit (`0` or `1`).
* This approach requires only one traversal and constant extra space.
