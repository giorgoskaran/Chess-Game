package pionia;

import chess.Board;
import java.awt.Point;
import java.util.ArrayList;

/*
 * Represents a Rook piece in the chess game.
 * Extends the Piece class, providing specific movement logic for a Rook.
 */
public class Rook extends Piece {

    /*
     * Constructor for creating a Rook piece.
     *
     * var color The color of the rook (White or Black).
     * var position The starting position of the rook on the board.
     */
    public Rook(String color, Point position) {
        super(color, "Rook", position);
    }
    
    /*
     * Calculates the possible moves for this Rook piece on the given board.
     * Rooks can move vertically or horizontally any number of squares.
     *
     * var board The current state of the chess board.
     * return A list of points representing the possible moves.
     */
    @Override
    public ArrayList<Point> PithanesTheseis(Board board) {
        ArrayList<Point> moves = new ArrayList<>();
        
        // Move right
        for (int i = this.getPosition().x, j = this.getPosition().y + 1; j < 8; j++) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }
        
        // Move left
        for (int i = this.getPosition().x, j = this.getPosition().y - 1; j >= 0; j--) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }
        
        // Move up
        for (int i = this.getPosition().x - 1, j = this.getPosition().y; i >= 0; i--) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }
        
        // Move down
        for (int i = this.getPosition().x + 1, j = this.getPosition().y; i < 8; i++) {
            if (board.VresPoioPieceExeiHThesi(new Point(i, j)) == null) {
                moves.add(new Point(i, j));
            } else {
                if (!board.VresPoioPieceExeiHThesi(new Point(i, j)).getColor().equals(this.getColor())) {
                    moves.add(new Point(i, j));
                }
                break; // Stop if another piece is encountered
            }
        }
        
        return moves;
    }
}