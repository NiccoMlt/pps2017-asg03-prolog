% Ex2.1: fromList
% fromList(+List, -Graph)

fromList([_], []).
fromList([H1, H2|T], [e(H1, H2)|L]) :- fromList([H2|T], L).

% • Just analyse the code
% • It obtains a graph from a list
%   – fromList([10,20,30],[e(10,20),e(20,30)]).
%   – fromList([10,20],[e(10,20)]).
%   – fromList([10],[]).