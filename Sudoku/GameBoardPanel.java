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


import Sudoku.SudokuConstants;
import Sudoku.CellSquareArea;

import java.awt.*;
import javax.swing.*;

public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // Define named constants for UI sizes
    public static final int CELL_SIZE = 55;   // sudoku.view.cell.Cell width/height in pixels
    public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;


    // Board width/height in pixels

    // Define properties
    /** The game board composes of 9x9 Cells (customized JTextFields) */
    private CellSquareArea[][] cellSquareAreas = new CellSquareArea[SudokuConstants.SUBGRID_SIZE][SudokuConstants.SUBGRID_SIZE];
    public GameBoardPanel(){
        init();
    }

    /** Constructor */
    public void init() {
        super.setLayout(new GridLayout(SudokuConstants.SUBGRID_SIZE, SudokuConstants.SUBGRID_SIZE));  // JPanel
        // Allocate the 2D array of sudoku2.view.cell.Cell, and added into JPanel.
        for (int row = 0; row < SudokuConstants.SUBGRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.SUBGRID_SIZE; ++col) {
                cellSquareAreas[row][col] = new CellSquareArea(row, col);
                cellSquareAreas[row][col].setBorder(BorderFactory.createLineBorder(new Color(3, 18, 66),3));
                super.add(cellSquareAreas[row][col]);   // JPanel
            }
        }


        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }
    public void newGame(){
        removeAll();
        init();
        updateUI();
    }
    /**
     * Generate a new puzzle; and reset the gameboard of cells based on the puzzle.
     * You can call this method to start a new game.
     */


    /**
     * Return true if the puzzle is solved
     * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
     */



}
