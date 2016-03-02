%%%%%%%%%%%%%%%%%%%%%%%%%
%% Merge a sorted list %%
%%%%%%%%%%%%%%%%%%%%%%%%%

% CASE 1: If the empty lists.
merge([],[],[]).

% CASE 2: The lists contain 1 element
merge([],[Y],[Y|L]) :- merge([],[],L).
merge([X],[],[X|L]) :- merge([],[],L).

% CASE 3: The first element, X, in L1 is less than the first element, Y, in L2, add X to L and merge on L1', L2, and L' where L1' is `L1 \ X`, L2 stays the same and L' is `L u X`
merge([X|L1],[Y|L2],[X|L]) :- lt(X, Y), merge(L1,[Y|L2],L).

% CASE 4: The first element, X, in L1 is greater than or equal to the first element, Y, in L2, add Y to L and merge on L1, L2', and L' where L1 stays the same, L2' is `L2 \ Y` and L' is `L u Y`
merge([X|L1],[Y|L2],[Y|L]) :- merge([X|L1],L2,L).

%%%%%%%%%%%%%%%%%%%%%%%
%% Helper Predicates %%
%%%%%%%%%%%%%%%%%%%%%%%
% True if X < Y is true.
lt(X, Y) :- X<Y.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Delete all occurrences from a list %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% CASE 1: Empty
delete(_,[],[]).

% CASE 2: List of a list
delete(X,[[_|L1]|L2],[L1|L]) :- delete(X,L2,L).

% CASE 3: Recursive Case
delete(X,[X|L1],L) :- delete(X,L1,L).
delete(X,[H|L1],[H|L]) :- delete(X,L1,L).
