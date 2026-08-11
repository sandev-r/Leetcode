# LeetCode 1431 - Kids With the Greatest Number of Candies

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

You are given an integer array `candies`, where `candies[i]` represents the number of candies the `i-th` child has.

You are also given an integer `extraCandies`.

For each child, determine whether giving **all the extra candies** to that child would make them have the greatest number of candies among all the children.

Return a list of boolean values.

---

# 💡 Intuition

The first thing we need to know is the **maximum number of candies any child currently has**.

Once we know that maximum, we can check every child individually.

For each child:

```text
current candies + extra candies >= maximum candies
```

If this is true, that child can have the greatest number of candies.

The important point is that the child does **not** need to have more candies than the current maximum. Having the **same number** is enough.

---

# 🚀 Approach

We can solve this problem using **two passes** through the array.

### Step 1: Find the maximum

Traverse the `candies` array and find the largest number.

For example:

```text
candies = [2, 3, 5, 1, 3]

maximum = 5
```

We will use `5` as the reference value.

### Step 2: Check every child

Traverse the array again.

For each child, imagine giving them all the extra candies.

```text
new candies = current candies + extraCandies
```

Then compare the result with the maximum:

```text
new candies >= maximum
```

* If true → add `true`
* If false → add `false`

### Step 3: Return the result

After checking every child, return the list containing the boolean result for each child.

---

# 🧠 Dry Run

### Example

**Input:**

```text
candies = [2, 3, 5, 1, 3]
extraCandies = 3
```

### Finding the Maximum

```text
2 → maximum = 2
3 → maximum = 3
5 → maximum = 5
1 → maximum = 5
3 → maximum = 5
```

So:

```text
maximum = 5
```

### Checking Each Child

**Child 1:**

```text
2 + 3 = 5
5 >= 5 → true
```

**Child 2:**

```text
3 + 3 = 6
6 >= 5 → true
```

**Child 3:**

```text
5 + 3 = 8
8 >= 5 → true
```

**Child 4:**

```text
1 + 3 = 4
4 >= 5 → false
```

**Child 5:**

```text
3 + 3 = 6
6 >= 5 → true
```

### Final Output

```text
[true, true, true, false, true]
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse the array twice:

* First pass → find the maximum
* Second pass → check every child

Since `O(n) + O(n)` is still `O(n)`, the overall time complexity is **O(n)**.

### Space Complexity

```text
O(n)
```

The result list stores one boolean value for every child.

The algorithm itself only uses a constant amount of extra space, so the **auxiliary space** excluding the returned result is:

```text
O(1)
```

---

# 🎯 Key Takeaways

* First find the **maximum value** in the array.
* Use that maximum as the reference for every child.
* Check whether `current candies + extraCandies >= maximum`.
* `>=` is important because **tying the maximum is enough**.
* The solution requires two passes and runs in **O(n)** time.
* This is a common array pattern: **find a global maximum/minimum, then compare each element against it**.

**Interview Tip:** When a problem asks whether each element can reach or exceed some target, first check whether that target can be obtained once globally and then reused for every element.
