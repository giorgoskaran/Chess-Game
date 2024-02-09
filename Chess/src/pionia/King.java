package pionia;

import chess.Board;
import java.awt.Point;
import java.util.ArrayList;

/*
 * Represents a King piece in the chess game.
 * Extends the Piece class, providing specific movement logic for a King.
 */
public class King extends Piece {

    /*
     * Constructor for creating a King piece.
     *
     * var color    The color of the king (White or Black).
     * var position The starting position of the king on the board.
     */
    public King(String color, Point position) {
        super(color, "King", position);
    }

    /*
     * Calculates the possible moves for this King piece on the given board.
     * The King can move one square in any direction: horizontally, vertically, or diagonally.
     *
     * var board The current state of the chess board.
     * return A list of points representing the possible moves.
     */
    @Override
    public ArrayList<Point> PithanesTheseis(Board board) {
        ArrayList<Point> moves = new ArrayList<>();

        // Check moves towards the top-right diagonal
        if (this.getPosition().x - 1 >= 0 && this.getPosition().y + 1 < 8) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y + 1)) == null) {
                moves.add(new Point(this.getPosition().x - 1, this.getPosition().y + 1));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y + 1)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x - 1, this.getPosition().y + 1));
            }
        }

        // Check moves towards the bottom-right diagonal
        if (this.getPosition().x + 1 < 8 && this.getPosition().y + 1 < 8) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y + 1)) == null) {
                moves.add(new Point(this.getPosition().x + 1, this.getPosition().y + 1));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y + 1)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x + 1, this.getPosition().y + 1));
            }
        }

        // Check moves towards the bottom-left diagonal
        if (this.getPosition().x + 1 < 8 && this.getPosition().y - 1 >= 0) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y - 1)) == null) {
                moves.add(new Point(this.getPosition().x + 1, this.getPosition().y - 1));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y - 1)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x + 1, this.getPosition().y - 1));
            }
        }

        // Check moves towards the top-left diagonal
        if (this.getPosition().x - 1 >= 0 && this.getPosition().y - 1 >= 0) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y - 1)) == null) {
                moves.add(new Point(this.getPosition().x - 1, this.getPosition().y - 1));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y - 1)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x - 1, this.getPosition().y - 1));
            }
        }

        // Check moves towards the top
        if (this.getPosition().x - 1 >= 0) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y)) == null) {
                moves.add(new Point(this.getPosition().x - 1, this.getPosition().y));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x - 1, this.getPosition().y));
            }
        }

        // Check moves towards the bottom
        if (this.getPosition().x + 1 < 8) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y)) == null) {
                moves.add(new Point(this.getPosition().x + 1, this.getPosition().y));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x + 1, this.getPosition().y));
            }
        }

        // Check moves towards the left
        if (this.getPosition().y - 1 >= 0) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, this.getPosition().y - 1)) == null) {
                moves.add(new Point(this.getPosition().x, this.getPosition().y - 1));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, this.getPosition().y - 1)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x, this.getPosition().y - 1));
            }
        }

        // Check moves towards the right
        if (this.getPosition().y + 1 < 8) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, this.getPosition().y + 1)) == null) {
                moves.add(new Point(this.getPosition().x, this.getPosition().y + 1));
            } else if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, this.getPosition().y + 1)).getColor().equals(this.getColor())) {
                moves.add(new Point(this.getPosition().x, this.getPosition().y + 1));
            }
        }

        return moves; // Return the list of possible moves
    }
}