%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Assignment 2: Problem 4 %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% (a) resolve(C1,C2,P,Res) %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%resolve(C1,C2,P,Res).

% CASE 1: Base Case
resolve([],[],_,[]).

% CASE 2: If -P is in C1, AND P is in C2, remove -P from C1, P from C2 and append the left overs.
resolve(C1, C2, P, Res) :- not(member(P, C1)), Q is (0-P), member(Q, C1), r(Q, C1, R1), r(P, C2, R2), append(R1, R2, Res).

% CASE 3: If P is in C1, AND -P is in C2, remove P from C1, -P from C2 and append the left overs.
resolve(C1, C2, P, Res) :- member(P, C1), r(P, C1, R1), Q is (0-P), r(Q, C2, R2), append(R1, R2, Res).

%% Remove the first occurance helper predicates.
r(X, [], []).
r(X, [X|T], T).
r(X, [H|T], [H|Res]) :- r(X, T, Res).

%%%%%%%%%%%%%%%%%%%%
%% (b) sub(C1,C2) %%
%%%%%%%%%%%%%%%%%%%%
% CASE 1: Any clause subsumes Tte empty clause.
sub(C1, []).

% CASE 2: We must achieve all elements of C2 must be in C1, as we're modelling our clauses as lists.
sub(C1, [X|C2]) :- member(X, C1).

%%%%%%%%%%%%%%%%%
%% (c) taut(C) %%
%%%%%%%%%%%%%%%%%

% CASE 1: Check if the opposite literal exists in the Clause.
taut([H|T]) :- Q is (0-H), member(Q, T).

%%%%%%%%%%%
%% Tests %%
%%%%%%%%%%%

% resolve(C1,C2,P,Res) Tests
resolve([1], [-1], 1, []).
resolve([2,-1], [1,2], 1, [2, 2]).
resolve([-1,7,4], [2,-1,9,5,1,-1], 1, [7, 4, 2, -1, 9, 5, -1]).

% sub(C1,C2) Tests
sub([],[]). % True
sub([1,2,3,4],[2,3]). % True
sub([3],[2,3]). % False

% taut(C) Tests
taut([1,2]).
taut([-1,2]).
taut([1,2,-1]).
taut([1,2,-1,-2]).
