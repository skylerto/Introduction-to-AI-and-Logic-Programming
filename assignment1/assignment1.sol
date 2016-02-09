EECS 3401
ASSIGNMENT 1 SOLUTIONS
DEADLINE: February 10, 2016
Skyler Layne (cse23170, 212166906)


I.                KNOWLEDGE REPRESENTATION and CPL

PROBLEM 1.
SOLUTION

  A1. TURN LOCK ON
    ENGLISH: (lock off) & (key touched lock) -> (lock on)
    PROP_LOGIC: p_off & p_t -> ~p_off
    CNF: ~p_off v ~p_t

  A2. PULL_DOOR
    ENGLISH: (door can be opened) & (AN pulls handle)
    PROP_LOGIC: p_can & p_h
    CNF: p_can & p_h

  A3. RELEASE LOCK
    ENGLISH: (key not touching lock) -> (lock off)
    PROP_LOGIC: ~p_t ->p _off
    CNF: p_t v p _off

  A4. TOUCH_LOCK
    ENGLISH: (has key) -> (key touches)
    PROP_LOGIC: p_key -> p_t
    CNF: ~p_key v p_t

  C. if lock is off, the door is closed, and AN has a key, then he door can be
  opened.

    PROP_LOGIC: p_off & ~p_opened & p_key -> p_can
    CNF: ~p_off v p_opened v ~p_key v p_can

PROBLEM 2:
SOLUTION
  (i) -> (ii)
    -- If a KB is inconsistent then it must be the case that we have a contradiction.
    -- no tva h, h(KB)={1}

  (ii) -> (iii)
    -- for all A, KB |- A
    -- assume A = p & ~p
    -- therefore KB |- p & ~p

  (iii) -> (i)
    -- no tva h, h(KB)={1}
    -- i.e. there is no truth value association that will give us True for p & ~p


II.                  RESOLUTION RULE: PROPOSITIONAL CASE

PROBLEM 3:

SOLUTION
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
    -- This set is CONSISTENT, therefore no resolution can be made.
    -- This is said because I cannot deduce one.


PROBLEM 4: pt1 - use PROBLEM 1 to prove KB |- C, where KB={A1,A2,A3}
           pt2 - Will the SOLUTION be different if A4 is added to KB?

SOLUTION

A1. ~p_off v ~p_t
A2. p_can & p_h
A3. p_t v p _off
C: ~p_off v p_opened v ~p_key v p_can

  pt1 - use PROBLEM 1 to prove KB |- C, where KB={A1,A2,A3}
    pt1 SOLUTION
    KB |- C
    KB \/ {~C}


    C1. ~p_off v ~p_t
    C2. p_can
    C3. p_h
    C4. p_t v p _off
    C5. p_off
    C6. ~p_opened
    C7. p_key
    C8. ~p_can
    -- RESOLVE C2, C8 using p_can
    C9. ⃞
    -- therefore INCONSISTENT, C must be know in KB.

    A4. ~p_key v p_t
  pt2 - Will the SOLUTION to pt1 be different if A4 is added to KB?
    pt2 SOLUTION
      Because the solution already exists if we add on another clause, A4, the solution should remain.


PROBLEM 5:

k: bus is operating normally
r: bus is recoverably failed
u: bus is unrecoverably failed
a: bus is active
n: bus is inactive
i: no command input to bus
o: no command output from the bus

SOLUTION
  A1. n v (i & a) -> o
      ~(n v (i & a)) v o
      ~n v ~(i & a) v o
      ~n v ~i v ~a v o

  A2. (~k & n) v ~(~u v r)
  A3. k -> a
      ~k v a

  A4. r -> ~u
      ~r v ~u

  A5. a -> n
      ~a v n
  --
  Q. ~k -> (a & ~(r v u))
      k v (a & ~(r v u))
      k v (a & (~r v ~u))


  TODO: Apply resolution rule.

PROBLEM 6:
  (T) Let S be a set of clauses and let C be a tautological clause in S. Then, S is
      consistent iff S-{C} is consistent.

  Prove T.

  To prove T we must prove the S is consistent with or without C, i.e. that S is consistent regardless of C.

SOLUTION
  -- If C is some tautology: q v ~q and S is some consistent KB.
  -- then S u C is logically equivalent to S u T, where T is true.
  -- it follows that is S is consistent, union with T it is still consistent.

  -- in contrast, if S is consistent and C is some tautology in S
  -- then it follows that S\{T} is also consistent.



III.                  RESOLUTION RULE: PREDICATE LOGIC CASE

PROBLEM 7.
SOLUTION
  (a) {p(f(Y),W,g(Z)), p(U,U,V)}
  -- They are unifiable with unification e=[f(Y)/U,W/U,g(Z)/V]

  (b) {q(X,h(Z),h(X)), q(g(a,Y),h(b),h(Y))}
  -- They are unifiable with unification e=[X/g(a,Y),Z/b, h(X)/h(Y)]

  (c) {p(a,X,f(g(Y))), p(Z,h(Z,W),f(W))}
  -- They are unifiable with unification e=[a/Z,X/h(Z,W),g(Y)/W]

PROBLEM 8.
KB2 = {
        q(X,f(Y,a)):- ;
        p(X):- ;
        r(X,g(T)):- q(Z,T)
      }

and query (k) r(Z,T) v p(T).
SOLUTION
KB u {~k} = {
        q(X,f(Y,a)):- ;
        p(X):- ;
        r(X,g(T)):- q(Z,T);
        :- r(Z,T),p(T)
      }

    C1. q(X,f(Y,a)):-
    C2. p(X):-
    C3. r(X,g(T)):- q(Z,T)
    -- INSERT QUERY AS C4
    C4. :- r(Z,T),p(T)
    -- RESOLVE C1, C3 ON q WITH UNIFICATION e1=[X/Z,f(Y,a)/T]
    -- q(Z,T),r(x,g(T)) :- q(Z,T)
    C5. r(x,g(T)) :-
    -- RESOLVE C2, C4 ON p WITH UNIFICATION e2=[X/T]
    -- p(T) :- r(Z,T),p(T)
    C6. :- r(Z,T)
    -- RESOLVE C5, C6 WITH UNIFICATION e3=[g(T)/T]
    -- r(Z,T) :- r(Z,T)
    C7. :-
    QED
