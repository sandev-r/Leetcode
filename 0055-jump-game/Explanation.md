# LeetCode 55 — Jump Game

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums`, where `nums[i]` represents the maximum jump length from index `i`.

You start at index `0` and need to determine whether you can reach the last index.

Return `true` if the last index is reachable; otherwise, return `false`.

### Example

```text
Input:  nums = [2,3,1,1,4]
Output: true
```

From index `0`, you can jump to index `1`, and from there reach the last index.

```text
Input:  nums = [3,2,1,0,4]
Output: false
```

Index `3` has a maximum jump of `0`, so you cannot reach index `4`.

---

## Intuition

Instead of starting from index `0` and trying every possible jump, work **backward from the last index**.

The key question is:

> **Can the current index reach the nearest position that we already know can reach the end?**

Initially, the last index is our `goal`.

For every index from right to left:

```text
if i + nums[i] >= goal
```

then index `i` can reach the current goal.

So we make `i` the new goal.

### Example

```text
nums = [2, 3, 1, 1, 4]
```

Start:

```text
goal = 4
```

Check from right to left:

```text
i = 3
3 + 1 = 4  >= 4
goal = 3
```

Now:

```text
i = 2
2 + 1 = 3  >= 3
goal = 2
```

Then:

```text
i = 1
1 + 3 = 4  >= 2
goal = 1
```

Then:

```text
i = 0
0 + 2 = 2  >= 1
goal = 0
```

Finally:

```text
goal == 0
```

Therefore, the last index is reachable.

---

## Approach

### 1. Set the initial goal

The last index is initially the goal because reaching it means the problem is solved.

```text
goal = nums.length - 1
```

### 2. Traverse from right to left

Start from the second-last index and move toward index `0`.

```text
for i = nums.length - 2 → 0
```

### 3. Check whether the current index can reach the goal

The farthest position reachable from `i` is:

```text
i + nums[i]
```

If:

```text
i + nums[i] >= goal
```

then `i` can reach the goal.

Therefore:

```text
goal = i
```

Now we only need to determine whether an earlier index can reach this new goal.

### 4. Check whether index 0 became the goal

At the end:

```text
goal == 0
```

means index `0` can eventually reach the last index.

Therefore, return:

```text
true
```

Otherwise:

```text
false
```

---

## Complexity

### Time Complexity

```text
O(n)
```

We traverse the array only once from right to left.

### Space Complexity

```text
O(1)
```

Only the `goal` variable is used apart from the input array.

---

## Key Takeaway

**Jump Game can be solved greedily by working backward.**

Instead of asking:

> "How far can I jump from the current position?"

ask:

> **"Can this position reach the nearest position that is already known to reach the end?"**

The important pattern is:

```text
goal = last index

for i from right → left:
    if i + nums[i] >= goal:
        goal = i

return goal == 0
```

This is a **Greedy** solution because we continuously update the goal to the earliest position that can guarantee reaching the end.
