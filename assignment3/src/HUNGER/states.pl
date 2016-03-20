%%%%%%%%%%%%%%
% Problem 1. %
%%%%%%%%%%%%%%
% Constants
ref.
mo.
chicken.
pizza.
book.

%%% Predicates
% OPENED
opened(X). % (true if X is opened)
opened(ref) :- false.
opened(mo) :- false.

% CLOSED
closed(X).  %(true if X is closed)
closed(ref).
closed(mo).

% CL
cl(X). %(true if G is close to X)
cl(mo).

%% IN
in(X,O). % (true if X is in O)
in(pizza, ref).
in(chicken, ref).
in(book, ref).

%% HAS
has(X). % (true if G has X)

not_hungry :- false.

%% States
% G is to open X
h_open(X) :- opened(X), !.

%% G is to close X
h_close(X) :- closed(X), !.

%% G is to take X from From
take(X,From) :- cl(From), opened(From), in(X, From), has(X).

%% G is to place C in In
put(X, In) :- opened(In), in(X,In), !.

%% G is to bake X in mo
bake(X) :- cl(mo), has(X), in(X, mo), not(X=book), !.

%% G is to consume X
eat(X) :- bake(X), has(X), not(not_hungry).

%% G is to move from the current location to To
move(To) :- cl(To), !.


%%% Tests/ Goals
:- move(ref), h_open(ref), take(chicken, ref), move(mo), bake(chicken), eat(chicken).
:- move(ref), h_open(ref), take(X, ref), move(mo), bake(X), eat(X).
