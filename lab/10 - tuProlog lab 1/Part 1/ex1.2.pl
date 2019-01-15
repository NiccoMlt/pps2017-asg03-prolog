% Ex1.2: search2
% First predict and then test the result(s) of:
% – search2(a,[b,c,a,a,d,e,a,a,g,h]).
% – search2(a,[b,c,a,a,a,d,e]).
% – search2(X,[b,c,a,a,d,d,e]).
% – search2(a,L).
% – search2(a,[_,_,a,_,a,_]).

search2(X, [X, X|_]).
search2(X, [_|Xs]) :- search2(X, Xs).

% – search2 is OK if the element X is the in the first 2 positions of the list
% – search2 is OK if the element X occurs twice consecutively in the tail Xs