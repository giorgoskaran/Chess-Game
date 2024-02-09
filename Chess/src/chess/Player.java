package chess;

/*
 * Represents a player in the chess game.
 * This class stores information such as the player's name, score, and color (white or black).
 */
public class Player {
    // Player's name
    private String name;
    // Player's score
    private int score;
    // Player's color (white or black)
    private String color;

    
    /*
     * Constructor to initialize the player with a name and color.
     *
     * var name  The name of the player.
     * var color The color of the player, either "white" or "black".
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    
    
    /*
     * Gets the player's name.
     *
     * return The name of the player.
     */
    public String getName() {
        return name;
    }

    
    
    /*
     * Sets the player's name.
     *
     * var name The new name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    
    
    /*
     * Gets the player's score.
     *
     * return The score of the player.
     */
    public int getScore() {
        return score;
    }

    
    
    
    /*
     * Sets the player's score.
     *
     * var score The new score of the player.
     */
    public void setScore(int score) {
        this.score = score;
    }

    
    
    
    /*
     * Gets the player's color.
     *
     * return The color of the player.
     */
    public String getColor() {
        return color;
    }

    
    
    
    /*
     * Sets the player's color.
     *
     * var color The new color of the player.
     */
    public void setColor(String color) {
        this.color = color;
    }
}