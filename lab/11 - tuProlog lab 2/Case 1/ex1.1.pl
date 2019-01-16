% Ex1.1: other drops

% Try to realise some of the following variations,
% by using cut and/or reworking the implementation
% – dropFirst: drops only the first occurrence (showing no alternative results)
% – dropLast: drops only the last occurrence (showing no alternative results)
% – dropAll: drop all occurrences, returning a single list as result

% dropFirst(?Elem, ?List, ?OutList)
dropFirst(X, [X|T], T) :- !.
dropFirst(X, [H|Xs], [H|L]) :- dropFirst(X, Xs, L).

% dropLast(?Elem, ?List, ?OutList)
dropLast(X, [X|T], T) :- not(dropLast(X, T, _)), !.
dropLast(X, [H|Xs], [H|L]) :- dropLast(X, Xs, L).

% dropAll(?Elem, ?List, ?OutList)
dropAll(_, [], []).
dropAll(X, [X|T], R) :- !, dropAll(X, T, R).
dropAll(X, [H|Xs], [H|L]) :- dropAll(X, Xs, L).