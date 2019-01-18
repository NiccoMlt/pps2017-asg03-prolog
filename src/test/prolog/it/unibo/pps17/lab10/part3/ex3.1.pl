% Ex3.1: same
% same(List1,List2)
% are the two lists the same?

% Predict and check relational behaviour!

same([], []).
same([X|Xs], [X|Ys]) :- same(Xs, Ys).

% same/2 is fully relational