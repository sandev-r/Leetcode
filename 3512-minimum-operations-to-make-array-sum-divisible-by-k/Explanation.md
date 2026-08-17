# 3512. Minimum Operations to Make Array Sum Divisible by K

## 🟢 Difficulty

Easy

# 📝 Problem Statement

You are given an integer array `nums` and an integer `k`.

In one operation, you can choose an element of `nums` and decrease it by `1`.

Find the **minimum number of operations** required to make the sum of all elements in `nums` divisible by `k`.

### Example

```text
Input:
nums = [3, 9, 7]
k = 5

Sum = 3 + 9 + 7 = 19

19 % 5 = 4
```

We need to decrease the total sum by `4` to reach `15`, which is divisible by `5`.

Therefore:

```text
Output: 4
```

# 💡 Intuition

The key observation is that **we only care about the total sum**, not which particular elements are decreased.

Suppose:

```text
sum = 19
k = 5
```

The remainder is:

```text
19 % 5 = 4
```

The sum needs to decrease by exactly `4`:

```text
19 → 18 → 17 → 16 → 15
```

That requires `4` operations.

Therefore, the answer is simply:

```text
sum % k
```

### Why?

For any sum:

```text
sum = k × quotient + remainder
```

The remainder tells us exactly how far the sum is from the previous multiple of `k`.

So:

```text
minimum operations = sum % k
```

# 🚀 Approach

### Step 1: Calculate the total sum

Traverse through every element in `nums` and add them together.

```text
sum = nums[0] + nums[1] + ... + nums[n-1]
```

### Step 2: Find the remainder

Calculate:

```text
remainder = sum % k
```

### Step 3: Return the remainder

Each operation decreases the total sum by exactly `1`.

Therefore, decreasing the sum by `remainder` requires exactly `remainder` operations.

```text
answer = sum % k
```

### Step 4: Important observation

We don't need to simulate the individual operations.

For example:

```text
sum = 27
k = 6

27 % 6 = 3
```

The previous multiple of `6` is:

```text
24
```

So we need:

```text
27 → 26 → 25 → 24
```

Exactly `3` operations.

# 🔍 Dry Run

### Input

```text
nums = [3, 9, 7]
k = 5
```

### Execution

| Step  | Element | Current Sum |
| ----- | ------: | ----------: |
| Start |       - |           0 |
| 1     |       3 |           3 |
| 2     |       9 |          12 |
| 3     |       7 |          19 |

Now calculate:

```text
sum % k
= 19 % 5
= 4
```

We need `4` operations:

```text
19 → 18 → 17 → 16 → 15
```

And:

```text
15 % 5 = 0
```

### Final Output

```text
4
```

# ✅ Correctness

Let the total sum of the array be `S`.

When one operation is performed, one element is decreased by `1`, so the total sum also decreases by exactly `1`.

We need the smallest non-negative number of operations `x` such that:

```text
(S - x) % k = 0
```

From the division algorithm:

```text
S = k × q + r
```

where `r = S % k`.

Therefore:

```text
S - r = k × q
```

which is divisible by `k`.

So exactly `r` operations are sufficient.

Since any smaller number than `r` would leave a non-zero remainder, `r` is also the minimum.

Therefore:

```text
minimum operations = S % k
```

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the array once to calculate its sum.

### Space Complexity

```text
O(1)
```

Only a single variable is used to store the sum.

# 🎯 Key Takeaways

* The problem can be reduced to finding the **sum of the array**.
* The required operations are exactly the **remainder of the sum divided by `k`**.
* Formula:

```text
Minimum Operations = sum(nums) % k
```

* There is no need to simulate the decrement operations.
* This is a good example of using **modulo arithmetic to eliminate unnecessary simulation**.
* **Interview Tip:** Whenever a problem asks you to make a value divisible by `k`, immediately check whether the remainder `value % k` gives you the required adjustment.
