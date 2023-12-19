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


public enum CellStatus {
    GIVEN,         // clue, no need to guess
    TO_GUESS,      // need to guess - not attempted yet
    CORRECT_GUESS, // need to guess - correct guess
    WRONG_GUESS    // need to guess - wrong guess
    // The puzzle is solved if none of the cells have
    //  status of TO_GUESS or WRONG_GUESS
}
