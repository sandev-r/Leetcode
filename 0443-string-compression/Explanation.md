# LeetCode 443 - String Compression

## 🟢 Difficulty

**Medium**

---

# 📝 Problem Statement

You are given an array of characters `chars`.

Compress the array **in-place** using the following rules:

* Consecutive repeated characters should be written only once.
* If a character appears more than once consecutively, write the character followed by its frequency.
* The frequency may contain multiple digits.
* The compressed result must be stored directly inside the original array.
* Return the length of the compressed portion of the array.

For example:

* `["a","a","b","b","c","c","c"]` → `["a","2","b","2","c","3"]`
* `["a"]` → `["a"]`
* `["a","b","b","b","b","b","b","b","b","b","b","b"]` → `["a","b","1","1"]`

The important constraint is that the compression must happen **in-place**.

---

# 💡 Intuition

The main challenge is that we need to do two things at the same time:

1. **Read the original array** and identify groups of consecutive characters.
2. **Write the compressed result** back into the same array.

A useful way to think about this is with **two responsibilities**:

* `i` → points to the beginning of the current group.
* `j` → scans forward to find where the current group ends.
* `k` → tells us where to write the compressed result.

So the array is being processed like this:

**Read → Count → Write → Move to next group**

For every group:

> Find how many times the character appears consecutively → write the character → write its count if the count is greater than 1.

The key idea is that `j` can move ahead while `k` writes behind it.

This allows us to modify the same array without creating another result array.

---

# 🚀 Approach

### 1. Handle very small arrays

If the array contains zero or one character, it is already compressed.

Return its length immediately.

---

### 2. Initialize three pointers

We use three variables:

* `i` → beginning of the current group.
* `j` → scans the group and finds its ending position.
* `k` → position where the compressed result should be written.

Initially:

* `i = 0`
* `j = 1`
* `k = 0`

---

### 3. Find the complete group

Starting from `j`, keep moving forward while:

* `j` is inside the array.
* `chars[i]` is equal to `chars[j]`.

This means all characters between `i` and `j - 1` belong to the same group.

When this loop stops:

* `i` → first character of the group.
* `j` → position immediately after the group.

---

### 4. Calculate the group size

The number of occurrences is:

**count = j - i**

For example, if a group occupies indices `2` through `4`:

* `i = 2`
* `j = 5`

Therefore:

**count = 5 - 2 = 3**

---

### 5. Write the character

Write the group's character at position `k`.

Then move `k` forward.

This stores one copy of the character in the compressed result.

---

### 6. Write the count only when necessary

If `count > 1`, the frequency must also be written.

The count can contain multiple digits.

For example:

* `2` → write `"2"`
* `9` → write `"9"`
* `12` → write `"1"` then `"2"`

The count is converted into characters, and each digit is written into the array starting from `k`.

---

### 7. Move to the next group

After processing the current group:

**i = j**

Now `i` points to the first character of the next group.

The process continues until `j` reaches the end of the array.

---

### 8. Return the compressed length

`k` always represents the number of characters written into the compressed portion.

Therefore, return `k`.

---

# 🧠 Dry Run

### Example

**Input:**

`["a","a","b","b","c","c","c"]`

### Initial State

| Variable | Value |
| -------- | ----: |
| `i`      |     0 |
| `j`      |     1 |
| `k`      |     0 |

---

### Step 1 — Process `"aa"`

`i = 0`

`j` moves while the characters are equal:

* `chars[0] = 'a'`
* `chars[1] = 'a'`

Then `j = 2`.

So:

**count = j - i = 2 - 0 = 2**

Write:

* `'a'`
* `'2'`

Compressed portion:

`["a","2"]`

Now:

* `k = 2`
* `i = j = 2`

---

### Step 2 — Process `"bb"`

| Variable | Value |
| -------- | ----: |
| `i`      |     2 |
| `j`      |     3 |
| `k`      |     2 |

`j` moves to `4`.

Therefore:

**count = 4 - 2 = 2**

Write:

`'b'`, `'2'`

Compressed portion:

`["a","2","b","2"]`

Now:

* `k = 4`
* `i = 4`

---

### Step 3 — Process `"ccc"`

| Variable | Value |
| -------- | ----: |
| `i`      |     4 |
| `j`      |     5 |
| `k`      |     4 |

`j` moves:

`5 → 6 → 7`

Now:

**count = 7 - 4 = 3**

Write:

`'c'`, `'3'`

Compressed portion:

`["a","2","b","2","c","3"]`

Now:

* `k = 6`
* `i = 7`

`j` has reached the end.

---

### Final Result

| Original Array  | Compressed Array |
| --------------- | ---------------- |
| `a a b b c c c` | `a 2 b 2 c 3`    |

**Final Output: `6`**

Only the first `6` positions contain the compressed result.

---

# ✅ Correctness

The algorithm correctly compresses every consecutive group because:

1. `i` always points to the first character of the current group.
2. `j` moves until the current group ends, so `j - i` gives the exact number of consecutive occurrences.
3. The character is always written once.
4. The count is written only when the group contains more than one character.
5. After processing a group, `i` is moved to `j`, so every character belongs to exactly one group.
6. `k` records exactly how many characters have been written into the compressed portion.

Therefore, after processing the entire array, the first `k` positions contain the correct compressed representation.

---

# ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

Each character is scanned by the `j` pointer at most once.

Writing the compressed result also takes at most `O(n)` time.

Therefore, the overall time complexity is **O(n)**.

### Space Complexity

```text
O(log n)
```

The algorithm does not create another array.

However, the count is temporarily converted into a `String`. The number of digits in a count can be at most `O(log n)`.

Therefore, for this specific Java implementation, the auxiliary space is **O(log n)**.

The in-place array itself does not count as extra space.

---

# 🎯 Key Takeaways

* **Two-pointer scanning + write pointer** is the core pattern.

* `i` identifies where a group starts.

* `j` finds where the group ends.

* `k` writes the compressed result.

* `j` can move ahead while `k` writes behind it.

* The original array can therefore be modified **in-place**.

* Always calculate a group's frequency using:

  `count = j - i`

* Counts with multiple digits must be written digit by digit.

* The returned value is the **compressed length**, not the number of groups.

* **Interview Tip:** Whenever a problem asks you to modify an array in-place while reading its original contents, immediately consider a **read pointer + write pointer** strategy.
