package com.work2;

/**
 * (VG)"Genre" är en utökning av "Movies"
 * har 2 extra variabler "genreName" och "rating".
 * rating är en extra funktion som bara finns i "update"
 *
 * @author Simon Solum-Faeste
 * @since 2018-10-24
 */
public class Genre extends Movies {
    private String genreName;
    private String rating;

    public Genre(String name, String releaseDate, String length, String age, String genreName, String rating) {
        super(name, releaseDate, length, age, rating);

        this.genreName = genreName;
        this.rating = rating;
    }
    public String getGenreName() {
        return genreName;
    }

    public String getRating() {
        return rating;
    }

    /**
     * denna metoden används i "update()".
     * den har alla "arv" inklusive "rating"
     * @param name
     * @param releaseDate
     * @param length
     * @param age
     * @param genreName
     * @param rating
     * @return
     */
        public static Genre changeMovies(String name, String releaseDate, String length, String age, String genreName, String rating) {
        return new Genre(name, releaseDate, length, age, genreName, rating );

    }
}

