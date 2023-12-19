package Sudoku;

/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2023/2024
 * Group Capstone Project
 * Group #5
 * 1 - 5026221032 - Fadillah Nur Laili
 * 2 - 5026221171 - Muhammad Rafi Novyansyah
 * 3 - 5026221202 - Akbar Daniswara Cahya Buana
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    public static GameBoardPanel board;
    public static Puzzle puzzle;
    public static ToolsBar toolsBar; // Corrected the class name to match the declaration
    public static ArrayList<Cell> toGuessCell = new ArrayList<>();
    public static Puzzle backup;


    public static boolean isDark = false;

    // Constructor
    public SudokuMain() {
        Repo.repoInit(); // Initialize the repository
        toolsBar = new ToolsBar(); // Create a toolbar
        puzzle = new Puzzle(SudokuDifficulty.EASY); // Create a puzzle with the default difficulty (easy)
        board = new GameBoardPanel(); // Create the game board panel

        backup = puzzle.getSolvedBackUp(); // Backup the solved puzzle for later reference
        add(board, BorderLayout.CENTER); // Add the game board to the center of the frame
        add(toolsBar, BorderLayout.PAGE_END); // Add the toolbar to the bottom of the frame

        // Initialize the game board to start the game

        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set the default close operation
        setResizable(false); // Make the frame not resizable
        setTitle("Sudoku"); // Set the title of the frame
        setVisible(true); // Make the frame visible
    }

    // Start a new game
    public static void newGame() {

        String diff = (String) SudokuMain.toolsBar.jComboBox.getSelectedItem(); // Get the selected difficulty from the toolbar's combo box
        switch (diff) {
            case "MEDIUM":
                puzzle.sudokuDifficulty = SudokuDifficulty.MEDIUM; // Set the puzzle difficulty to medium for the selected level
                break;
            default:
                puzzle.sudokuDifficulty = SudokuDifficulty.EASY; // Set the puzzle difficulty to easy for other levels
                break;
        }
        puzzle.init(); // Initialize the puzzle with the selected difficulty
        backup = puzzle.getSolvedBackUp(); // Backup the solved puzzle for later reference
        board.newGame(); // Start a new game on the game board
    }

    // Solve the puzzle using backtracking algorithm
    public static void backtrackSolve() {
        puzzle.solveSudoku(); // Use the backtracking algorithm to solve the puzzle
    }

    // Switch between dark and light themes
    public static void switchTheme() {
        if (isDark) {
            toolsBar.setBackground(Color.WHITE); // Set the background color of the toolbar to white for light theme
        } else {
            toolsBar.setBackground(new Color(8, 25, 65)); // Set a custom background color for dark theme
        }
        isDark = !isDark; // Toggle the theme flag
        board.newGame(); // Start a new game on the game board with the updated theme
    }
    public static void showAboutInfo() {
        // Ganti path gambar dengan lokasi yang sesuai
        String imagePath = "/Sudoku/ASDFOTO.jpg"; // Ganti sesuai dengan struktur direktori Anda

        // Buat teks HTML dengan gambar di bawahnya
        String aboutText = "<html>This version of the Sudoku game was created by:<br>" +
                "<ul>" +
                "<li>5026221032 - Fadillah Nur Laili</li>" +
                "<li>5026221171 - Muhammad Rafi Novyansyah</li>" +
                "<li>5026221202 - Akbar Daniswara Cahya Buana</li>" +
                "</ul></html>";

        // Create a JPanel to hold the image and text
        JPanel aboutPanel = new JPanel(new BorderLayout());

        // Create a JLabel for the image
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(SudokuMain.class.getResource(imagePath));
        Image scaledImage = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));

        // Create a JTextPane for the HTML text
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(aboutText);
        textPane.setEditable(false);
        textPane.setBackground(aboutPanel.getBackground());

        // Add the image and text to the aboutPanel
        aboutPanel.add(imageLabel, BorderLayout.WEST);
        aboutPanel.add(textPane, BorderLayout.CENTER);

        // Show the aboutPanel in a JOptionPane
        JOptionPane.showMessageDialog(null, aboutPanel, "About", JOptionPane.INFORMATION_MESSAGE);
    }





}
