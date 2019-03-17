package com.work2;
/**
 * MovieCollection är själva databasen.
 * allt sparas genom en arraylist.
 *
 * innehåller flertal metoder som samlar
 * in info från classerna "Movies" och "Genre"
 * och tex ändrar eller tar bort.
 *
 * @author Simon Solum-Faeste
 * @since 2018-10-24
 */

import java.util.ArrayList;
public class MovieCollection {

    private ArrayList<Genre> movieCollection;

    public MovieCollection() {
        this.movieCollection = new ArrayList<Genre>();

    }

    /**
     * kollar om filmer redan existerar i databasen.
     *
     * om filmen finns returnerar metoden "false"
     * finns filmen inte, skickar den "true"
     *
     * True: tar imot ny info och lägger till i databasen
     *
     * @param genre
     * @return
     */
    public boolean addMovie(Genre genre) {
        if (findMovies(genre.getName()) >= 0) {
            System.out.println("Movie already saved!.");
            return false;
        }
        movieCollection.add(genre);
        return true;

    }

    /**
     * letar efter existerande film.
     * om inte, return false
     * finns den, return true
     *
     * True: tar den imot ny info och byter ut gammal data.
     *
     * @param oldMovies
     * @param newMovies
     * @return
     */
    public boolean updateMovie(Genre oldMovies, Genre newMovies) {
        int foundPosition = findMovies(oldMovies);
        if (foundPosition < 0) {
            System.out.println(oldMovies.getName() + " ,not found.");
            return false;
        }

        this.movieCollection.set(foundPosition, newMovies);
        System.out.println(oldMovies.getName() + ", updated with " + newMovies.getName() +" -> "+newMovies.getReleaseDate() +" -> "+ newMovies.getLength() +" -> "+newMovies.getAge() + " -> " +newMovies.getGenreName()+ " -> " + newMovies.getRating());
        System.out.println("What do you want to do next? Press 5 for menu");
        return true;
    }

    /**
     * letar efter existerande filmer.
     *
     * om inte, return false
     * om den finns, return true
     *
     * True: filmen blir "deleted"
     *
     * @param genre
     * @return
     */
    public boolean removeMovie(Genre genre) {
        int foundPosition = findMovies(genre);
        if (foundPosition < 0) {
            System.out.println(genre.getName() + ", not found.");
            return false;
        }
        this.movieCollection.remove(foundPosition);
        System.out.println(genre.getName() + ", has been deleted.");
        System.out.println("What do you want to do next? Press 5 for menu");
        return true;
    }

    /**
     * metoden returnerar info från Genre/movieCollection
     * @param genre
     * @return
     */
    private int findMovies(Genre genre) {
        return this.movieCollection.indexOf(genre);
    }

    /**
     * söker efter existerande filmer
     * @param movieName
     * @return
     */
    private int findMovies(String movieName) {
        for (int i = 0; i < this.movieCollection.size(); i++) {
           Genre genre = this.movieCollection.get(i);
            if (genre.getName().equals(movieName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * söker med hjälp av "findMovies" och returnerar
     * filmens position.
     * @param name
     * @return
     */
    public Genre searchMovies(String name) {
        int position = findMovies(name);
        if (position >= 0) {
            return this.movieCollection.get(position);
        }

        return null;
    }

    /**
     * tar all samlad data och skriver ut det i programmmet
     */
    public void printMovies() {
        System.out.println("Movie list:");
        for (int i = 0; i < this.movieCollection.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.movieCollection.get(i).getName() + " -> " +
                    this.movieCollection.get(i).getReleaseDate() + " -> " +
                    this.movieCollection.get(i).getLength() + " hours -> " +
                    this.movieCollection.get(i).getAge() + " years -> " +
                    this.movieCollection.get(i).getGenreName() + " -> " +
                    this.movieCollection.get(i).getRating());

        }
    }
}


