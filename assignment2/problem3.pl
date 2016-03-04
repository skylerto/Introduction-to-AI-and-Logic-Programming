%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Assignment 2: Problem 3 %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Merge a two binary search trees %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% true when T2 is the result of inserting every node from T1 into T. %% merge(T, T1, T2)
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% CASE 1: Empty, nothing to do
%merge(t(nil,nil,nil), t(nil,nil,nil), t(nil,nil,nil)).
merge(nil, nil, nil).
merge(t(L, Root, R), nil, t(L, Root, R)).
merge(nil, t(L, Root, R), t(L, Root, R)).

% CASE 2: If the first element in T is less than the root of T1,
merge(t(L,X,R),t(L1,X1,R1),t(L2,X,R2)) :- X =< X1, merge(L,L1,L2), merge(R,t(nil,X1,R1),R2).

merge(t(L,X,R),t(L1,X1,R1),t(L2,X1,R2)) :- X > X1, merge(L,L1,L2), merge(t(nil,X,R),R1,R2).

%%%%%%%%%%%
%% Tests %%
%%%%%%%%%%%
% Test 1:  either tree contains only a single node.
merge(t(nil, 5, nil), t(nil,nil,nil),t(nil, 5, nil)).
merge(t(nil,nil,nil), t(nil, 5, nil), t(nil, 5, nil)).

% Test 2: Right trees
merge(t(nil,4,nil), t(nil, 5, nil), t(nil, 4, t(nil,5,nil))).
merge(t(nil,4,t(nil,6,nil)), t(nil, 5, nil), t(nil, 4, t(nil,5,t(nil,6,nil)))).

% Test 3: Even Trees
merge(t(t(nil,2,nil),4,nil), t(nil, 3, nil), t(t(nil, 2, nil), 3, t(nil, 4, nil))).
merge(t(t(nil,3,nil),4,nil), t(nil, 2, nil), t(t(nil, 3, nil), 2, t(nil, 4, nil))).

% Test 5: Large Tree
merge(t(t(nil,4,t(nil,5,nil)),6, nil), t(t(t(nil,5,nil),6,t(nil,7,nil)),8,t(nil,9,nil)), t(t(t(nil, 5, nil), 4, t(nil, 5, t(nil, 6, t(nil, 7, nil)))), 6, t(nil, 8, t(nil, 9, nil)))).

% Test 6: Very Large Tree (Even 3 levels)
merge(t(t(t(t(nil,4,nil),5,t(nil,6,nil)),10,t(t(nil,14,nil),15,t(nil,16,nil))), 20, t(t(t(nil,22,nil),25,t(nil,26,nil)),30,t(t(nil,34,nil),35,t(nil,36,nil)))), t(t(t(t(nil,2,nil),3,t(nil,4,nil)),5,t(t(nil,7,nil),8,t(nil,9,nil))),10,t(t(t(nil,11,nil),12,t(nil,13,nil)),15, t(t(nil,16,nil),18,t(nil,20,nil)))), t(t(t(t(nil, 2, t(nil, 4, nil)), 3, t(nil, 4, t(nil, 5, t(nil, 6, nil)))), 5, t(t(nil, 7, nil), 8, t(nil, 9, t(nil, 10, t(t(nil, 14, nil), 15, t(nil, 16, nil)))))), 10, t(t(t(nil, 11, nil), 12, t(nil, 13, nil)), 15, t(t(nil, 16, nil), 18, t(nil, 20, t(t(t(nil, 22, nil), 25, t(nil, 26, nil)), 20, t(nil, 30, t(t(nil, 34, nil), 35, t(nil, 36, nil))))))))).
