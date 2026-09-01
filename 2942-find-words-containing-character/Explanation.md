# LeetCode 2942 - Find Words Containing Character

## 🟢 Difficulty

Easy

---

# 📝 Problem Statement

You are given an array of strings `words` and a character `x`.

Your task is to find all the indices of strings that contain the character `x` at least once.

Return the indices in increasing order.

---

# 💡 Intuition

The problem is straightforward:

* Check every word in the array.
* See whether the character `x` exists in that word.
* If it exists, store that word's index.
* Return all collected indices.

Since we only need to know whether a character is present, Java's `indexOf()` method is enough.



---

# 🚀 Approach

1. Create an empty list to store the answer.
2. Iterate through the `words` array using an index `i`.
3. For each word, check whether it contains character `x`.
4. If `x` is found, add `i` to the result list.
5. After checking all words, return the list.

---

# 🧠 Dry Run

### Input

```text
words = ["leet", "code"]
x = 'e'
```

### Execution

```text
Iteration 1:
i = 0
words[0] = "leet"
'e' is present → add 0

Iteration 2:
i = 1
words[1] = "code"
'e' is present → add 1
```

### Final Output

```text
[0, 1]
```

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n × m)
```

Where:

* `n` = number of words
* `m` = average length of a word

In the worst case, we may scan every character of every word.

### Space Complexity

```text
O(k)
```

Where `k` is the number of indices stored in the result.

---

# 🎯 Key Takeaways

* Traverse each element when you need to check a condition on every item.
* `indexOf()` can efficiently check whether a character exists in a string.
* Store the index only when the required condition is satisfied.
* Always distinguish between input traversal complexity and output space complexity.
