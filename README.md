## Round 1: Password Leak Panic

### Introduction
One day while doomscrolling Reddit during his usual late-night browsing session, Professor Jesse accidentally replied to a phishing bot with his **encoded password** — oops.

Fortunately, the attacker couldn’t decode the password. But now **you** (a brilliant hacker) have a shot at breaking into Jesse’s system.

How? Jesse uses his **lucky number** to encode everything — including his password.

If you can decode the encrypted password, you might be able to get into Jesse’s system... and find the **final exam files 👀**.

---

### Problem Statement

You are given:

- A string `encoded_password` made up of **lowercase English letters**
- An integer `lucky_number`, which was used to **encode** the password by shifting each character  
  (The integer can be **negative**)

To **decode** the password, shift each character **backward or forward** in the alphabet by `lucky_number`, wrapping around from `'a'` to `'z'` if needed.

Return the **decoded password string**.

---

### Sample Test Cases

#### Positives:
```python
encoded_password = "apple"
lucky_number = 2
Decoded Output: "crrng"

Letter	+2 Shift →
'a'	    'c'
'p'	    'r'
'p'	    'r'
'l'	    'n'
'e'	    'g'

#### Negatives:
```python
encoded_password = "crrng"
lucky_number = -2
Decoded Output: "apple"

Letter	-2 Shift →
'c'	    'a'
'r'	    'p'
'r'	    'p'
'n'	    'l'
'g'	    'e'



