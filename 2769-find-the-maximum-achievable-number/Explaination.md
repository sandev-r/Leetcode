# LeetCode 2769 - Find the Maximum Achievable Number

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

You are given two integers `num` and `t`.

You can perform the following operation exactly `t` times:

* Increase or decrease `num` by `1`.

Your goal is to find the **maximum number** that can be achieved after performing exactly `t` operations.

---

# 💡 Intuition

Each operation can increase the number by at most `1`.

To get the maximum possible value, we should **increase `num` by `1` in every operation**.

For example:

```text
num = 4
t = 3

4 → 5 → 6 → 7
```

After 3 operations, the maximum achievable number is `7`.

Therefore, the answer is simply:

```text
num + (2 × t)
```

Wait — there is an important detail in the problem: each operation allows changing the number by `1`, but the problem's definition of an operation lets us choose either adding or subtracting `1` from the current value. To maximize the final value, we add `1` each time.

So the result is:

```text
num + t
```

---

# 🚀 Approach

1. Start with the given value `num`.
2. We need to perform exactly `t` operations.
3. Every operation can increase the current value by `1`.
4. Since we want the maximum possible value, increase `num` during every operation.
5. Therefore, the maximum achievable number is `num + t`.

---

# 🧠 Dry Run

Example:

Input

```text
num = 4
t = 3
```

### Execution

```text
Initial value:
4

Iteration 1:
4 + 1 = 5

Iteration 2:
5 + 1 = 6

Iteration 3:
6 + 1 = 7
```

### Final Output

```text
7
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(1)
```

We perform only a single arithmetic calculation.

### Space Complexity

```text
O(1)
```

No additional data structures are required.

---

# 🎯 Key Takeaways

* To maximize the number, increase `num` in every operation.
* Each operation contributes `+1` to the final value.
* The answer is `num + t`.
* This is a simple mathematical problem; no loop or data structure is necessary.
* **Interview tip:** Before writing code, look for a direct mathematical relationship between the input and the required result.
