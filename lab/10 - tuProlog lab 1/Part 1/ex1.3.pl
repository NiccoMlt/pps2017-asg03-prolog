% Ex1.3: search_two
% search_two(Elem,List)
% looks for two occurrences of Elem with an element in between!

% • Realise it yourself by changing search2, expected results are:
%   – search_two(a,[b,c,a,a,d,e]). -> no
%   – search_two(a,[b,c,a,d,a,d,e]). -> yes
% • Check if it is fully relational

search_two(X, [X, _, X|_]).
search_two(X, [_|Xs]) :- search_two(X, Xs).

% – search_two is OK if the element X occurs in the first and in the third positions of the list
% – search_two is OK if the element X occurs as requested in the tail Xs