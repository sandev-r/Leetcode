# 2235. Add Two Integers

## 📝 Problem Summary

You are given two integers, `num1` and `num2`.

Your task is to return their sum.

---

## 💡 Intuition

The problem is straightforward. We already have the two numbers, so all we need to do is add them together using the `+` operator and return the result.

No loops, conditions, or extra data structures are needed.

---

## 🔍 Key Observation

- The answer is simply:
  
  ```
  num1 + num2
  ```

- Since both inputs are integers, a single addition operation gives the correct answer.

---

## 🚀 Approach

1. Receive the two integers `num1` and `num2`.
2. Add them using the `+` operator.
3. Return the sum.

---

## 🧪 Dry Run

### Example 1

**Input**

```text
num1 = 12
num2 = 5
```

**Execution**

| Step | Action | Result |
|------|--------|--------|
| 1 | Read `num1` | 12 |
| 2 | Read `num2` | 5 |
| 3 | Compute `12 + 5` | 17 |
| 4 | Return the result | **17** |

**Output**

```text
17
```

---

### Example 2

**Input**

```text
num1 = -10
num2 = 4
```

**Execution**

| Step | Action | Result |
|------|--------|--------|
| 1 | Read `num1` | -10 |
| 2 | Read `num2` | 4 |
| 3 | Compute `-10 + 4` | -6 |
| 4 | Return the result | **-6** |

**Output**

```text
-6
```

---

## 📌 Algorithm

1. Take the inputs `num1` and `num2`.
2. Compute `num1 + num2`.
3. Return the computed value.

---

## ✅ Why This Works

The problem only asks for the sum of two integers.

Using the addition (`+`) operator directly computes the required result, making the solution correct for every valid input.

---

## 📊 Complexity Analysis

| Complexity | Value |
|------------|-------|
| **Time Complexity** | **O(1)** |
| **Space Complexity** | **O(1)** |

**Reason:**

- Only one addition operation is performed.
- No extra memory or data structures are used.

---

## 🎯 Key Takeaways

- This is a basic implementation problem.
- Use the `+` operator to add two integers.
- No loops or conditional statements are required.
- A direct solution is both the simplest and the most efficient.

---
