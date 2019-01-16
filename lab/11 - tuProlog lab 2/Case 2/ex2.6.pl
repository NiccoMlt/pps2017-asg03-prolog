% Ex2.6: allreaching

% allreaching(+Graph, +Node, -List)

% all the nodes that can be reached from Node
% Suppose the graph is NOT circular!
% Use findall and anyPath!

% LIBRARY PREDICATE (from 2p documentation)
% findall/3 : findall(?term, +callable_term, ?list)
% findall(Template, Goal, List)

% FROM EXERCISE 2.5
anypath([e(N1, N2) | _], N1, N2, [e(N1, N2)]).

anypath([e(N1, N2) | T], N1, N3, [e(N1, N2) | Out]) :-
  anypath(T, N2, N3, Out).

anypath([e(_, _) | T], N1, N2, Out):-
  anypath(T, N1, N2, Out).

% • Implement it using the above suggestions
% • allreaching([e(1,2),e(2,3),e(3,5)],1,[2,3,5]).
  
allreaching(G, N, L) :-
  findall(X, anypath(G, N, X, _), L).

% BECAUSE ANYPATH SUPPOSES THAT THE GRAPH IS ORIENTED, THIS ALSO DOES