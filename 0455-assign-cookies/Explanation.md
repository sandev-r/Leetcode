# LeetCode 455 - Assign Cookies

## 🟢 Difficulty

**Easy**

---

# 📝 Problem Statement

You are given two integer arrays:

* `g[i]` represents the greed factor of the `i-th` child.
* `s[j]` represents the size of the `j-th` cookie.

A child can be satisfied if the size of the cookie given to them is greater than or equal to their greed factor.

Each child can receive at most one cookie, and each cookie can be given to at most one child.

Return the **maximum number of children that can be satisfied**.

---

# 💡 Intuition

The main goal is to satisfy the **maximum number of children**, not necessarily to use every cookie.

The best strategy is to match each child with the **smallest cookie that can satisfy them**.

Why?

Suppose a child needs a cookie of size `2`, and we have cookies of sizes `2` and `5`.

If we give the child the cookie of size `5`, the cookie of size `2` is wasted unnecessarily.

Instead:

```text
Child needs 2
        ↓
Give cookie 2
        ↓
Save cookie 5 for a child with higher greed
```

Therefore, after sorting both arrays, we can greedily match the smallest possible cookie with the least greedy child.

---

# 🚀 Approach

### Step 1 — Sort Both Arrays

Sort the greed factors and cookie sizes in ascending order.

```text
g = [1, 2, 3]
s = [1, 1, 2]
```

Now the smallest requirements and smallest resources are available first.

---

### Step 2 — Use Two Pointers

Maintain two pointers:

```text
ptrG → current child
ptrS → current cookie
```

Initially:

```text
ptrG = 0
ptrS = 0
```

---

### Step 3 — Compare Child and Cookie

Check whether the current cookie can satisfy the current child.

```text
s[ptrS] >= g[ptrG]
```

If true:

```text
Child is satisfied
```

Move both pointers:

```text
ptrG++
ptrS++
```

---

### Step 4 — Cookie Is Too Small

If:

```text
s[ptrS] < g[ptrG]
```

the current cookie cannot satisfy the current child.

Because the cookies are sorted, this cookie cannot satisfy the current child or any child with a higher greed factor.

So discard the cookie:

```text
ptrS++
```

The child remains the same.

---

### Step 5 — Continue Until One Array Ends

Continue comparing cookies and children until:

```text
ptrG == g.length
```

or

```text
ptrS == s.length
```

The value of `ptrG` represents the number of children successfully satisfied.

---

# 🧠 Dry Run

### Input

```text
g = [1, 2, 3]
s = [1, 1]
```

Both arrays are already sorted.

```text
Children: [1, 2, 3]
Cookies:  [1, 1]
```

### Step 1

```text
Child greed = 1
Cookie size = 1

1 >= 1 → Satisfied
```

Move both pointers:

```text
ptrG = 1
ptrS = 1
```

Satisfied children:

```text
1
```

---

### Step 2

```text
Child greed = 2
Cookie size = 1

1 < 2 → Cannot satisfy
```

Discard the cookie.

```text
ptrS = 2
```

No cookies remain.

Therefore:

```text
Answer = 1
```

### Visual Trace

```text
g = [1, 2, 3]
      ↑
    ptrG

s = [1, 1]
      ↑
    ptrS

1 >= 1
↓
Match
↓
ptrG++, ptrS++

g = [1, 2, 3]
         ↑
       ptrG

s = [1, 1]
         ↑
       ptrS

1 < 2
↓
Cookie too small
↓
ptrS++

No cookies left

Answer = 1
```

---

# ⏱️ Complexity Analysis

### Time Complexity

Sorting the children:

```text
O(n log n)
```

Sorting the cookies:

```text
O(m log m)
```

Two-pointer traversal:

```text
O(n + m)
```

Therefore:

```text
O(n log n + m log m)
```

---

### Space Complexity

The algorithm uses only two pointers and a few variables.

Therefore, the auxiliary space complexity is:

```text
O(1)
```

excluding the internal space used by the sorting algorithm.

---

# 🎯 Key Takeaways

* **Greedy Algorithm:** Make the best choice available at the current moment.
* **Sorting:** Put children and cookies in increasing order so the smallest useful match can be found.
* **Two Pointers:** Use one pointer for children and another for cookies.
* If a cookie is **too small**, discard it.
* If a cookie **satisfies the child**, use it and move both pointers.
* The core greedy rule is:

> **Use the smallest cookie that can satisfy the least greedy child.**

This prevents larger cookies from being wasted and maximizes the number of satisfied children.
