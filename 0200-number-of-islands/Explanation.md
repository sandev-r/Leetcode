# LeetCode 200 - Number of Islands

## 🟡 Difficulty

Medium

---

# 📝 Problem Statement

Given a 2D grid containing `'1'` representing **land** and `'0'` representing **water**, find the total number of islands.

An island is formed by connecting adjacent land cells **horizontally or vertically**.

Diagonal cells are **not considered connected**.

### Example

```text
Input:
[
  ["1","1","0"],
  ["1","0","0"],
  ["0","0","1"]
]

Output:
2
```

There are two islands:

```text
Island 1          Island 2

1 1 0             0 0 0
1 0 0             0 0 1
0 0 0             0 0 0
```

---

# 💡 Intuition

This problem is essentially asking us to find the number of **connected components in a grid**.

Whenever we encounter an unvisited land cell (`'1'`), we know that we have discovered a **new island**.

We can then use **DFS** to visit every land cell connected to that starting cell.

Once the entire island has been visited, we increase the island count by `1`.

The important idea is:

> **One DFS traversal completely explores one island.**

Therefore:

```text
Find unvisited land
        ↓
Start DFS
        ↓
Visit the entire island
        ↓
count++
        ↓
Continue scanning
```

---

# 🚀 Approach

### 1. Create a `visited` array

Create a boolean matrix with the same dimensions as the grid.

It keeps track of whether a cell has already been explored.

```text
visited[row][col] = true
```

This prevents us from processing the same land cell multiple times.

---

### 2. Traverse every cell

Use two nested loops to visit every cell in the grid.

For each cell, check:

```text
grid[row][col] == '1'
AND
visited[row][col] == false
```

If both conditions are true, we have found a **new island**.

---

### 3. Start DFS

Start DFS from the current land cell.

The DFS explores the four possible directions:

```text
        Up
         ↑
         |
Left ← Cell → Right
         |
         ↓
       Down
```

So from `(row, col)` we explore:

```text
(row - 1, col)   → Up
(row + 1, col)   → Down
(row, col - 1)   → Left
(row, col + 1)   → Right
```

---

### 4. Stop DFS when necessary

DFS should stop when:

* The position goes outside the grid.
* The cell has already been visited.
* The cell contains water (`'0'`).

Otherwise, mark the cell as visited and continue exploring its four neighbors.

---

### 5. Increment the island count

After DFS finishes, every cell belonging to that island has been visited.

Therefore:

```text
count++
```

Then continue scanning the remaining cells.

---

# 🧠 Dry Run

Consider:

```text
1 1 0
1 0 0
0 0 1
```

Initial:

```text
count = 0
```

### Step 1

Start scanning from `(0,0)`.

```text
1 1 0
1 0 0
0 0 1
↑
```

`(0,0)` is unvisited land.

Start DFS.

DFS visits:

```text
(0,0)
(0,1)
(1,0)
```

All three cells belong to the same island.

```text
count = 1
```

Visited:

```text
V V 0
V 0 0
0 0 1
```

---

### Step 2

Continue scanning.

The already visited land cells are skipped.

Eventually we reach:

```text
V V 0
V 0 0
0 0 1
      ↑
```

Cell `(2,2)` is unvisited land.

Start another DFS.

There are no other connected land cells.

```text
count = 2
```

---

### Final Result

```text
Number of Islands = 2
```

---

# ✅ Correctness

The algorithm correctly counts every island exactly once.

### Why?

Whenever the traversal finds an unvisited land cell, that cell must belong to an island that has not been counted yet.

DFS then visits **every horizontally or vertically connected land cell** belonging to that island.

Because all those cells are marked as visited, the same island cannot be counted again.

Therefore:

* Every island is counted.
* No island is counted more than once.

Hence, the algorithm correctly returns the total number of islands.

---

# ⏱️ Complexity Analysis

Let:

```text
R = number of rows
C = number of columns
```

### Time Complexity

```text
O(R × C)
```

Every cell is visited at most once.

Although DFS checks four directions, each check takes constant time.

Therefore, the total time complexity is:

```text
O(R × C)
```

### Space Complexity

```text
O(R × C)
```

The `visited` matrix requires `R × C` space.

The recursive DFS call stack can also grow up to `O(R × C)` in the worst case.

Therefore, the overall auxiliary space complexity is:

```text
O(R × C)
```

---

# 🎯 Key Takeaways

* **Number of Islands is a connected-components problem on a grid.**
* An unvisited `'1'` means we have discovered a new island.
* One DFS completely explores one island.
* Marking cells as visited prevents duplicate counting.
* Only **4 directions** are considered: up, down, left, and right.
* The pattern is highly reusable for grid problems involving connected regions.

### Pattern to Remember

```text
Grid
 ↓
Find unvisited valid cell
 ↓
DFS / BFS
 ↓
Explore complete component
 ↓
Count component
```

> **When a grid problem asks "how many connected regions/groups/islands?", think Connected Components + DFS/BFS.**
