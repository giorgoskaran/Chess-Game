package pionia;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import chess.Board;

/*
 * Abstract class representing a chess piece.
 */
public abstract class Piece extends JLabel {
    private String color; // Color of the piece (e.g., "White" or "Black")
    private String title; // Title of the piece (e.g., "King", "Queen")
    private Point position; // Position of the piece on the board
    private String visualEffect; // Visual effect to be applied to the piece icon

    /*
     * Constructor to initialize a chess piece with its properties.
     * 
     * color     The color of the piece.
     * title     The title of the piece.
     * position  The initial position of the piece on the board.
     */
    public Piece(String color, String title, Point position) {
        this.color = color;
        this.title = title;
        this.position = position;
        this.visualEffect = "Normal"; // Default visual effect
        updateIcon(); // Update the icon based on the piece's properties
    }

    /*
     * Updates the icon of the chess piece.
     */
    private void updateIcon() {
        String filename = "Images/" + color + "_" + title + "_" + visualEffect + ".png";
        ImageIcon icon = new ImageIcon(filename);
        this.setIcon(icon);
    }

    // Getter and setter methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        updateIcon(); // Update icon when color changes
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        updateIcon(); // Update icon when title changes
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getVisualEffect() {
        return visualEffect;
    }

    public void setVisualEffect(String visualEffect) {
        this.visualEffect = visualEffect;
        updateIcon(); // Update icon when visual effect changes
    }

    /*
     * Abstract method to calculate potential positions the piece can move to.
     * return an ArrayList of points representing potential positions.
     */
    public abstract ArrayList<Point> PithanesTheseis(Board board);
}