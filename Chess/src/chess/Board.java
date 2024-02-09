package chess;

import pionia.Piece;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Board extends JLayeredPane {
    // Class variables
    private JPanel[][] koutakia;
    private JPanel backgroundPanel;
    private JPanel foregroundPanel;

    // Constants for board dimensions
    public static final int BOARD_WIDTH = 800;
    public static final int BOARD_HEIGHT = 800;

    // Constructor
    public Board(ArrayList<Piece> pieces) {
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        initBackgroundPanel();
        initForegroundPanel();

        // Place the pieces on the board
        for (Piece tmpP : pieces) {
            this.koutakia[tmpP.getPosition().x][tmpP.getPosition().y].add(tmpP);
        }

        // Add panels to the JLayeredPane
        this.add(backgroundPanel, 0, 0);
        this.add(foregroundPanel, 1, 0);
        this.revalidate();
    }

    // Initialize the background panel with chess board pattern
    private void initBackgroundPanel() {
        backgroundPanel = new JPanel();
        backgroundPanel.setBounds(10, 10, BOARD_WIDTH, BOARD_HEIGHT);
        backgroundPanel.setOpaque(true);
        backgroundPanel.setLayout(new GridLayout(8, 8));

        // Create chess board pattern
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel cell = new JPanel();
                if ((i + j) % 2 == 1) {
                    cell.setBackground(new Color(205, 191, 168)); // Dark color for cells
                } else {
                    cell.setBackground(new Color(238, 234, 226)); // Light color for cells
                }
                cell.setBorder(BorderFactory.createLineBorder(new Color(126, 0, 0)));
                backgroundPanel.add(cell);
            }
        }
    }

    // Initialize the foreground panel which holds the game pieces
    private void initForegroundPanel() {
        foregroundPanel = new JPanel();
        foregroundPanel.setOpaque(false);
        foregroundPanel.setBounds(10, 10, BOARD_WIDTH, BOARD_HEIGHT);
        foregroundPanel.setLayout(new GridLayout(8, 8));
        this.koutakia = new JPanel[8][8];

        // Setup individual squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.koutakia[i][j] = new JPanel();
                this.koutakia[i][j].setOpaque(true);
                this.koutakia[i][j].setBackground(new Color(0f, 0f, 0f, 0f)); // Transparent
                this.koutakia[i][j].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                foregroundPanel.add(this.koutakia[i][j]);
            }
        }
    }

    // Highlight a specific square
    public void FotiseMiaThesi(Point position) {
        JPanel temp = koutakia[position.x][position.y];
        temp.setBackground(new Color(0f, 1f, 0f, 0.6f)); // highlight the box with green color
        this.revalidate();
    }

    // Highlight multiple squares
    public void FotiseMerikesTheseis(ArrayList<Point> positions) {
        for (Point position : positions) {
            FotiseMiaThesi(position);
        }
    }

    // Clear highlight from a specific square
    public void KathariseMiaPrasiniThesi(Point position) {
        JPanel temp = koutakia[position.x][position.y];
        temp.setBackground(new Color(0f, 0f, 0f, 0f)); // Make the black or white color box again
        this.revalidate();
    }

    // Clear highlights from all squares
    public void KathariseOlaTaPrasina() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                KathariseMiaPrasiniThesi(new Point(i, j));
            }
        }
    }

    // Move a piece to a new square, returning any piece that was there before
    public Piece MetakiniseSeNeaThesi(Piece pioni, Point position) {
        this.koutakia[pioni.getPosition().x][pioni.getPosition().y].removeAll();
        Piece HdhYparxon = VresPoioPieceExeiHThesi(position);
        this.koutakia[position.x][position.y].removeAll();
        this.koutakia[position.x][position.y].add(pioni);
        pioni.setPosition(position);
        this.repaint();
        return HdhYparxon;
    }

    // Find which piece is on a given square
    public Piece VresPoioPieceExeiHThesi(Point position) {
        if (this.koutakia[position.x][position.y].getComponentCount() != 0) {
            return (Piece) this.koutakia[position.x][position.y].getComponent(0);
        } else {
            return null;
        }
    }

    // Getters and Setters
    public JPanel[][] getKoutakia() {
        return koutakia;
    }

    public void setKoutakia(JPanel[][] koutakia) {
        this.koutakia = koutakia;
    }

    public JPanel getBackgroundPanel() {
        return backgroundPanel;
    }

    public void setBackgroundPanel(JPanel backgroundPanel) {
        this.backgroundPanel = backgroundPanel;
    }

    public JPanel getForegroundPanel() {
        return foregroundPanel;
    }

    public void setForegroundPanel(JPanel foregroundPanel) {
        this.foregroundPanel = foregroundPanel;
    }
}