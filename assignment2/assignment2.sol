EECS 3401
ASSIGNMENT 2 SOLUTIONS
Deadline  March. 7, 2016
Skyler Layne (cse23170, 212166906)

PROBLEM 1.

(1) X is a grandfather of Z, if X is the father of Y and Y is a parent of Z.
(2) The father of Y is a parent of Y.
(3) The mother of Y is a parent of Y.

Given the following facts:
(4) adam is the father of beth and bill.
(5) beth is the mother of chris.
(6) bill is the father of ann.

 A. Convert (1)-(6) into clauses. Use the following predicates:

   gf(X,Y) - to denote the fact that X is a grandfather of Y;
   f(X,Y) - to denote the fact that X is the father of Y;
   m(X,Y) -  to denote the fact that X is the mother of Y;
   p(X,Y) -  to denote the fact that X is a parent of Y;

   A.sol
   (1) C1. gf(X,Y) -> (f(X,Y) & p(Y,Z))
            gf(X, Z) :- f(X, Y), p(Y, Z).
   (2) C2. f(X, Y) :- p(X, Y).
   (3) C3. m(X, Y) :- p(X, Y).
   (4) C4.1. f(adam, beth).
       C4.2. f(adam, bill).
   (5) C5. m(beth, chris).
   (6) C6. f(bill, ann).

 B. Formulate an appropriate query to solve the problem (of finding all grandchildren of adam).

  B.sol: find all A's such that adam is the grandparent
  Q. gf(adam, X).

C. Construct a complete SLD search tree for appropriate clauses indicating the solutions.

  C.sol:

              :- gf(adam, X).
                    *
                    | C1.
                    *
          gf(X, Z) :- f(X, Y), p(Y, Z).
          :- f(adam, Y'), p(Y', X').
                    *
                    |
        **************************
       / C2, C4.1.                 \ C2, C4.2.
      *	 								 					  *
f(X, Y) :- p(X, Y).           f(X, Y) :- p(X, Y).
f(adam, beth).                f(adam, bill).
p(beth, X).                   f(bill, X).
      *										 					*
      |  C5.                        | C6.
      *													 		*
m(X, Y) :- p(X, Y).           f(X, Y) :- p(X, Y).
m(beth, chris).               f(bill, ann).
X = chris.                    X = ann.

PROBLEM 2.

(a) merge(L1,L2,L

(b) delete(X,L,L1)
