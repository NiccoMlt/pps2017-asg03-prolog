% Ex2.3: dropNode
% dropNode(+Graph, +Node, -OutGraph)

% drop all edges starting and leaving from a Node
% use dropAll defined in 1.1

% dropAll(?List, ?Elem, ?OutList)
dropAll([], _, []).
dropAll([X|T], X, R) :- !, dropAll(T, X, R).
dropAll([H|Xs], X, [H|L]) :- dropAll(Xs, X, L).

% ADDING THIS BASE CALL IS NEEDED TO STOP RECURSION

dropNode(Graph, Node, Graph) :-
  dropAll(Graph, e(Node, _), Graph),
  dropAll(Graph, e(_, Node), Graph),
  !.

dropNode(G, N, O):- 
  dropAll(G, e(N, _), G2),
  dropAll(G2, e(_ ,N), G3),
  dropNode(G3, N, O). % NEEDED BECAUSE ANY OTHER NODES COULD BE PRESENT

% • Analyse this predicate
% • dropNode([e(1,2),e(1,3),e(2,3)],1,[e(2,3)]).