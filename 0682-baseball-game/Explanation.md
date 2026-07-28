# LeetCode 682 - Baseball Game

## 🟢 Difficulty
Easy

---

# 📝 Problem Statement

You are keeping track of scores in a baseball game.

Initially, there is an empty record of scores. You are given an array of strings called `operations`, where each element represents an operation.

Each operation can be:

- **Integer** → Add a new score to the record.
- **"+"** → Add a new score equal to the sum of the previous two scores.
- **"D"** → Add a new score equal to double the previous score.
- **"C"** → Remove the previous score.

Return the sum of all valid scores after performing every operation.

---

# 💡 Intuition

The problem always asks us to work with the **most recent scores**.

Notice that every operation depends only on the latest one or two scores:

- `"C"` removes the latest score.
- `"D"` doubles the latest score.
- `"+"` uses the latest two scores.
- A number simply becomes the latest score.

This is exactly how a **Stack** works because it allows us to:

- Add a new score (`push`)
- Remove the latest score (`pop`)
- View the latest score (`peek`)

Instead of storing every score and calculating the total at the end, we maintain a running `sum` while processing each operation. Whenever we add or remove a score, we immediately update the sum.

This avoids iterating through the stack again.

---

# 🔍 Approach

1. Create a stack to store all valid scores.
2. Maintain a variable `sum` to store the total score.
3. Traverse every operation:
   - If the operation is `"C"`:
     - Remove the latest score from the stack.
     - Subtract it from `sum`.
   - If the operation is `"D"`:
     - Double the top score.
     - Push it into the stack.
     - Add it to `sum`.
   - If the operation is `"+"`:
     - Temporarily remove the latest score.
     - Read the second latest score.
     - Restore the removed score.
     - Compute the new score as the sum of the last two scores.
     - Push the new score.
     - Add it to `sum`.
   - Otherwise:
     - Convert the string into an integer.
     - Push it into the stack.
     - Add it to `sum`.
4. Return `sum`.

---

# 🧪 Dry Run

### Input

```text
operations = ["5","2","C","D","+"]
```

| Operation | Stack | Sum |
|-----------|-------|-----|
| "5" | [5] | 5 |
| "2" | [5, 2] | 7 |
| "C" | [5] | 5 |
| "D" | [5, 10] | 15 |
| "+" | [5, 10, 15] | 30 |

### Output

```text
30
```

---

# 🎯 Why This Works

The stack always keeps the valid scores in their correct order.

- **"C"** removes the latest score.
- **"D"** uses the latest score.
- **"+"** uses the latest two scores.
- Integers are simply added as new scores.

Because every operation only depends on the most recent scores, the stack perfectly models the game's score history.

Keeping a running `sum` makes the solution more efficient since we never need to iterate over the stack again.

---

# ⏱️ Complexity Analysis

### Time Complexity

- Each operation is processed exactly once.
- Every stack operation (`push`, `pop`, `peek`) takes **O(1)**.

**Overall Time Complexity: O(n)**

where **n** is the number of operations.

---

### Space Complexity

The stack stores all valid scores.

In the worst case, every operation is an integer.

**Space Complexity: O(n)**

---

# 📚 Key Concepts Learned

- Stack (LIFO)
- ArrayDeque as Stack in Java
- Push, Pop, Peek operations
- Maintaining a running sum
- Processing operations sequentially
- Simulation problems

---

# ✅ Takeaways

- Whenever a problem repeatedly works with the **latest element**, think about using a **Stack**.
- Maintaining additional information (like a running sum) can eliminate unnecessary traversals.
- `ArrayDeque` is preferred over `Stack` in Java because it provides better performance.
- Simulation problems often become simple once the correct data structure is identified.
