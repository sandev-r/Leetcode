# 3838. Map Word Weights

**Difficulty:** Easy

## Problem Statement

You are given an array of strings `words` and an integer array `weights` of size `26`, where each index represents the weight of a lowercase English letter from `'a'` to `'z'`.

For each word:

1. Calculate the sum of the weights of all its characters.
2. Take the sum modulo `26`.
3. Convert the result into a character using reverse alphabetical mapping.
4. Append the generated character to the final result.

Return the resulting string.

---

## Intuition

Each character in a word has a corresponding weight stored in the `weights` array.

Since the letters are lowercase English characters, we can find the weight of a character using:

`c - 'a'`

This converts:

* `'a'` → `0`
* `'b'` → `1`
* ...
* `'z'` → `25`

After calculating the total weight of a word, we use modulo `26` to keep the value within the range of the English alphabet.

Finally, instead of mapping normally from `'a'`, we map in reverse starting from `'z'`:

`'z' - sum`

The generated character for each word is appended to the result.

---

## Approach

For every word in `words`:

1. Initialize `sum = 0`.
2. Traverse every character in the word.
3. Find its corresponding index using `c - 'a'`.
4. Add the character's weight from the `weights` array to `sum`.
5. Calculate `sum % 26`.
6. Convert the value into a character using reverse alphabetical mapping:
   `('z' - sum)`.
7. Append the character to the result.

After processing all words, return the final string.

---

## Complexity

Let `N` be the total number of characters across all words.

* **Time Complexity:** `O(N)`
* **Space Complexity:** `O(1)` excluding the output string.

---

## Key Takeaway

* Use `c - 'a'` to convert lowercase characters into array indices.
* Use modulo `26` to keep values within the alphabet range.
* Character arithmetic can be used to map numeric values back into letters.
* `StringBuilder` is efficient for constructing the final string.
