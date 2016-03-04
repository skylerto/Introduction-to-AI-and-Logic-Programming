%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Assignment 2: Problem 1 %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Representing Grandfather in Prolog %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

p(adam, beth).
p(adam, bill).
p(beth, chris).
p(bill, ann).

% Definition of a Grandfather
gf(X,Z) :- f(X,Y), p(Y,Z).

% Definition of a parent
f(X,Y) :- p(X,Y).

% Definition of a mother
m(X,Y) :- p(X,Y).
