# LeetCode 1971 - Find if Path Exists in Graph

## 🟢 Difficulty

Easy

# 📝 Problem Statement

You are given an undirected graph with `n` vertices numbered from `0` to `n - 1`.

You are also given:

* `edges[i] = [u, v]`, representing an undirected edge between vertices `u` and `v`.
* `source` — the starting vertex.
* `destination` — the target vertex.

Return `true` if there is a valid path from `source` to `destination`.

Otherwise, return `false`.

### Example

```text
n = 3
edges = [[0,1], [1,2]]
source = 0
destination = 2
```

Graph:

```text
0 ─── 1 ─── 2
```

There is a path:

```text
0 → 1 → 2
```

Therefore:

```text
true
```

# 💡 Intuition

The problem is simply asking:

> "Can I reach the destination vertex starting from the source vertex?"

This is a classic **Graph Traversal** problem.

We can start from the `source` and explore every vertex that can be reached from it.

There are two common ways to do this:

```text
DFS → Depth-First Search
BFS → Breadth-First Search
```

Here, we use **DFS**.

The idea is:

```text
source
  ↓
visit its neighbors
  ↓
visit their neighbors
  ↓
continue exploring
  ↓
destination found?
```

Because the graph is **undirected**, every edge connects both directions.

For example:

```text
0 ─── 1
```

means:

```text
0 → 1
1 → 0
```

Therefore, we need to store both directions in the adjacency list.

# 🔑 Key Observation

The graph can contain cycles.

For example:

```text
0 ─── 1
│     │
└─────┘
```

If we don't keep track of visited vertices, DFS can repeatedly travel:

```text
0 → 1 → 0 → 1 → 0 → ...
```

Therefore, we maintain:

```text
boolean[] visited
```

Whenever we visit a vertex:

```text
visited[node] = true
```

This guarantees that every vertex is processed at most once.

# 🚀 Approach

### Step 1: Create the Adjacency List

Create an adjacency list containing `n` vertices.

Initially:

```text
0 → []
1 → []
2 → []
...
```

For every edge `[u, v]`, add both connections:

```text
u → v
v → u
```

For:

```text
edges = [[0,1], [1,2]]
```

we get:

```text
0 → [1]
1 → [0,2]
2 → [1]
```

---

### Step 2: Create the Visited Array

Create:

```text
visited[n]
```

Initially:

```text
false false false
```

This prevents DFS from visiting the same vertex repeatedly.

---

### Step 3: Start DFS from Source

Start DFS at:

```text
source
```

Mark the current vertex as visited.

Then check:

```text
Is current vertex == destination?
```

If yes:

```text
return true
```

Otherwise, explore every unvisited neighbor.

---

### Step 4: Recursively Explore Neighbors

For every neighbor:

```text
if neighbor is not visited
```

perform DFS on that neighbor.

Conceptually:

```text
DFS(current)
    ↓
mark current visited
    ↓
is current destination?
    ↓
   YES → true
    ↓
   NO
    ↓
explore every unvisited neighbor
```

---

### Step 5: Destination Not Found

If DFS finishes exploring the entire reachable component without finding the destination:

```text
return false
```

# 🧠 Dry Run

Consider:

```text
n = 6

edges = [
    [0,1],
    [0,2],
    [1,3],
    [2,4]
]

source = 0
destination = 4
```

Graph:

```text
      1 ─── 3
     /
    0
     \
      2 ─── 4
```

Start:

```text
DFS(0)
```

### Step 1

Visit `0`:

```text
visited = [T, F, F, F, F, F]
```

Neighbors:

```text
1, 2
```

Take `1`.

### Step 2

Visit `1`:

```text
visited = [T, T, F, F, F, F]
```

Neighbor `0` is already visited.

Explore `3`.

### Step 3

Visit `3`:

```text
visited = [T, T, F, T, F, F]
```

No useful unvisited neighbors.

Backtrack to `0`.

### Step 4

Explore neighbor `2`.

Visit `2`:

```text
visited = [T, T, T, T, F, F]
```

Explore neighbor `4`.

### Step 5

Visit `4`:

```text
visited = [T, T, T, T, T, F]
```

Now:

```text
current == destination
4 == 4
```

Therefore:

```text
true
```

The path found is:

```text
0 → 2 → 4
```

# ✅ Why This Works

DFS explores every vertex that can be reached from the `source`.

There are two possible situations:

### Case 1: Destination is reachable

DFS eventually visits `destination`.

Therefore:

```text
destination found
→ true
```

### Case 2: Destination is unreachable

DFS completely explores the connected component containing `source`.

If `destination` was never visited, there is no path from `source` to `destination`.

Therefore:

```text
destination not found
→ false
```

The `visited` array ensures that cycles do not cause infinite recursion.

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(V + E)
```

Where:

* `V` = number of vertices
* `E` = number of edges

Every vertex and edge is processed at most a constant number of times.

### Space Complexity

```text
O(V + E)
```

The adjacency list requires `O(V + E)` space.

The `visited` array requires `O(V)` additional space, and DFS recursion can use up to `O(V)` stack space.

# 🎯 Key Takeaways

* LeetCode 1971 is a **basic graph traversal problem**.
* Use an **adjacency list** to represent the graph.
* Because the graph is undirected, add every edge in **both directions**.
* Use **DFS or BFS** to search for the destination.
* Always use a **visited array** when traversing a graph that may contain cycles.
* The fundamental graph pattern is:

```text
Build Graph
    ↓
Choose Starting Node
    ↓
Traverse Using DFS/BFS
    ↓
Track Visited Nodes
    ↓
Find Destination
```

* The most important concept to learn from this problem is not the specific question—it is recognizing **"Can I reach X from Y?" as a graph traversal problem**.
