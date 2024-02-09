package pionia;

import chess.Board;
import java.awt.Point;
import java.util.ArrayList;

/*
 * Represents a Queen piece in the chess game.
 * Extends the Piece class, providing specific movement logic for a Queen, combining Rook and Bishop movement.
 */
public class Queen extends Piece {

    /*
     * Constructor for creating a Queen piece.
     *
     * var color    The color of the queen (White or Black).
     * var position The starting position of the queen on the board.
     */
    public Queen(String color, Point position) {
        super(color, "Queen", position);
    }

    /*
     * Calculates the possible moves for this Queen piece on the given board.
     * The Queen's moves are a combination of Rook and Bishop moves, allowing it to move horizontally, vertically, or diagonally.
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
                break;
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
                break;
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
                break;
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
                break;
            }
        }

        // Horizontal moves towards the right
        for (int j = this.getPosition().y + 1; j < 8; j++) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, j)) == null) {
                moves.add(new Point(this.getPosition().x, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(this.getPosition().x, j));
                }
                break;
            }
        }

        // Horizontal moves towards the left
        for (int j = this.getPosition().y - 1; j >= 0; j--) {
            if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, j)) == null) {
                moves.add(new Point(this.getPosition().x, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(this.getPosition().x, j));
                }
                break;
            }
        }

        // Vertical moves upwards
        for (int i = this.getPosition().x - 1; i >= 0; i--) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, this.getPosition().y)) == null) {
                moves.add(new Point(i, this.getPosition().y));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, this.getPosition().y)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, this.getPosition().y));
                }
                break;
            }
        }

        // Vertical moves downwards
        for (int i = this.getPosition().x + 1; i < 8; i++) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, this.getPosition().y)) == null) {
                moves.add(new Point(i, this.getPosition().y));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, this.getPosition().y)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, this.getPosition().y));
                }
                break;
            }
        }

        return moves; // Return the list of possible moves
    }
}