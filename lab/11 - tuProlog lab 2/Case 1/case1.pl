% Case 1: dropAny
% dropAny(?Elem,?List,?OutList)

dropAny(X, [X|T], T).
dropAny(X, [H|Xs], [H|L]) :- dropAny(X, Xs, L).

% • Check the above code
% • Drops any occurrence of element
%   – dropAny(10,[10,20,10,30,10],L)
%     * L/[20,10,30,10]
%     * L/[10,20,30,10]
%     * L/[10,20,10,30]