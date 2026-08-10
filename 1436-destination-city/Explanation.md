# 1436. Destination City

## Problem

You are given a list of paths where each path contains two cities:

* `path[0]` → starting city
* `path[1]` → destination city

A **destination city** is a city that never appears as a starting city of any path.

Return the destination city.

### Example

```text
Input:
paths = [["London","New York"],
         ["New York","Lima"],
         ["Lima","Sao Paulo"]]

Output:
"Sao Paulo"
```

Explanation:

* London → New York
* New York → Lima
* Lima → Sao Paulo
* `Sao Paulo` never appears as a starting city, so it is the destination city.

---

## Approach

The key observation is:

> The destination city is the only city that appears as a destination but never appears as a starting city.

We can solve this using a `HashSet`.

### Step 1: Store all starting cities

Traverse every path and add its starting city to a `HashSet`.

For example:

```text
London → New York
New York → Lima
Lima → Sao Paulo
```

The set becomes:

```text
{London, New York, Lima}
```

The `HashSet` allows us to check whether a city is a starting city in **O(1)** average time.

---

### Step 2: Check every destination city

Traverse the paths again.

For each path:

```text
starting city → destination city
```

Check whether the destination city exists in the set of starting cities.

* If it exists → this city is used as a starting point, so it is not the final destination.
* If it does not exist → this city is the destination city.

For the example:

```text
London → New York
              ↓
        exists in set ✓

New York → Lima
              ↓
        exists in set ✓

Lima → Sao Paulo
          ↓
    not in set ✗
```

Therefore:

```text
Sao Paulo
```

is returned.

---

## Why This Works

Every city that is part of an intermediate route must eventually appear as a starting city.

The final destination is different:

```text
A → B
B → C
C → D
```

Here:

* `A` is a starting city.
* `B` is both a destination and a starting city.
* `C` is both a destination and a starting city.
* `D` is only a destination.

Therefore, the city that **never appears on the left side of any path** must be the final destination.

---

## Dry Run

Consider:

```text
paths = [
    ["B", "C"],
    ["D", "B"],
    ["C", "A"]
]
```

### Build the starting-city set

Process each path:

```text
B → C    → add B
D → B    → add D
C → A    → add C
```

Set:

```text
{B, D, C}
```

### Find the destination

Check each destination:

```text
C → C exists in set
B → B exists in set
A → A does not exist in set
```

Therefore:

```text
Answer = A
```

---

## Complexity Analysis

Let `n` be the number of paths.

### Time Complexity

We traverse the paths twice:

* First traversal → `O(n)`
* Second traversal → `O(n)`

Therefore:

```text
O(n)
```

### Space Complexity

The `HashSet` stores all starting cities.

In the worst case, there can be `n` unique starting cities:

```text
O(n)
```

---

## Key Takeaway

The important insight is to **reverse the way you think about the problem**.

Instead of trying to follow the paths one by one, ask:

> "Which destination city is never used as a starting city?"

Using a `HashSet` makes this lookup efficient and gives an overall **O(n) time and O(n) space** solution.
