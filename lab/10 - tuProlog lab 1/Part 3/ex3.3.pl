% Ex3.3: sublist
% sublist(List1,List2)
% List1 should be a subset of List2
% example: sublist([1,2],[5,3,2,1]).

% • Do this yourself!
%   – do a recursion on List1, each time just use search of exercise 1.1!

% search(Elem, List)
search(X, [X|T]).
search(X, [_|Xs]) :- search(X, Xs).

sublist([], _).

sublist([X|Xs], Ys) :-
  search(X, Ys),
  sublist(Xs, Ys).