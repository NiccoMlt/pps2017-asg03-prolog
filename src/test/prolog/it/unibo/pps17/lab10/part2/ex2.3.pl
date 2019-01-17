% Ex 2.3: sum
% sum(List,Sum)

% ?- sum([1,2,3],X).
% yes.
% X/6

% • Realise it yourself!

sum([], 0).
sum([H|T], X) :-
  sum(T, Y),
  X is H + Y.