package com.ultra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie {


    public static ArrayList<String> moviesList(File file) {

        Scanner fileScanner = null;
        ArrayList moviesArray = new ArrayList<String>();
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        int index = 0;
        while (fileScanner.hasNextLine()) {
            String movie = fileScanner.nextLine();
            if (movie.equals(""))
                continue;
            moviesArray.add(movie);
        }

        return moviesArray;
    }


    public static void printMovie(String movie, int length, char[] movieSoFar) {
        System.out.print("You are guessing:");
        for (int i = 0; i < length; i++) {
            if (movieSoFar[i] == movie.charAt(i))
                System.out.print(movieSoFar[i]);
            else
                System.out.print('_');
        }
        System.out.println();
    }


    public static int containsChar(String movie, char chr) {
        boolean found = false;
        for (int i = 0; i < movie.length(); i++) {
            if (chr == movie.charAt(i)) {
                found = true;
                break;
            }
        }

        return found ? 1 : -1;
    }


    public static char[] fillMovieSoFar(char chr, char[] movieSoFar, String movie) {

        for (int i = 0; i < movie.length(); i++) {
            if (chr == movie.charAt(i))
                movieSoFar[i] = chr;
        }
        return movieSoFar;
    }
}
