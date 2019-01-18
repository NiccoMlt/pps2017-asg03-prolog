% Ex2.5: maximum
% max(List,Max)

% Max is the biggest element in List
% Suppose the list has at least one element

% • Realise this yourself!
%   – by properly changing average
% • Do you need an extra argument?
%   – first develop: max(List,Max,TempMax)
%   – where TempMax is the maximum found so far (initially it is the first number in the list.)

max([X|Xs], M) :- max(Xs, M, X).

max([], M, M).

max([X|Xs], M, T) :-
  X >= T,
  max(Xs, M, X).

max([X|Xs], M, T) :-
  X < T,
  max(Xs, M, T).