% Ex2.1: size
% size(List,Size)
% Size will contain the number of elements in List

size([], 0).
size([_|T], M) :- size(T, N), M is N + 1.

% • Check whether it works!
% • Can it allow for a fully relational behaviour? 
%   YES, with infinite solutions on first argument given the second