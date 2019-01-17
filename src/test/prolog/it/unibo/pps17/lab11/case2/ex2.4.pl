% Ex2.4: reaching

% reaching(+Graph, +Node, -List)
% all the nodes that can be reached in 1 step from Node
% possibly use findall, looking for e(Node,_) combined
% with member(?Elem,?List)

% LIBRARY PREDICATES (from 2p documentation)
% findall/3 : findall(?term, +callable_term, ?list)
% findall(Template, Goal, List)
%
% member/2 : member(?term, +list)
% member(Element, List)

% • Implement it!
% • reaching([e(1,2),e(1,3),e(2,3)],1,L). -> L/[2,3]
% • reaching([e(1,2),e(1,2),e(2,3)],1,L). -> L/[2,2]

reaching(G, N, L) :-
  findall(X, member(e(N, X), G), L1),
  findall(Y, member(e(Y, N), G), L2),
  append(L1, L2, L).
