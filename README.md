# Paul Vs TA Coding Competition

Welcome to the **Paul Vs TA Coding Competition**! Below are the challenges from all three rounds.

---

## Round 1: Password Leak Panic

### Introduction
One day while doomscrolling Reddit during his usual late-night browsing session, **Professor Jesse** accidentally replied to a phishing bot with his encoded password — oops.

However, the attacker couldn’t decode the password, but now you (a brilliant hacker), have a shot at breaking into Jesse’s system. But you might ask _how_? Because Jesse has a habit of using his **lucky number** to encode everything — including his password.

If you decode the password, you might gain access to... the **final exam files** 👀.

---

### Problem Statement

You are given:

- A string `encoded_password` made up of lowercase English letters.
- An integer `lucky_number`, which was used to encode the password by shifting each character (can be negative).

To decode the password:
- Shift each character **backward or forward** in the alphabet by the lucky number, **wrapping around** from `'a'` to `'z'` if needed.

**Example:**

```python
decode_password("apple", 2)  # Output: "crrng"
decode_password("crrng", -2) # Output: "apple"
