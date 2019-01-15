% Ex2.2: size with s(s(..(zero)..)..)
% size(List,Size)
% Size will contain the number of elements in List, written using notation zero, s(zero), s(s(zero))..

% • Realise this version yourself!
%   – size( [a,b,c], X ). -> X/s(s(s(zero)))
% • Can it allow for a pure relational behaviour?
%   – size( L, s(s(s(zero)))). ??
%   YES, WITH INFINITE SOLUTIONS ON FIRST ARGUMENT GIVEN THE SECOND
% • Note: Built-in numbers are extra-relational!!

size([], zero).
size([_|T], s(Size)) :- size(T, Size).