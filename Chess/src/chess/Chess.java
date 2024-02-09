package chess;

import pionia.Bishop;
import pionia.King;
import pionia.Knight;
import pionia.Pawn;
import pionia.Piece;
import pionia.Queen;
import pionia.Rook;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// The Chess class implements a basic chess game with GUI
public class Chess implements MouseListener {

    private Board board; // Represents the chess board
    private Piece epilegmanoPioni; // Currently selected piece
    private String turn; // Current player's turn ("White" or "Black")
    private JPanel fagomenaPionia; // Panel to display captured pieces (not used in this code)
    private Player whitePlayer; // White player object
    private Player blackPlayer; // Black player object
    private JFrame window; // Main game window
    private ArrayList<Piece> pieces; // List of pieces on the board
    private int cnt=0; // Score counter for white player
    private int count=0; // Score counter for black player

    // Constructor initializes the game
    public Chess() {
        String name = (String) JOptionPane.showInputDialog(
                null,
                "Give a name or nickname:", // Prompt for the player's name
                "Player", // Title of the dialog
                JOptionPane.PLAIN_MESSAGE);
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Default user name is Player1"); // Default name if none provided
            name = "Player1";
        }
        whitePlayer = new Player(name, "White");
        blackPlayer = new Player("PC", "Black");
        initComponents();
    }

    // Initializes game components
    private void initComponents() {
        if (window != null) {
            window.dispose(); // Dispose of the previous window if it exists
        }
        fagomenaPionia = new JPanel(); // Panel for captured pieces, not utilized in this code

        pieces = new ArrayList<Piece>(); // Initialize the pieces array

        // Add black pieces to the board
        pieces.add(new Rook("Black", new Point(0, 0)));
        pieces.add(new Knight("Black", new Point(0, 1)));
        pieces.add(new Bishop("Black", new Point(0, 2)));
        pieces.add(new Queen("Black", new Point(0, 3)));
        pieces.add(new King("Black", new Point(0, 4)));
        pieces.add(new Bishop("Black", new Point(0, 5)));
        pieces.add(new Knight("Black", new Point(0, 6)));
        pieces.add(new Rook("Black", new Point(0, 7)));

        // Add black pawns
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn("Black", new Point(1, i)));
        }

        // Add white pawns
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn("White", new Point(6, i)));
        }

        // Add white pieces to the board
        pieces.add(new Rook("White", new Point(7, 0)));
        pieces.add(new Knight("White", new Point(7, 1)));
        pieces.add(new Bishop("White", new Point(7, 2)));
        pieces.add(new Queen("White", new Point(7, 3)));
        pieces.add(new King("White", new Point(7, 4)));
        pieces.add(new Bishop("White", new Point(7, 5)));
        pieces.add(new Knight("White", new Point(7, 6)));
        pieces.add(new Rook("White", new Point(7, 7)));

        this.board = new Board(pieces);
        this.board.getForegroundPanel().addMouseListener(this);
        this.epilegmanoPioni = null; // No piece selected by default
        this.turn = "White"; // White starts the game

        JFrame window = new JFrame("Chess 2017");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.add(board, BorderLayout.CENTER);
        window.pack();
        window.setVisible(true);
        window.setResizable(false);
    }

    // Handles mouse clicks on the chess board
    public void mouseClicked(MouseEvent me) {
        int row = me.getY() / 100; // Calculate row based on mouse click
        int col = me.getX() / 100; // Calculate column based on mouse click

        if (this.epilegmanoPioni != null && mporeiNapaeiToPioniEkei(this.epilegmanoPioni, new Point(row, col))) {
            // Move the selected piece if possible
            Piece fagonemo = board.MetakiniseSeNeaThesi(epilegmanoPioni, new Point(row, col));
            if (fagonemo != null) {
                fagomenaPionia.add(fagonemo); // Add captured piece to the panel (not displayed)
                fagomenaPionia.revalidate();
            }

            changeTurn(); // Change turn after a successful move

            if (TeleioseToPaixnidi()) { // Check if the game has ended
                int reply = JOptionPane.showConfirmDialog(null, "statistika\n" + whitePlayer.getName()
                        + "'s score einai " + cnt + "\n" + blackPlayer.getName() + "'s score is "
                        + count + " would you like to play again?", "Chess 2017", JOptionPane.YES_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (reply == JOptionPane.YES_OPTION) {
                    initComponents(); // Restart the game
                } else {
                    System.exit(0); // Exit the game
                }
            }

        } else {
            // Select a piece if none is selected and it's the correct turn
            Piece temPiece = board.VresPoioPieceExeiHThesi(new Point(row, col));
            if (temPiece != null) {
                if (this.epilegmanoPioni != null) {
                    this.epilegmanoPioni.setVisualEffect("Normal");
                }
                if (temPiece.getColor().equals(this.turn)) {
                    this.epilegmanoPioni = temPiece;

                    board.KathariseOlaTaPrasina(); // Clear any highlighted moves
                    board.FotiseMerikesTheseis(epilegmanoPioni.PithanesTheseis(board)); // Highlight possible moves
                }
            }
        }
        board.revalidate();
        board.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    // Changes the turn from white to black or vice versa
    private void changeTurn() {
        this.board.KathariseOlaTaPrasina(); // Clear any highlighted moves
        this.epilegmanoPioni = null; // Deselect any selected piece
        if (turn.equals("White")) {
            turn = "Black";
        } else {
            turn = "White";
        }
    }

    // Checks if the game has ended (a king has been captured)
    private boolean TeleioseToPaixnidi() {
        for (int i = 0; i < fagomenaPionia.getComponentCount(); i++) {
            Piece a = (Piece) fagomenaPionia.getComponent(i);
            if (a.getColor().equals("Black") && a.getTitle().equals("King")) {
                whitewinner(); // White wins if black king is captured
                return true;
            }
            if (a.getColor().equals("White") && a.getTitle().equals("King")) {
                blackwinner(); // Black wins if white king is captured
                return true;
            }
        }
        return false; // Game continues if no king has been captured
    }

    // Checks if the selected piece can move to the destination
    private boolean mporeiNapaeiToPioniEkei(Piece piece, Point destination) {
        ArrayList<Point> theseisPouMporeiNaPaeiArray = piece.PithanesTheseis(board);
        for (Point tmpPosition : theseisPouMporeiNaPaeiArray) {
            if (destination.equals(tmpPosition)) {
                return true; // Move is possible
            }
        }
        return false; // Move is not possible
    }

    // Getters and setters for game components and state
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public JPanel getFagomenaPionia() {
        return fagomenaPionia;
    }

    public void setFagomenaPionia(JPanel fagomenaPionia) {
        this.fagomenaPionia = fagomenaPionia;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getEpilegmanoPioni() {
        return epilegmanoPioni;
    }

    public void setEpilegmanoPioni(Piece epilegmanoPioni) {
        this.epilegmanoPioni = epilegmanoPioni;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
    
    // Increments scores and returns the score for the white player
    public int whitewinner(){
        cnt++;
        return cnt;
    }
    
    // Increments scores and returns the score for the black player
    public int blackwinner(){
        count++;
        return count;
    }
}