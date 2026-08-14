# 1732. Find the Highest Altitude

## 🟢 Difficulty

Easy

# 📝 Problem Statement

A biker starts their journey at altitude `0`.

The `gain` array represents the **net altitude change** between consecutive points.

* `gain[i]` is the altitude change from point `i` to point `i + 1`.
* A positive value means the altitude increases.
* A negative value means the altitude decreases.

Return the **highest altitude** reached during the journey.

# 💡 Intuition

The altitude at each point depends on the **sum of all previous gains**.

So, instead of calculating every altitude separately, we can maintain:

* `netGain` → the current altitude.
* `highestAltitude` → the highest altitude seen so far.

For every gain:

1. Add it to the current altitude.
2. Compare the current altitude with the highest altitude.
3. Keep the larger value.

The key observation is that this is simply a **prefix sum** problem.

# 🚀 Approach

### Step 1: Initialize the starting altitude

The biker starts at altitude `0`.

Therefore:

* Current altitude = `0`
* Highest altitude = `0`

Initializing the highest altitude to `0` is important because the starting point itself is an altitude that can be the maximum.

### Step 2: Traverse the gain array

Process each altitude change one by one.

For every value:

* Add the gain to `netGain`.
* Update `highestAltitude` if the new altitude is greater.

### Step 3: Track the maximum altitude

At every point, compare:

`current altitude` vs `highest altitude`

Keep the larger value.

### Step 4: Return the answer

After processing the entire array, `highestAltitude` contains the maximum altitude reached during the journey.

# 🔍 Dry Run

### Input

```text
gain = [-5, 1, 5, 0, -7]
```

Starting altitude = `0`

| Gain | Current Altitude | Highest Altitude |
| ---- | ---------------- | ---------------- |
| -5   | -5               | 0                |
| 1    | -4               | 0                |
| 5    | 1                | 1                |
| 0    | 1                | 1                |
| -7   | -6               | 1                |

### Final Output

```text
1
```

The highest altitude reached is **1**.

# ✅ Correctness

At every step, `netGain` represents the biker's current altitude because it stores the sum of all gains processed so far.

`highestAltitude` stores the maximum altitude encountered up to that point.

Since every altitude is checked while traversing the array, the final `highestAltitude` is the highest altitude reached during the entire journey.

Therefore, the algorithm returns the correct answer.

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

The array is traversed exactly once.

### Space Complexity

**O(1)**

Only a constant number of variables are used regardless of the input size.

# 🎯 Key Takeaways

* This problem is a simple **prefix sum** problem.
* Maintain the current value while traversing the array.
* Track the maximum value seen so far.
* Initialize the maximum to `0` because the journey starts at altitude `0`.
* One pass through the array is optimal: **O(n) time and O(1) space**.
