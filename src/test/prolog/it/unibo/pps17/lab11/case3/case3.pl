% Case 3: Generating TicTacToes
% • Implement predicate next/4 as follows
%   – next(@Table,@Player,-Result,-NewTable)
%   – Table is a representation of a TTT table where players x
%     or o are playing
%   – Player (either x or o) is the player to move
%   – Result is either (either win(x), win(o), nothing, or even)
%   – NewTable is the table after a valid move
%   – Should find a representation for the Table
%   – Calling the predicate should give all results
% • Secondarily, implement predicate:
%   – game(@Table,@Player,-Result,-TableList)
%   – TableList is the sequence of tables until Result win(x),
%     win(o) or even

% THE TABLE IS REPRESENTED AS A LIST OF 9 ELEMENTS ( FROM POS (0,0) TO (2,2) )

rowWin(Table, Player) :-
  Table = [Player, Player, Player, _, _, _, _, _, _];
  Table = [_, _, _, Player, Player, Player, _, _, _];
  Table = [_, _, _, _, _, _, Player, Player, Player].

columnWin(Table, Player) :-
  Table = [Player, _, _, Player, _, _, Player, _, _];
  Table = [_, Player, _, _, Player, _, _, Player, _];
  Table = [_, _, Player, _, _, Player, _, _, Player].

diagonalWin(Table, Player) :-
  Table = [Player, _, _, _, Player, _, _, _, Player];
  Table = [_, _, _, Player, Player, Player, _, _, _];
  Table = [_, _, _, _, _, _, Player, Player, Player].

check(Table, Player, win(Player)) :- rowWin(Table, Player), !.
check(Table, Player, win(Player)) :- columnWin(Table, Player), !.
check(Table, Player, win(Player)) :- diagonalWin(Table, Player), !.
check(Table, _, even) :- not(member(empty, Table)), !.
check(_, _, nothing).

move([empty | T], P, [P | T]).
move([H | T], P, [H | N]) :- move(T, P, N).

next(T, _, even, T) :- not(member(empty, Table)).
next(T, P, R, N) :-
  move(T, P, N),
  check(N, P, R).

other(x, o).
other(o, x).

game(T, P, even, [T, L]) :- next(T, P, even, L).
game(T, P, win(P), [T, L]) :- next(T, P, win(P), L).

game(T, P1, R, [T | L]) :-
  next(T, P1, nothing, N),
  other(P1, P2),
  game(N, P2, R, L).