% first(X, L). :- first(X, []).
% first(X, L) :- first(X, [X|L]).

% if the first element in L1 is less than the element in L2, add this element to L
%merge([X|L1],[Y|L2],L) :- X<Y, merge(L1,[Y|L2],[X|L]).

% if the first element in L2 is less than the element in L1, add this element to L
%merge([X|L1],[Y|L2],L) :- X>Y, merge([X|L1],L2,[Y|L]).

% merge(X,[Y|L2],[X|L]) :- X<Y, merge([],L2,[X|L]).
% merge([X|L1],[Y|L2],[]) :- X<Y, merge(L1,L2,[X, Y]).
% merge([X|L1],[Y|L2],[]) :- X>Y, merge(L1,L2,[Y, X]).
% merge(X, Y, [X,Y]) :- X < Y.
% merge(X, Y, [Y,X]) :- X > Y.

%%%%%%%%%%%%%%%%%%%%%%%%%
%% Merge a sorted list %%
%%%%%%%%%%%%%%%%%%%%%%%%%
% CASE 1: If the empty lists.
merge([],[],L) :- L.
merge([],[Y],L) :- merge([],[],[L|Y]).
merge([X],[],L) :- merge([],[],[L|X]).

% CASE 2: The Lists contain 1 Element
merge([X],[Y],[X,Y]) :- lt(X,Y).
merge([X],[Y],[Y,X]) :- lt(Y,X).

merge([X|L1],[Y|L2],L) :- lt(X,Y),      merge(L1,[Y|L2],[L|X]).

merge([X|L1],[Y|L2],L) :- lt(Y,X), merge([X|L1],L2,[L|Y]).



% merge([X|L1],[],L) :- merge(L1,[],[X|L]).



% True if X < Y is true.
lt(X, Y) :- true, X<Y.

% Define first Element
first([X], X).
first([Y|_], Y).
first([], _) :- fail.
