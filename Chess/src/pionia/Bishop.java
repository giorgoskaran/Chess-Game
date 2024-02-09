package pionia;

import chess.Board;
import java.awt.Point;
import java.util.ArrayList;

/*
 * Represents a Bishop piece in the chess game.
 * Extends the Piece class, providing specific movement logic for a Bishop.
 */
public class Bishop extends Piece {

    /*
     * Constructor for creating a Bishop piece.
     *
     * var color The color of the bishop (White or Black).
     * var position The starting position of the bishop on the board.
     */
    public Bishop(String color, Point position) {
        super(color, "Bishop", position);
    }

    /*
     * Calculates the possible moves for this Bishop piece on the given board.
     * Bishops move diagonally any number of squares without jumping over other pieces.
     *
     * var board The current state of the chess board.
     * return A list of points representing the possible moves.
     */
    @Override
    public ArrayList<Point> PithanesTheseis(Board board) {
        ArrayList<Point> moves = new ArrayList<>();

        // Diagonal moves towards the top-right
        for (int i = this.getPosition().x - 1, j = this.getPosition().y + 1; i >= 0 && j < 8; i--, j++) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }

        // Diagonal moves towards the top-left
        for (int i = this.getPosition().x - 1, j = this.getPosition().y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }

        // Diagonal moves towards the bottom-left
        for (int i = this.getPosition().x + 1, j = this.getPosition().y - 1; i < 8 && j >= 0; i++, j--) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }

        // Diagonal moves towards the bottom-right
        for (int i = this.getPosition().x + 1, j = this.getPosition().y + 1; i < 8 && j < 8; i++, j++) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }
        
        return moves; // Return the list of possible moves
    }
}