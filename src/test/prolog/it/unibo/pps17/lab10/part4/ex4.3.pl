% Ex4.3: seqR2
% seqR2(N,List)
% example: seqR2(4,[0,1,2,3,4]).

% • Realise it yourself!
% • Note, you may need to add a predicate "last"
%   – last([1,2,3],5,[1,2,3,5]).

last([], X, [X]).
last([H|T], X, [H|L]) :- last(T, X, L).

seqR2(0, [0]).
seqR2(N, L) :-
  N > 0,
  N2 is N - 1,
  seqR2(N2, L2),
  last(L2, N, L).