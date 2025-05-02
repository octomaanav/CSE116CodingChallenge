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

Letter	+2 Shift
'a'	    'c'
'p'	    'r'
'p'	    'r'
'l'	    'n'
'e'	    'g'
```

**Negatives:**
```python
encoded_password = "crrng"
lucky_number = -2
Decoded Output: "apple"

Letter	-2 Shift
'c'	    'a'
'r'	    'p'
'r'	    'p'
'n'	    'l'
'g'	    'e'
```


## Round 2: Gambling

### Introduction
After his system got hacked and the CSE 116 final exam was leaked (all thanks to you), Professor Jesse was ruined. He lost his reputation, job, and worst of all... his crypto wallet.

Now with nothing to lose, Jesse did what any other CS prof would do in this situation: **GAMBLING**!

In an effort to become a millionaire again, Jesse goes to a casino where there are different games and machines. Jesse needs your help to **maximize the amount of money he can earn in a gambling session**.

---

### Problem Statement

Each game in the casino is represented as a **node in a binary tree**.

- Each node contains an **integer** (positive or negative)
- The value represents Jesse’s **net profit/loss** at that game
- Jesse starts at the **entrance** (the root of the tree)
- He can only move **downward** through connected games until he reaches a **final machine** (a leaf)

Your task is to:

- **Find the maximum sum** among all **root-to-leaf** paths
- If all paths lead to **net loss or zero**, return `0`

---

### Output

- Return the **maximum sum of values** along any **root-to-leaf path**

---

### Sample Test Cases

#### Example Tree:
    5
   / \
 -9   3
 / \
4   20

- Max earning = `5 + (-9) + 20 = 16`

#### All Negative Tree:
  -1
  / \
-2  -3

- Max profit = `0` (since all paths lead to a net loss)


## Round 3: The IntelliJland

### Introduction
After winning the big bucks from his gambling career, Professor Jesse now wants to go on an adventure trip and discover foreign lands never seen by mankind.

He arrives at a strange land known only as... **IntelliJland**. A mysterious figure whispers:

> “One of these paths loops forever… and if you take it, you’ll never return.”

Jesse needs your help to detect **if the path he is on has a cycle or not**.

---

### Problem Statement

You're given the `head` of a **linked list** that represents Jesse’s path. You need to:

- Return `True` if there **is a cycle**
- Return `False` if there **is no cycle**

---

### Bonus Challenges

- **Bonus 1**: Can you solve this **without using extra space** (no extra data structures)?
- **Bonus 2**: Can you find the **node where the cycle begins**? Return the node or `None`.

---

### Sample Test Cases

**Cycle Case:**

1 → 2 → 3 → 4 → 5
↑       ↓
← ← ← ←

- Output (Cycle Exists): `True`
- Bonus Output (Cycle Start): `Node with value 2`

**No Cycle Case:**

1 → 2 → 3 → 4 → 5

- Output (Cycle Exists): `False`
- Bonus Output (Cycle Start): `None`
