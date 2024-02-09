package pionia;

import chess.Board;
import java.awt.Point;
import java.util.ArrayList;

/*
 * Represents a Pawn piece in the chess game. 
 * Extends the Piece class, providing specific movement logic for a Pawn.
 */
public class Pawn extends Piece {

    /*
     * Constructor for creating a Pawn piece.
     *
     * var color The color of the pawn (White or Black).
     * variable position The starting position of the pawn on the board.
     */
    public Pawn(String color, Point position) {
        super(color, "Pawn", position);
    }

    /*
     * Calculates the possible moves for this Pawn piece on the given board.
     *
     * var board The current state of the chess board.
     * return A list of points representing the possible moves.
     */
    @Override
    public ArrayList<Point> PithanesTheseis(Board board) {
        ArrayList<Point> moves = new ArrayList<>();

        // Black pawn movement logic
        if (this.getColor().equals("Black")) {
            // Move forward if the next space is free
            if (this.getPosition().x + 1 < 8) {
                if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y)) == null) {
                    moves.add(new Point(this.getPosition().x + 1, this.getPosition().y));
                    // Double move if on starting position
                    if (this.getPosition().x == 1 && board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 2, this.getPosition().y)) == null) {
                        moves.add(new Point(this.getPosition().x + 2, this.getPosition().y));
                    }
                }
            }
            
            // Check for captures diagonally to the right
            if (this.getPosition().x + 1 < 8 && this.getPosition().y + 1 < 8) {
                Piece possibleCapture = board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y + 1));
                if (possibleCapture != null && possibleCapture.getColor().equals("White")) {
                    moves.add(new Point(this.getPosition().x + 1, this.getPosition().y + 1));
                }
            }
            // Check for captures diagonally to the left
            if (this.getPosition().x + 1 < 8 && this.getPosition().y - 1 >= 0) {
                Piece possibleCapture = board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x + 1, this.getPosition().y - 1));
                if (possibleCapture != null && possibleCapture.getColor().equals("White")) {
                    moves.add(new Point(this.getPosition().x + 1, this.getPosition().y - 1));
                }
            }
        } else { // White pawn movement logic
            // Move forward if the next space is free
            if (this.getPosition().x - 1 >= 0) {
                if (board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y)) == null) {
                    moves.add(new Point(this.getPosition().x - 1, this.getPosition().y));
                    // Double move if on starting position
                    if (this.getPosition().x == 6 && board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 2, this.getPosition().y)) == null) {
                        moves.add(new Point(this.getPosition().x - 2, this.getPosition().y));
                    }
                }
            }

            // Check for captures diagonally to the right
            if (this.getPosition().x - 1 >= 0 && this.getPosition().y + 1 < 8) {
                Piece possibleCapture = board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y + 1));
                if (possibleCapture != null && possibleCapture.getColor().equals("Black")) {
                    moves.add(new Point(this.getPosition().x - 1, this.getPosition().y + 1));
                }
            }
            // Check for captures diagonally to the left
            if (this.getPosition().x - 1 >= 0 && this.getPosition().y - 1 >= 0) {
                Piece possibleCapture = board.VresPoioPieceExeiHThesi(new Point(this.getPosition().x - 1, this.getPosition().y - 1));
                if (possibleCapture != null && possibleCapture.getColor().equals("Black")) {
                    moves.add(new Point(this.getPosition().x - 1, this.getPosition().y - 1));
                }
            }
        }

        return moves; // Return the list of possible moves
    }
}
