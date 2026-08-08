# LeetCode 605 — Can Place Flowers

## Problem

You are given a flowerbed represented by an integer array:

* `0` → empty plot
* `1` → plot already containing a flower

You need to determine whether `n` new flowers can be planted without violating the rule that **no two flowers can be placed in adjacent plots**.

Return `true` if all `n` flowers can be planted; otherwise, return `false`.

---

## Approach

### Greedy Approach

The key observation is that whenever we find an empty position whose **left and right positions are also empty**, we can safely plant a flower there.

For each position:

* Check the left neighbor.
* Check the current position.
* Check the right neighbor.
* If all three are empty, place a flower.
* Increase the number of flowers planted.

The important part is that after planting a flower, the array is immediately updated.

This prevents the next position from incorrectly being considered available.

---

## Why Greedy Works

When a position is currently safe for planting, placing a flower there cannot reduce the optimal number of flowers that can be planted later.

In fact, planting as early as possible is beneficial because it occupies the current valid position while leaving the maximum possible space for the remaining positions.

For example:

```text
Flowerbed:
0 0 0 0 0

Plant at index 0:

1 0 0 0 0

Then index 1 cannot be used.

Index 2 can be used:

1 0 1 0 0
```

The greedy decision produces the maximum possible number of flowers.

---

## Boundary Handling

The first and last positions do not have two neighbors.

We treat the missing neighbor as an empty position:

```text
First position:
[0] [0]
 ↑    ↑
left right

Last position:
[0] [0]
 ↑    ↑
left right
```

So:

* For index `0`, the left side is considered `0`.
* For the last index, the right side is considered `0`.

This allows the same logic to work for every position without separate planting conditions.

---

## Algorithm

1. If `n == 0`, return `true` immediately.
2. Initialize a counter `count = 0`.
3. Traverse every position in the flowerbed.
4. Determine the left neighbor:

   * If it is the first position, treat it as `0`.
   * Otherwise, use the previous element.
5. Determine the right neighbor:

   * If it is the last position, treat it as `0`.
   * Otherwise, use the next element.
6. If:

   * left is `0`
   * current position is `0`
   * right is `0`

   then:

   * plant a flower by changing the current position to `1`
   * increment `count`
7. If `count == n`, return `true`.
8. After checking the entire flowerbed, return `false`.

---

## Example

### Input

```text
flowerbed = [1,0,0,0,1]
n = 1
```

### Traversal

```text
Index 0
[1,0,0,0,1]
```

Already occupied → cannot plant.

```text
Index 1
[1,0,0,0,1]
```

Left = `1` → cannot plant.

```text
Index 2
[1,0,0,0,1]
      ↑
```

Left = `0`
Current = `0`
Right = `0`

So we can plant:

```text
[1,0,1,0,1]
```

`count = 1`

Since:

```text
count == n
1 == 1
```

Return:

```text
true
```

---

## Example 2

### Input

```text
flowerbed = [1,0,0,0,1]
n = 2
```

Only index `2` can be used.

After planting:

```text
[1,0,1,0,1]
```

Only `1` flower was planted, but `2` were required.

Therefore:

```text
false
```

---

## Important Edge Cases

### `n = 0`

No flowers need to be planted.

Therefore, the answer is immediately:

```text
true
```

### Single Empty Plot

```text
[0]
```

One flower can be planted because both missing neighbors are treated as empty.

### Single Occupied Plot

```text
[1]
```

No flower can be planted.

### Completely Empty Flowerbed

```text
[0,0,0,0,0]
```

Flowers can be planted at indices:

```text
0, 2, 4
```

So the maximum is `3`.

---

## Time Complexity

**O(n)**

The flowerbed is traversed once.

Each position requires only a constant number of operations.

---

## Space Complexity

**O(1)**

Only a few variables are used regardless of the size of the flowerbed.

The input array is modified in-place, but no additional data structure is created.

---

## Key Takeaway

This is a classic **Greedy + Array Traversal** problem.

The core idea is:

> **Whenever the current position and both neighbors are empty, plant immediately.**

Because the decision is made locally and the flowerbed is updated immediately, each planting decision automatically affects the next positions.

### Pattern to Remember

```text
Check neighbors
      ↓
Can plant?
   ↙     ↘
 Yes      No
  ↓        ↓
Plant    Move on
  ↓
Count++
```

This same **local decision → immediately update → continue traversal** pattern appears frequently in greedy array problems.
