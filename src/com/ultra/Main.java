package com.ultra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File moviesFile = new File("movies.txt");
        ArrayList<String> movies = Movie.moviesList(moviesFile);
        boolean hasGuessed = false;
        int randomMovieIndex = (int) Math.random() * 25 + 1;
        Scanner in = new Scanner(System.in);

        String movie = movies.get(randomMovieIndex);
        int movieLength = movie.length();
        char[] movieSoFar = new char[movieLength];

        List wrongChars = new ArrayList<Character>();
        int wrongGuesses = 0;


        while (wrongChars.size() <= 10) {
            Movie.printMovie(movie, movieLength, movieSoFar);
            System.out.print("You have guessed (" + (wrongGuesses) + ") wrong letters\t");
            for (int i = 0; i < wrongChars.size(); i++) {
                System.out.print(wrongChars.get(i) + " ");
            }
            System.out.println("\nGuess a letter:");
            String str = in.nextLine();
            char chr = str.charAt(0);
            int containsChar = Movie.containsChar(movie, chr);
            if (containsChar == 1) {
                movieSoFar = Movie.fillMovieSoFar(chr, movieSoFar, movie);
                continue;
            } else {
                wrongChars.add(chr);
                ++wrongGuesses;
                continue;
            }

        }

        if (hasGuessed)
            System.out.println("You have guessed \'" + movie + "\' correctly.");
        else
            System.out.println("Game over ... You have lost!");
    }
}
