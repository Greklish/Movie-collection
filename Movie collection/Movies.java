package com.work2;

/**
 * Alla variabler samlas här.
 * sparar data genom dessa från tex "addMovie"
 * alla filmer som görs ärver(inheritence) från dessa.
 *
 * @author Simon Solum-Faeste
 * @since 2018-10-24
 */
public class Movies {

    private String name;
    private String releaseDate;
    private String length;
    private String age;

    /**
     * lägger in alla variabler i metoden så att
     * all data är sparad i 1 object.
     *
     * @param name
     * @param releaseDate
     * @param length
     * @param age
     * @param rating
     */
    public Movies(String name, String releaseDate, String length, String age, String rating) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.length = length;
        this.age = age;

    }

    /**
     * alla variabler har en "get" metod
     * som returnerar.
     * @return
     */
    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getLength() {
        return length;
    }

    public String getAge() {
        return age;
    }



}



