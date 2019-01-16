% Ex1.1: search
% Write by-hand these clauses in the theory editor
%
% Read the code as follows:
% – search is OK if the element X is the head of the list
% – search is OK if the element X occurs in the tail Xs

% search(Elem, List)
search(X, [X|_]).
search(X, [_|Xs]) :- search(X, Xs).

% Try the following goals:
% • Check all the possible solutions!
% • query:
%   – search(a,[a,b,c]).
%   – search(a,[c,d,e]).
% • iteration:
%   – search(X,[a,b,c]).
% • generation:
%   – search(a,X).
%   – search(a,[X,b,Y,Z]).
%   – search(X,Y).