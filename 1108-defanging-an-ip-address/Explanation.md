# LeetCode 1108 - Defanging an IP Address

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

You are given a valid IPv4 address as a string.

Your task is to **defang** the IP address by replacing every `.` with `[.]`.

For example:

```text
Input:  "1.1.1.1"
Output: "1[.]1[.]1[.]1"
```

In simple terms, find every dot (`.`) in the IP address and change it to `[.]`.

---

# 💡 Intuition

The important thing to notice is that an IPv4 address contains dots separating its four parts.

We don't need to perform any complicated calculation.

We simply:

* Traverse the string character by character.
* If the character is `.`, append `[.]`.
* Otherwise, append the character as it is.

A `StringBuilder` is useful because we are constructing a new string while traversing the input.

---

# 🚀 Approach

1. Create a `StringBuilder` to store the resulting string.
2. Traverse every character of the given IP address.
3. Check the current character:

   * If it is `.`, append `[.]`.
   * Otherwise, append the character unchanged.
4. Return the constructed string.

This directly transforms the input into the required defanged format.

---

# 🧠 Dry Run

### Example

Input

```text
address = "1.1.1.1"
```

### Execution

```text
Iteration 1
Character = '1'
Not a dot → append '1'

StringBuilder = "1"
```

```text
Iteration 2
Character = '.'
It is a dot → append "[.]"

StringBuilder = "1[.]"
```

```text
Iteration 3
Character = '1'
Not a dot → append '1'

StringBuilder = "1[.]1"
```

```text
Iteration 4
Character = '.'
It is a dot → append "[.]"

StringBuilder = "1[.]1[.]"
```

```text
Iteration 5
Character = '1'
Not a dot → append '1'

StringBuilder = "1[.]1[.]1"
```

```text
Iteration 6
Character = '.'
It is a dot → append "[.]"

StringBuilder = "1[.]1[.]1[.]"
```

```text
Iteration 7
Character = '1'
Not a dot → append '1'

StringBuilder = "1[.]1[.]1[.]1"
```

### Final Output

```text
"1[.]1[.]1[.]1"
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

We traverse every character of the IP address exactly once, where `n` is the length of the input string.

### Space Complexity

```text
O(n)
```

The `StringBuilder` stores the resulting defanged IP address.

---

# 🎯 Key Takeaways

* Traverse the string character by character.
* Replace every `.` with `[.]`.
* `StringBuilder` is efficient for constructing the result.
* This is a simple **string traversal and transformation** problem.
* **Interview tip:** When a problem asks you to modify or transform characters in a string, first consider a single-pass traversal with a `StringBuilder`.
