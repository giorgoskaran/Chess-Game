package pionia;

import chess.Board;
import java.awt.Point;
import java.util.ArrayList;

/*
 * Represents a Knight piece in the chess game.
 * Extends the Piece class, providing specific movement logic for a Knight.
 */
public class Knight extends Piece {

    /*
     * Constructor for creating a Knight piece.
     *
     * var color The color of the knight (White or Black).
     * var position The starting position of the knight on the board.
     */
    public Knight(String color, Point position) {
        super(color, "Knight", position);
    }

    /*
     * Calculates the possible moves for this Knight piece on the given board.
     * Knights move in an L shape: two squares in one direction and then one square perpendicular to that direction.
     *
     * var board The current state of the chess board.
     * return A list of points representing the possible moves.
     */
    @Override
    public ArrayList<Point> PithanesTheseis(Board board) {
        ArrayList<Point> moves = new ArrayList<>();

        // Calculate potential moves based on the knight's movement pattern
        int[][] offsets = {
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, 2}, {2, 1}, {2, -1}, {1, -2}
        };

        for (int[] offset : offsets) {
            int newX = this.getPosition().x + offset[0];
            int newY = this.getPosition().y + offset[1];

            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) { // Check bounds
                Point potentialMove = new Point(newX, newY);
                Piece pieceAtNewPos = board.VresPoioPieceExeiHThesi(potentialMove);
                if (pieceAtNewPos == null || !pieceAtNewPos.getColor().equals(this.getColor())) {
                    moves.add(potentialMove); // Add if empty or contains opponent's piece
                }
            }
        }

        return moves;
    }
}