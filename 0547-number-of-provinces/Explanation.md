# LeetCode 547 - Number of Provinces

## 🟢 Difficulty

Medium

---

# 📝 Problem Statement

You are given an `n × n` matrix `isConnected`.

* `isConnected[i][j] = 1` means city `i` and city `j` are directly connected.
* `isConnected[i][j] = 0` means they are not directly connected.
* A **province** is a group of cities that are connected directly or indirectly.

Return the total number of provinces.

---

# 💡 Intuition

This problem is a **Connected Components** problem.

Think of every city as a **node** in a graph.

If two cities are connected, there is an **edge** between them.

For example:

```text
0 ─── 1 ─── 2       3 ─── 4       5
```

There are three connected components:

```text
{0, 1, 2}
{3, 4}
{5}
```

Therefore:

```text
Number of provinces = 3
```

The key idea is:

> Start DFS from every city that has not been visited yet. Each new DFS represents one new province.

---

# 🚀 Approach

### Step 1: Convert the Matrix into an Adjacency List

The input is given as an adjacency matrix.

For every pair of cities `i` and `j`, check:

```text
isConnected[i][j] == 1
```

If they are connected, add them to each other's adjacency list because the graph is undirected.

```text
i → j
j → i
```

We also ignore:

```text
i == j
```

because a city connecting to itself does not provide useful graph information.

---

### Step 2: Create a Visited Array

Create:

```text
visited[]
```

Initially, every city is unvisited.

When DFS reaches a city, mark it as visited.

This prevents the same city from being processed repeatedly.

---

### Step 3: Traverse Every City

Iterate through all cities.

For every city:

```text
if city is not visited
```

start a DFS.

Why?

Because an unvisited city means we have discovered a **new connected component**.

So:

```text
DFS(city)
count++
```

---

### Step 4: DFS

DFS marks the current city as visited.

Then it checks every neighboring city.

If a neighbor has not been visited, recursively perform DFS on that neighbor.

This continues until every city belonging to the current province has been visited.

For example:

```text
0 ─── 1 ─── 2
```

Starting from `0`:

```text
DFS(0)
   ↓
visit 0
   ↓
visit 1
   ↓
visit 2
```

Now the entire component `{0, 1, 2}` has been visited.

---

### Step 5: Count the Provinces

Suppose the graph is:

```text
0 ─── 1 ─── 2

3 ─── 4

5
```

Traversal:

```text
i = 0 → unvisited → DFS → count = 1
i = 1 → visited → skip
i = 2 → visited → skip

i = 3 → unvisited → DFS → count = 2
i = 4 → visited → skip

i = 5 → unvisited → DFS → count = 3
```

Final answer:

```text
3
```

---

# 🧠 Dry Run

Consider:

```text
isConnected =
[
    [1,1,0],
    [1,1,0],
    [0,0,1]
]
```

The graph is:

```text
0 ─── 1

2
```

### Initial State

```text
visited = [false, false, false]
count = 0
```

### Start at City 0

City `0` is unvisited.

Run DFS:

```text
DFS(0)
```

DFS visits:

```text
0 → 1
```

Now:

```text
visited = [true, true, false]
count = 1
```

Cities `0` and `1` belong to the same province.

---

### Move to City 1

City `1` is already visited.

Skip it.

---

### Move to City 2

City `2` is unvisited.

Run:

```text
DFS(2)
```

Now:

```text
visited = [true, true, true]
count = 2
```

City `2` forms its own province.

---

### Final Result

```text
answer = 2
```

---

# ⏱️ Complexity Analysis

### Time Complexity

Building the adjacency list requires checking every cell of the `n × n` matrix:

```text
O(n²)
```

DFS also processes the graph.

In the worst case, the graph can contain `O(n²)` connections.

Therefore:

```text
Time Complexity = O(n²)
```

### Space Complexity

The adjacency list can contain up to `O(n²)` entries in a dense graph.

The visited array requires `O(n)` space.

Therefore:

```text
Space Complexity = O(n²)
```

---

# 🎯 Key Takeaways

* This problem is fundamentally a **Connected Components** problem.
* Each city represents a **node**.
* Each connection represents an **edge**.
* DFS explores one complete connected component.
* Every DFS started from an unvisited city represents **one province**.
* The `visited[]` array prevents repeated traversal.
* The reusable pattern is:

```text
for every node:
    if node is not visited:
        DFS(node)
        components++
```

This pattern is extremely important for graph problems involving:

* Connected components
* Provinces
* Friend groups
* Islands
* Network groups
* Clusters
