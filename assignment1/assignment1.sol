EECS 3401
ASSIGNMENT 1 SOLUTIONS
DEADLINE: February 10, 2016
Skyler Layne (cse23170, 212166906)


I.                KNOWLEDGE REPRESENTATION and CPL

PROBLEM 1.

A1. TURN LOCK ON
  ENGLISH: (lock off) & (key touched lock) -> (lock on)
  PROP_LOGIC: p_off & p_t -> ~p_off
  CNF: ~p_off v ~p_t v ~ p_off

A2. PULL_DOOR
  ENGLISH: (door can be opened) & (AN pulls handle)
  PROP_LOGIC: p_can & p_h
  CNF: p_can & p_h

A3. RELEASE LOCK
  ENGLISH: (key not touching lock) -> (lock off)
  PROP_LOGIC: ~p_t ->p _off
  CNF:

A4. TOUCH_LOCK
  ENGLISH: (has key) -> (key touches)
  PROP_LOGIC: p_key -> p_t
  CNF: ~p_key v p_t

C. if lock is off, the door is closed, and AN has a key, then he door can be
opened.

  PROP_LOGIC: p_off & ~p_opened & p_key -> p_can
  CNF:

PROBLEM 2:
(i) -> (ii)
  -- no tva h, h(KB)={1}
  --

(ii) -> (iii)
  -- for all A, KB |- A
  -- assume A = p & ~p
  -- therefore KB |- p & ~p

(iii) -> (i)
  -- no tva h, h(KB)={1}


II.                  RESOLUTION RULE: PROPOSITIONAL CASE

PROBLEM 3:
(a) {-s, p, q, s v -p v -q},
  C1. ~s
  C2. p
  C3. q
  C4. s v ~p v ~q
  C5. ~p v ~q, (resolve C1, C4 on s)
  C6. ~q, (resolve, C2, C5 on p)
  C7.  ⃞ , (resolve C3, C6 on q)
  -- therefore INCONSISTENT

(b) {-q v -s v -p, s, s v q, p v s, p v q, p v -q, q v -p},
  C1. -q v -s v -p
  C2. s
  C3. s v q
  C4. p v s
  C5. p v q
  C6. p v -q
  C7. q v -p
  C8. ~q v ~p, (resolve C1,C2 on s)
  C9. p, (resolve C5,C7 on p)
  C10. ~p, (resolve C7,C8 on q)
  C11.  ⃞ , (resolve C9,C10 on p)
  -- therefore INCONSISTENT

(c) {-p v -q v -s, p v -t, -t, q v -t v -p},
  C1. -p v -q v -s
  C2. p v -t
  C3. -t
  C4. q v -t v -p
  -- T.V.A
  -- s=f -> C1=t
  -- t=f -> C2=t, C4=t
  -- p,q=t,f
  -- therefore CONSISTENT

(d) {-p v -s, t v -p, q v -s, q v t, -q v -t, p v s, t v -s, q v -p}
  C1. -p v -s
  C2. t v -p
  C3. q v -s
  C4. q v t
  C5. -q v -t
  C6. p v s
  C7. t v -s
  C8. q v -p
  C9. ~p v p, (resolve C1,C6 on s)
  C10.

PROBLEM 4: pt1 - use PROBLEM 1 to prove KB |- C, where KB={A1,A2,A3}
           pt2 - Will the answer be different if A4 is added to KB?

  pt1 - use PROBLEM 1 to prove KB |- C, where KB={A1,A2,A3}
    KB |- C
    KB \/ {~C}

  pt2 - Will the answer be different if A4 is added to KB?


PROBLEM 5:

k: bus is operating normally
r: bus is recoverably failed
u: bus is unrecoverably failed
a: bus is active
n: bus is inactive
i: no command input to bus
o: no command output from the bus

A1. n v (i & a) -> o
A2. (~k & n) v ~(~u v r)
A3. k -> a
A4. r -> ~u
A5. a -> n

Q. ~k -> (a & ~(r v u))

PROBLEM 6:

III.                  RESOLUTION RULE: PREDICATE LOGIC CASE

PROBLEM 7. tba
PROBLEM 8. tba
