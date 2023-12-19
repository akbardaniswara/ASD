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


import java.util.ArrayList;
import java.util.Scanner;

public class Repo {

    public static ArrayList<String> easy = new ArrayList<>();
    public static ArrayList<String> medium= new ArrayList<>();


    public static void repoInit(){
        Scanner scEasy = new Scanner(Repo.class.getResourceAsStream("easy.txt"));
        Scanner scMedium = new Scanner(Repo.class.getResourceAsStream("medium.txt"));

        while(scEasy.hasNext()){
            easy.add(scEasy.nextLine());
            medium.add(scMedium.nextLine());

        }
    }

}
