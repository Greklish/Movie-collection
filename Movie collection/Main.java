package com.work2;
/**
 * Filmdatabas med arraylist meny som sparar, visar, uppdaterar och tar bort filmer.
 *
 * @author Simon Solum-Faeste
 * @since 2018-10-24
 */

import java.util.Scanner;
public class Main {

    private static MovieCollection movieCollection = new MovieCollection();
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Main är metoden som kör själva programmet.
     *
     * menyn är uppbyggd med en "While-loop" med "switch".
     * i varje "case" finns det metoder med olika funktioner.
     * dessa är åtkomliga genom ett nummer system 0-5.
     *
     * @param args
     */
    public static void main(String[] args) {

        boolean quit = false;

        printActions();

        while (!quit) {
            int actions = scanner.nextInt();
            scanner.nextLine();
            switch (actions) {

                case 0:
                    quit = true;
                    break;
                case 1:
                    movieCollection.printMovies();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    removeMovie();
                    break;
                case 5:
                    printActions();
                    break;

            }

        }

    }
    /**
     * addmovie metoden samlar in data genom scanner
     * som sedan sparas ner i variabler i classerna
     * Movies och Genre
     * som i sin tur skickar informationen till
     * classen MovieCollection där det sedan sparas.
     *
     */
    private static void addMovie(){
        System.out.println("Title of the movie: ");
        String name = scanner.nextLine();
        System.out.println("What Year was the release?: ");
        String releaseDate = scanner.nextLine();
        System.out.println("Length of the movie: ");
        String length = scanner.nextLine();
        System.out.println("What age restriction: ");
        String age = scanner.nextLine();
        System.out.println("Input genre: ");
        String genreName = scanner.nextLine();
        System.out.println("What do you want to do next? Press 5 for menu");



        Genre newMovie = new Genre(name, releaseDate, length, age, genreName, "");
        movieCollection.addMovie(newMovie);
    }

    /**
     * update metoden söker upp existerande filmer
     * sparade i "MovieCollection".
     * sedan får man ändra alla alternativ.
     *
     * VG: i slutet får man lägga till en "rating" som sparas
     * i "Genre" som i sin skickar info och i sin tur sparas i "MovieCollection".
     */
    private static void updateMovie(){
        System.out.println("Name of the movie you want to change: ");
        String name = scanner.nextLine();

        Genre existingMovieRecord = movieCollection.searchMovies(name);

        if(existingMovieRecord == null){
            System.out.println("Movie could not be found!");
            return;
        }

        System.out.println("Change title: ");
        String newName = scanner.nextLine();
        System.out.println("Release date: ");
        String releaseDate = scanner.nextLine();
        System.out.println("Length: ");
        String length = scanner.nextLine();
        System.out.println("Age restriction: ");
        String age = scanner.nextLine();
        System.out.println("Genre: ");
        String genreName = scanner.nextLine();
        System.out.println("Rate the movie 1-10: ");
        String rating = scanner.nextLine();

        Genre newMovie = Genre.changeMovies(newName, releaseDate, length, age, genreName, rating);



        if(movieCollection.updateMovie(existingMovieRecord,newMovie)){
            System.out.println(" ");
        } else {
            System.out.println("Could not update!");
        }


    }

    /**
     * remove metoden letar upp existernade filmer
     * och tar bort dom från databasen "MovieCollections"
     */
    private static void removeMovie(){
        System.out.println("What movie do you want removed?: ");
        String name = scanner.nextLine();
        Genre existingMovieRecord = movieCollection.searchMovies(name);

        if(existingMovieRecord == null){
            System.out.println("Movie could not be found!");
            return;
        }

        if(movieCollection.removeMovie(existingMovieRecord)){
            System.out.println(" ");
        } else {
            System.out.println("Could not delete!");
        }

    }

    /**
     * printActions metoden är den synliga delen
     * av menyn.
     */
    private static void printActions() {
        System.out.println("\nMenu:");
        System.out.println("0  - Quit\n" +
                "1  - Show Movies\n" +
                "2  - Add Movies\n" +
                "3  - Update movies\n" +
                "4  - Remove existing movies\n" +
                "5  - Show a list over choices");


    }
}