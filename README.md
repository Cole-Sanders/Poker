# Poker
A playable game of five-card draw poker.

How it works:
The user is presented with a GUI pop up displaying their points, the cards in their hand, and red replace tiles.
The user can then select which cards they would like to draw a replacement for by clicking the corresponding replace
tile under the intended card up to a maximum of all five cards. Then the user presses the score hand button to replace
the selected cards and recieve a score. If there are no pairs in the final hand then the user loses 10 points. If there
is at least one pair or any other significant card pattern present then the user will gain points corresponding to the 
relative rank of the pattern present. For example they would gain the lowest number of points for a hand with one pair,
a higher number of points for three of a kind, and the most points for a royal flush. The game can be repeated indefinitely
or until the user runs out of points.

How to run it:
I originally developed this program running it through the Git Bash command line, but a much easier way is to download it to
an IDE such as Eclipse and simply run the VideoPokerGUI file.
