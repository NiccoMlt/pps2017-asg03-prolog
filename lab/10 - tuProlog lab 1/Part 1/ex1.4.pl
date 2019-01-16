% Ex1.4: search_anytwo
% search_anytwo(Elem,List)
% looks for any Elem that occurs two times

% • Implement it
% • Suggestion:
%   – Elem must be on the head and search must be successful on the tail
%   – otherwise proceed on the tail
%   – (search_anytwo should use search)
% • Expected results are:
%   – search_anytwo(a,[b,c,a,a,d,e]). -> yes
%   – search_anytwo(a,[b,c,a,d,e,a,d,e]). -> yes

% search(Elem, List)
search(X, [X|T]).
search(X, [_|Xs]) :- search(X, Xs).

% search_anytwo(Elem, List)
search_anytwo(X, [X|T]) :- search(X, T).
search_anytwo(X, [_|Xs]) :- search_anytwo(X, Xs).

% – search_anytwo uses search/2 defined in exercise 1.1
% – search_anytwo is OK if the element X occurs in the head of the list and in the tail T
% – search_anytwo is OK if the element X occurs twice in the tail Xs