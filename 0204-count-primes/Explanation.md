# 204. Count Primes

## Problem Summary

You are given an integer `n`.

Return the **number of prime numbers that are strictly less than `n`**.

A **prime number** is a number greater than `1` that has exactly **two positive divisors**: `1` and itself.

---

## Intuition

The first idea that comes to mind is:

- Check every number from `2` to `n - 1`.
- For each number, determine whether it is prime.
- Count how many are prime.

Although this works, it is **too slow** because checking every number individually requires many repeated divisibility checks.

Instead, we use the **Sieve of Eratosthenes**, which is much faster.

The idea is simple:

- Assume every number is prime.
- Start from `2`.
- If a number is prime, mark all of its multiples as **not prime**.
- Continue until all composite numbers are marked.
- Finally, count the numbers that are still marked as prime.

---

## Key Observation

If a number `i` is prime:

- `2 × i`
- `3 × i`
- `4 × i`
- ...

are **never prime** because they have another divisor (`i`).

Also,

We only need to process numbers up to **√n**.

Why?

If a number has a factor larger than √n, it must also have a factor smaller than √n.

---

## Approach

1. Create a boolean array `isPrime` of size `n`.
2. Mark every number as prime initially.
3. Set `0` and `1` as not prime.
4. Iterate from `2` to `√n`.
5. If the current number is prime:
   - Mark all its multiples as not prime.
   - Start from `i * i` because smaller multiples were already processed.
6. Count how many numbers remain marked as prime.

---

## Dry Run

### Input

```text
n = 10
```

Initially:

```text
Index   : 0 1 2 3 4 5 6 7 8 9
isPrime : F F T T T T T T T T
```

### Step 1

Current number = **2**

It is prime.

Mark its multiples:

```text
4, 6, 8
```

Now:

```text
0 1 2 3 4 5 6 7 8 9
F F T T F T F T F T
```

---

### Step 2

Current number = **3**

It is prime.

Mark its multiples:

```text
9
```

Now:

```text
0 1 2 3 4 5 6 7 8 9
F F T T F T F T F F
```

---

### Step 3

Next number would be **4**

Since `4 > √10`, stop.

Remaining prime numbers:

```text
2
3
5
7
```

Count:

```text
4
```

Answer:

```text
4
```

---

## Algorithm

1. Create a boolean array `isPrime`.
2. Mark every index as `true`.
3. Mark `0` and `1` as `false`.
4. For every number from `2` to `√n`:
   - If it is prime:
     - Mark every multiple starting from `i × i` as `false`.
5. Count all remaining `true` values.
6. Return the count.

---

## Why This Works

Every composite number has a smallest prime factor.

When we visit that prime factor, all of its multiples are marked as non-prime.

Since every composite number gets marked exactly when one of its prime factors is processed, only prime numbers remain marked as `true`.

Therefore, counting the remaining `true` values gives the correct answer.

---

## Complexity Analysis

### Time Complexity

- Initializing the array: **O(n)**
- Sieve process: **O(n log log n)**

Overall:

```text
O(n log log n)
```

---

### Space Complexity

Boolean array of size `n`.

```text
O(n)
```

---

## Key Takeaways

- Checking every number individually is too slow.
- The **Sieve of Eratosthenes** is the optimal solution.
- Mark multiples of every prime as non-prime.
- Start marking from `i × i` because smaller multiples are already processed.
- Only iterate until **√n**.
- Final Time Complexity: **O(n log log n)**, making it efficient even for very large values of `n`.
