% Other Exercises

% 1 %
% inv(List,List)
% example: inv([1,2,3],[3,2,1]).

% Head recursive inv %
% last([], X, [X]).
% last([H|T], X, [H|L]) :- last(T, X, L).
%
% inv([], []).
% inv([X|Xs], Inv) :-
%   inv(Xs, Ys),
%   last(Ys, X, Inv).

% Tail recursive inv %
inv(List, Inv) :- inv(List, [], Inv).

inv([], Inv, Inv).
inv([H|T], Acc, Inv) :- inv(T, [H|Acc], Inv).

% 2 %
% double(List,List)
% suggestion: remember predicate append/3
% example: double([1,2,3],[1,2,3,1,2,3]).

double(L, D) :- append(L, L, D).

% 3 %
% times(List,N,List)
% example: times([1,2,3],3,[1,2,3,1,2,3,1,2,3]).

times([_|_], 0, []).
times(L, 1, L).
times(L, X, T) :-
  X > 1,
  X2 is X - 1,
  times(L, X2, L2),
  append(L, L2, T).

% 4 %
% proj(List,List)
% example: proj([[1,2],[3,4],[5,6]],[1,3,5]).

proj(L, P) :- proj(L, [], P).

proj([], P, P).
proj([[H|_]|T], A, P) :-
  append(A, [H], A2),
  proj(T, A2, P).