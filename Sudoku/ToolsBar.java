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

import javax.swing.*;

import static Sudoku.SudokuMain.showAboutInfo;

/**
 * The ToolsBar class represents the toolbar in the Sudoku game.
 * It includes buttons for starting a new game, solving the puzzle, changing the theme,
 * and a combo box for selecting the difficulty level.
 */
public class ToolsBar extends JPanel {
    public JButton btn_newGame;
    public JButton btn_solve;
    public JButton btn_theme;
    public JButton btn_about;
    public JComboBox jComboBox;

    // Constructor
    public ToolsBar() {
        // Create and configure the "Theme" button
        btn_theme = new JButton("THEME");
        btn_theme.setBackground(ToolBarResources.BG_TOOLBAR);
        btn_theme.setForeground(ToolBarResources.FG_TOOLBAR);
        btn_theme.setFont(ToolBarResources.FONT_TOOLBAR);
        btn_theme.addActionListener(e -> {
            SudokuMain.switchTheme(); // Call the switchTheme method in SudokuMain when the "Theme" button is clicked
        });

        // Create and configure the "Solve" button
        btn_solve = new JButton("SOLVE");
        btn_solve.setBackground(ToolBarResources.BG_TOOLBAR);
        btn_solve.setForeground(ToolBarResources.FG_TOOLBAR);
        btn_solve.setFont(ToolBarResources.FONT_TOOLBAR);
        btn_solve.addActionListener(e -> {
            SudokuMain.backtrackSolve(); // Call the backtrackSolve method in SudokuMain when the "Solve" button is clicked
        });

        // Create and configure the "New Game" button
        btn_newGame = new JButton("NEW GAME");
        btn_newGame.setBackground(ToolBarResources.BG_TOOLBAR);
        btn_newGame.setForeground(ToolBarResources.FG_TOOLBAR);
        btn_newGame.setFont(ToolBarResources.FONT_TOOLBAR);
        btn_newGame.addActionListener(e -> {
            SudokuMain.newGame(); // Call the newGame method in SudokuMain when the "New Game" button is clicked
        });

        btn_about = new JButton("ABOUT");
        btn_about.setBackground(ToolBarResources.BG_TOOLBAR);
        btn_about.setForeground(ToolBarResources.FG_TOOLBAR);
        btn_about.setFont(ToolBarResources.FONT_TOOLBAR);
        btn_about.addActionListener(e -> {
            showAboutInfo();
            System.out.println("Full Path to Image: " + getClass().getResource("sudoku/ASDFOTO.jpg"));

        });

        // Create and configure the combo box for selecting difficulty levels
        String[] diff = {"EASY", "MEDIUM"};
        jComboBox = new JComboBox<>(diff);

        // Add components to the toolbar
        add(jComboBox);
        add(btn_newGame);
        add(btn_solve);
        add(btn_theme);
        add(btn_about);
    }
}
