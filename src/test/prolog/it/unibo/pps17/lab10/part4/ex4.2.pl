% Ex4.2: seqR
% seqR(N,List)
% example: seqR(4,[4,3,2,1,0]).

% Realise it yourself!

seqR(0, [0]).

seqR(N, [N|T]) :-
  N >= 0,
  N2 is N - 1,
  seqR(N2, T).