# 66. Plus One

## 📝 Problem Summary

You are given an integer represented as an array of digits, where each element contains a single digit. The digits are stored from **most significant** to **least significant**.

Your task is to add **1** to the number and return the updated array of digits.

---

# 💡 Intuition

When adding `1` to a number, the addition always starts from the **last digit**.

- If the current digit is less than `9`, simply increment it and the operation is complete.
- If the current digit is `9`, it becomes `0` and generates a carry to the previous digit.
- Continue this process until the carry stops.
- If every digit is `9`, all digits become `0`, so create a new array with an extra digit and place `1` at the beginning.

---

# 🔍 Key Observation

- A digit smaller than `9` can absorb the carry immediately.
- Only the digit `9` continues the carry.
- If every digit is `9`, the answer needs one extra digit.

---

# 🚀 Approach

1. Traverse the array from the last index to the first.
2. If the current digit is less than `9`:
   - Increment it by `1`.
   - Return the original array immediately.
3. Otherwise:
   - Set the current digit to `0`.
   - Continue to the previous digit.
4. If the loop finishes, every digit was `9`.
5. Create a new array with size `digits.length + 1`.
6. Set the first element to `1`.
7. Return the new array.

---

# 🧪 Dry Run

### Example

**Input**

```text
digits = [1, 2, 9]
```

### Iteration 1

```
i = 2

digits[2] = 9

9 is not less than 9

Set digits[2] = 0
```

Array becomes

```text
[1, 2, 0]
```

---

### Iteration 2

```
i = 1

digits[1] = 2

2 < 9

Increment digits[1]
```

Array becomes

```text
[1, 3, 0]
```

Return the array.

---

### Example 2

**Input**

```text
digits = [9, 9, 9]
```

### Iteration 1

```
Last digit becomes 0
```

```text
[9, 9, 0]
```

### Iteration 2

```
Middle digit becomes 0
```

```text
[9, 0, 0]
```

### Iteration 3

```
First digit becomes 0
```

```text
[0, 0, 0]
```

The loop ends, meaning every digit was `9`.

Create a new array

```text
result = [1, 0, 0, 0]
```

Return the new array.

---

# 📋 Algorithm

1. Start from the last digit.
2. Repeat until the first digit:
   - If the current digit is less than `9`:
     - Increment it by `1`.
     - Return the original array.
   - Otherwise:
     - Change the digit to `0`.
3. If all digits become `0`:
   - Create a new array of size `n + 1`.
   - Set the first element to `1`.
4. Return the new array.

---

# ✅ Why This Works

- Addition always begins from the least significant digit.
- Your solution checks each digit from right to left.
- When a digit is smaller than `9`, increasing it removes the carry, so the answer is ready immediately.
- When the digit is `9`, it becomes `0` and the carry moves to the previous digit.
- If every digit is `9`, the carry reaches beyond the first digit, requiring a new array with a leading `1`.

Thus, the algorithm correctly handles all possible inputs.

---

# ⏱️ Complexity Analysis

### Time Complexity

**O(n)**

- In the worst case (e.g., `[9,9,9]`), every digit is visited once.

### Space Complexity

**O(1)**

- No extra space is used when modifying the original array.

**Worst Case:** **O(n)** when a new array is created because every digit is `9`.

---

# 🎯 Key Takeaways

- Traverse the digits from **right to left**.
- If a digit is less than `9`, increment it and return immediately.
- If a digit is `9`, change it to `0` and continue carrying.
- If all digits are `9`, create a new array with a leading `1`.
- This approach efficiently simulates how addition is performed manually.
