# LeetCode 933 - Number of Recent Calls

## Problem Summary

Design a class that counts how many requests have occurred in the last **3000 milliseconds**.

Whenever `ping(t)` is called:

* A new request arrives at time `t`.
* Return the number of requests that happened in the time range **[t - 3000, t]** (inclusive).

It is guaranteed that each new `t` is greater than the previous one.

---

# Intuition

Since the request times always arrive in **increasing order**, the oldest requests are always at the front and the newest requests are always at the back.

We only care about requests that fall inside the current 3000 ms window.

So whenever a new request arrives:

1. Store the new request.
2. Remove every request that is older than `t - 3000`.
3. The remaining requests are exactly the valid requests inside the window.

A **Queue** is the perfect data structure because:

* New requests are added at the back.
* Old requests are removed from the front.

---

# Approach

For every `ping(t)`:

### Step 1

Insert the current request time into the queue.

---

### Step 2

Calculate the beginning of the valid window.

```
windowStart = t - 3000
```

---

### Step 3

While the oldest request is outside the window:

* Remove it from the front.

The condition is:

```
oldestRequest < windowStart
```

Those requests can never become valid again because future timestamps are always larger.

---

### Step 4

After removing all expired requests, every remaining request lies inside:

```
[t - 3000, t]
```

Therefore, simply return the queue size.

---

# Example Walkthrough

Operations:

```
ping(1)
```

Queue:

```
[1]
```

Valid window:

```
[-2999, 1]
```

Answer:

```
1
```

---

```
ping(100)
```

Queue:

```
[1, 100]
```

Window:

```
[-2900, 100]
```

Both requests are valid.

Answer:

```
2
```

---

```
ping(3001)
```

Queue:

```
[1, 100, 3001]
```

Window:

```
[1, 3001]
```

All requests are still valid.

Answer:

```
3
```

---

```
ping(3002)
```

Queue before removing:

```
[1, 100, 3001, 3002]
```

Window:

```
[2, 3002]
```

Request `1` is outside the window.

Remove it.

Queue becomes:

```
[100, 3001, 3002]
```

Answer:

```
3
```

---

# Why a Queue?

A queue naturally maintains requests in chronological order.

* Insert new requests → Back
* Remove expired requests → Front

Since timestamps are strictly increasing, we never need to search for expired requests.

This makes the solution both simple and efficient.

---

# Time Complexity

### `ping()`

* **Average (Amortized): O(1)**

Although a single call may remove multiple requests, each request is:

* Added exactly once.
* Removed exactly once.

Across all operations, every element is processed only twice.

---

# Space Complexity

**O(n)**

Where `n` is the number of requests currently stored inside the 3000 ms window.

---

# Key Concepts Learned

* Queue (FIFO)
* Sliding Window
* Amortized Analysis
* Maintaining a Fixed Time Window
* Efficient Removal of Expired Elements

---

# Pattern Recognition

If a problem asks you to:

* Keep only recent elements,
* Remove outdated data,
* Process events in chronological order,

then think about using:

* **Queue**
* **Sliding Window**
* **FIFO processing**
