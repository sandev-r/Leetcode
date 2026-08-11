# LeetCode 238 - Product of Array Except Self

## 🟡 Difficulty

Medium

---

# 📝 Problem Statement

You are given an integer array `nums`.

You need to return an array `answer` such that:

```text
answer[i] = product of every element in nums except nums[i]
```

### Example

```text
Input:
nums = [1, 2, 3, 4]

Output:
[24, 12, 8, 6]
```

Explanation:

```text
answer[0] = 2 × 3 × 4 = 24
answer[1] = 1 × 3 × 4 = 12
answer[2] = 1 × 2 × 4 = 8
answer[3] = 1 × 2 × 3 = 6
```

The solution must be implemented **without using division**.

---

# 💡 Intuition

For every index, the required product can be divided into two parts:

```text
Product Except Self
        =
Left Product × Right Product
```

For example:

```text
nums = [1, 2, 3, 4]

For index 2:

Left side  → 1 × 2
Right side → 4

Answer → (1 × 2) × 4
        = 8
```

So we need to efficiently calculate:

* The product of all elements **before** the current index.
* The product of all elements **after** the current index.

This can be done using **prefix and suffix products**.

---

# 🚀 Approach

## Step 1: Calculate Prefix Products

Traverse the array from **left to right**.

Maintain a variable called `prefix` that stores the product of all elements before the current index.

For:

```text
nums = [1, 2, 3, 4]
```

The prefix products are:

```text
Index:   0   1   2   3
nums:    1   2   3   4
prefix:  1   1   2   6
```

At each index:

```text
output[i] = prefix
```

Then include the current element in the prefix for the next index.

After the first pass:

```text
output = [1, 1, 2, 6]
```

These values represent the product of everything to the **left** of each index.

---

## Step 2: Calculate Suffix Products

Now traverse the array from **right to left**.

Maintain another variable called `suffix`.

It stores the product of all elements after the current index.

For:

```text
nums = [1, 2, 3, 4]
```

The suffix products are:

```text
Index:   0    1   2   3
nums:    1    2   3   4
suffix:  24  12   4   1
```

At each index, multiply the existing prefix product by the suffix product:

```text
output[i] = prefix product × suffix product
```

Then include the current element in the suffix for the next index.

---

# 🔍 Dry Run

Given:

```text
nums = [1, 2, 3, 4]
```

### After Prefix Pass

```text
output = [1, 1, 2, 6]
```

This represents:

```text
index 0 → left product = 1
index 1 → left product = 1
index 2 → left product = 1 × 2 = 2
index 3 → left product = 1 × 2 × 3 = 6
```

---

### Suffix Pass

Start with:

```text
suffix = 1
```

Traverse from right to left.

```text
Index 3:
output[3] = 6 × 1 = 6
suffix = 1 × 4 = 4
```

```text
Index 2:
output[2] = 2 × 4 = 8
suffix = 4 × 3 = 12
```

```text
Index 1:
output[1] = 1 × 12 = 12
suffix = 12 × 2 = 24
```

```text
Index 0:
output[0] = 1 × 24 = 24
```

Final result:

```text
[24, 12, 8, 6]
```

---

# 🧠 Why Prefix + Suffix Works

For every index:

```text
             Current
                ↓
[ 1 | 2 | 3 | 4 ]
  ↑             ↑
Left          Right
Product       Product
```

The current element is never included in either side.

Therefore:

```text
answer[i]
=
product of elements before i
×
product of elements after i
```

This is exactly the product of every element **except `nums[i]`**.

---

# ❌ Why Not Use Division?

A simple approach would be:

```text
totalProduct / nums[i]
```

But this fails when the array contains `0`.

For example:

```text
nums = [1, 2, 0, 4]
```

The total product becomes:

```text
0
```

So division cannot correctly calculate every answer.

The prefix/suffix approach works correctly even when the array contains zeros.

---

# 📌 Important Observation

We do **not** need separate prefix and suffix arrays.

The output array itself can first store the prefix products.

Then, during the second pass, we multiply those values by the suffix product.

So:

```text
First Pass:
output[i] = left product

Second Pass:
output[i] = left product × right product
```

This reduces the extra space required by the algorithm.

---

# ⏱️ Complexity Analysis

### Time Complexity

We traverse the array twice:

```text
First pass  → O(n)
Second pass → O(n)
```

Therefore:

```text
O(n) + O(n) = O(n)
```

**Time Complexity: `O(n)`**

---

### Space Complexity

We only use a few variables besides the required output array.

Therefore, the **auxiliary space** is:

**`O(1)`**

The output array itself requires `O(n)` space.

---

# 🎯 Key Takeaway

The main pattern behind this problem is:

```text
Prefix Product + Suffix Product
```

Remember this formula:

```text
answer[i]
=
Left Product × Right Product
```

Instead of repeatedly calculating products for every index in `O(n²)`, we calculate the left and right products efficiently in two passes.

### Final Complexity

```text
Time  → O(n)
Space → O(1) auxiliary
```

This is an important **prefix/suffix technique** that can also be useful for other array problems where the answer at an index depends on elements on both sides.
