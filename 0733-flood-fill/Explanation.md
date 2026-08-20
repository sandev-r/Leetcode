# LeetCode 733 - Flood Fill

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

You are given a 2D image represented by a matrix of integers.

You are also given:

* `sr` → starting row
* `sc` → starting column
* `color` → new color

Starting from `(sr, sc)`, change the color of the starting cell and every **4-directionally connected cell** that has the same original color.

The four possible directions are:

```text
        Up
         ↑
Left ← Cell → Right
         ↓
       Down
```

Return the modified image.

---

# 💡 Intuition

This problem is essentially a **DFS traversal on a 2D grid**.

Think of the starting cell as the beginning of a connected region.

We need to:

1. Remember the original color of the starting cell.
2. Change the current cell to the new color.
3. Visit its four neighbors.
4. Continue only when a neighbor has the same original color.
5. Stop when we reach the boundary or a cell with a different color.

The important idea is:

> **Flood Fill = DFS/BFS traversal + same-color condition.**

We use DFS here because once we color a cell, we recursively explore all connected cells belonging to the same region.

---

# 🚀 Approach

### 1. Find the grid dimensions

Let:

* `rows` = number of rows
* `cols` = number of columns

This allows us to check whether a DFS position is inside the grid.

---

### 2. Store the original color

The starting cell determines which cells belong to the region.

For example:

```text
1 1 1
1 1 0
1 0 1
```

If the starting position is `(1, 1)`, its original color is:

```text
originalColor = 1
```

Only cells connected to `(1, 1)` having color `1` should be changed.

---

### 3. Start DFS from the starting cell

Call DFS using:

```text
(sr, sc)
```

The DFS receives:

* current row
* current column
* image
* original color
* new color
* number of rows
* number of columns

---

### 4. Check the boundary

Before processing a cell, make sure it is inside the grid.

Stop when:

```text
row < 0
col < 0
row >= rows
col >= cols
```

This prevents accessing an invalid position.

---

### 5. Ignore already-colored cells

If:

```text
image[row][col] == color
```

we stop.

This is important because the cell has already been converted to the target color.

It also prevents unnecessary recursive traversal.

---

### 6. Ignore cells with a different color

If:

```text
image[row][col] != originalColor
```

the cell does not belong to the connected region.

So we stop there.

---

### 7. Change the current cell

Once the cell passes all conditions:

```text
image[row][col] = color
```

Now the current cell is part of the filled region.

---

### 8. Explore four directions

From every valid cell, perform DFS in:

```text
Up
Down
Left
Right
```

So each cell can lead to at most four recursive calls.

---

### Example

Consider:

```text
1 1 1
1 1 0
1 0 1
```

Starting position:

```text
sr = 1
sc = 1
color = 2
```

The starting cell contains `1`.

The connected `1`s are:

```text
2 2 2
2 2 0
2 0 1
```

The isolated `1` at the bottom-right remains unchanged because it is not connected to the starting region.

---

# 🧠 Dry Run

Input:

```text
image =
1 1 1
1 1 0
1 0 1

sr = 1
sc = 1
color = 2
```

### Step 1 — Starting cell

Position:

```text
(1, 1)
```

Value:

```text
1
```

So:

```text
originalColor = 1
```

---

### Step 2 — Color `(1,1)`

```text
1 1 1
1 2 0
1 0 1
```

Now DFS explores its four neighbors.

---

### Step 3 — Explore `(0,1)`

It contains `1`.

Change it:

```text
1 2 1
1 2 0
1 0 1
```

Its neighbors are explored.

---

### Step 4 — Continue through connected `1`s

DFS reaches all connected cells containing the original color.

Eventually:

```text
2 2 2
2 2 0
2 0 1
```

The bottom-right `1` is not connected to the starting region, so it remains unchanged.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(R × C)**

Where:

* `R` = number of rows
* `C` = number of columns

In the worst case, DFS visits every cell in the matrix once.

Even though each cell checks four directions, the number of directions is constant.

Therefore:

```text
O(4 × R × C)
= O(R × C)
```

---

### Space Complexity

**O(R × C)** in the worst case.

The algorithm does not use a separate `visited` matrix.

However, DFS uses the **recursion stack**.

If the entire grid belongs to one connected region, the recursion depth can grow up to **O(R × C)**.

---

# 🎯 Key Takeaways

* Flood Fill is a classic **Grid DFS/BFS** problem.
* The starting cell determines the `originalColor`.
* Only cells with the same original color are processed.
* Each cell explores exactly **four directions**.
* Boundary checking prevents invalid grid access.
* Changing the cell's color acts as an implicit way of marking it as processed.
* No separate `visited[][]` array is required.
* The key pattern is:

### Pattern to Remember

```text
Grid Problem
     ↓
Start from a cell
     ↓
Check boundaries
     ↓
Check whether cell belongs to region
     ↓
Process / mark cell
     ↓
Explore 4 directions
     ↓
Repeat with DFS/BFS
```

**Flood Fill = Connected Component Traversal on a Grid**
