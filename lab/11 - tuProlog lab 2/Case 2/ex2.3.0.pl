% Ex2.3: dropNode
% dropNode(+Graph, +Node, -OutGraph)

% drop all edges starting and leaving from a Node
% use dropAll defined in 1.1

% dropAll(?List, ?Elem, ?OutList)
dropAll([], _, []).
dropAll([X|T], X, R) :- !, dropAll(T, X, R).
dropAll([H|Xs], X, [H|L]) :- dropAll(Xs, X, L).

dropNode(G, N, O) :- 
  dropAll(G, e(N,_), G2),
  dropAll(G2, e(_,N), O).

% • Analyse this predicate
% • dropNode([e(1,2),e(1,3),e(2,3)],1,[e(2,3)]).

% THIS DROPNODE CAN'T WORK WITH THAT DROPALL
% THE UNDERSCORE ASSUMES ONLY THE FIRST VALUE, AND DOESN'T CHANGE IT IN THE DROPALL CALL
% SHOULD IMPLEMENT SPECIFIC DROPALL FOR GRAPH'S NODES, OR A DIFFERENT DROPNODE