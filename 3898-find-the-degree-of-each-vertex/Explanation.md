# LeetCode 3898 - Find Degrees of Every Node

## Approach

Each row of the adjacency matrix represents the outgoing connections of a node.

- Traverse every row of the matrix.
- For each row, calculate the sum of all its elements.
- Store the sum in the answer array.
- The resulting array contains the degree of every node.

Since each row is visited once and every column inside that row is checked once, every element of the matrix is processed exactly one time.

---

## Algorithm

1. Get the size of the matrix `n`.
2. Create an integer array `ans` of size `n`.
3. Traverse each row of the matrix.
4. For every element in the current row:
   - Add its value to `ans[i]`.
5. Return the `ans` array.

---

## Dry Run

### Input

```text
matrix =
[
  [0,1,1],
  [1,0,0],
  [1,0,0]
]
```

### Initial State

```text
ans = [0, 0, 0]
```

### Row 0

```text
0 + 1 + 1 = 2

ans = [2, 0, 0]
```

### Row 1

```text
1 + 0 + 0 = 1

ans = [2, 1, 0]
```

### Row 2

```text
1 + 0 + 0 = 1

ans = [2, 1, 1]
```

### Output

```text
[2, 1, 1]
```

---

## Time Complexity

- Outer loop runs **n** times.
- Inner loop runs **n** times for each row.

**Time Complexity:** **O(n²)**

---

## Space Complexity

- The output array stores one degree for each node.

**Space Complexity:** **O(n)**

> **Note:** The auxiliary (extra) space used by the algorithm is **O(1)** since the output array is not counted as extra space.

---

## Key Insight

- The degree of a node is simply the sum of all values in its corresponding row of the adjacency matrix.
- No additional data structures are required.
- Every matrix element is visited exactly once, making this the optimal solution for an adjacency matrix representation.
