% Ex2.2: fromCircList

% fromCircList(+List,-Graph)
% which implementation?

% • Implement it!
% • Obtain a graph from a circular list
%   – fromCircList([10,20,30],[e(10,20),e(20,30),e(30,10)]).
%   – fromCircList([10,20],[e(10,20),e(20,10)]).
%   – fromCircList([10],[e(10,10)]).

fromCircList([H|T], G) :- fromCircList([H|T], H, G).
fromCircList([X], First, [e(X, First)]) :- !.
fromCircList([H1, H2|T], First, [e(H1, H2)|L]) :- fromCircList([H2|T], First, L).