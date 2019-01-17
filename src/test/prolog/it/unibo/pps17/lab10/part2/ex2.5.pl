% Ex2.5: maximum
% max(List,Max)

% Max is the biggest element in List
% Suppose the list has at least one element

% • Realise this yourself!
%   – by properly changing average
% • Do you need an extra argument?
%   – first develop: max(List,Max,TempMax)
%   – where TempMax is the maximum found so far (initially it is the first number in the list.)


% HEAD RECURSIVE SOLUTION %
% max([X], X).
%
% max([H|T], Max) :-
%   max(T, Max2),
%   H >= Max2,
%   Max = H.
%
% max([H|T], Max) :-
%   max(T, Max2),
%   H < Max2,
%   Max = Max2.

% TAIL RECURSIVE SOLUTION %
max([X|Xs], M) :- max(Xs, M, X).

max([], M, M).

max([X|Xs], M, T) :-
  X >= T,
  max(Xs, M, X).

max([X|Xs], M, T) :-
  X < T,
  max(Xs, M, T).