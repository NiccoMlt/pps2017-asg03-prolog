% Ex2.5: anypath (advanced!!)

% anypath(+Graph, +Node1, +Node2, -ListPath)
% a path from Node1 to Node2
% if there are many paths, they are showed 1-by-1

% • anypath([e(1,2),e(1,3),e(2,3)],1,3,L).
%   – L/[e(1,2),e(2,3)]
%   – L/[e(1,3)]
% • Implement it; suggestion:
%   – a path from N1 to N2 exists if there is a e(N1,N2)
%   – a path from N1 to N2 is OK if N3 can be reached from N1,
%     and then there is a path from N2 to N3, recursively

anypath([e(N1, N2) | _], N1, N2, [e(N1, N2)]).

anypath([e(N1, N2) | T], N1, N3, [e(N1, N2) | Out]) :-
  anypath(T, N2, N3, Out).

anypath([e(_, _) | T], N1, N2, Out):-
  anypath(T, N1, N2, Out).

% THIS CONSIDERS AN ORIENTED GRAPH, WHERE e(x, y) IS DIFFERENT FROM e(y, x)
% IF ORIENTATION IS NOT NEEDED SHOULD ADD ALSO INVERSE PREDICATES
