package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void testRegisterUser() {
        MovieListingApp app = new MovieListingApp();
        app.registerUser("test", "test@example.com");
        assertEquals(1, app.getUsers().size());
    }

    @Test
    void testAddMovie() {
        MovieListingApp app = new MovieListingApp();
        Movie movie = new Movie("Interstellar",
                Arrays.asList("Matthew McConaughey", "Anne Hathaway", "Timothée Chalamet", "Matt Damon"),
                "Science Fiction", "2014", 165000000);
        app.addMovie(movie);
        assertEquals(1, app.getMovies().size());
    }

    @Test
    void testGetMovieDetails() {
        MovieListingApp app = new MovieListingApp();
        Movie movie = new Movie("Dune: Part Two",
                Arrays.asList("Timothée Chalamet", "Zendaya", "Rebecca Ferguson", "Florence Pugh", "Austin Butler"),
                "Science Fiction", "2024", 190000000);
        app.addMovie(movie);

        Movie retrievedMovie = app.getMovieDetails("Dune: Part Two");
        assertNotNull(retrievedMovie);
        assertEquals("Dune: Part Two", retrievedMovie.getTitle());
        assertEquals(Arrays.asList("Timothée Chalamet", "Zendaya", "Rebecca Ferguson", "Florence Pugh", "Austin Butler"),
                retrievedMovie.getCast());
        assertEquals("Science Fiction", retrievedMovie.getCategory());
        assertEquals("2024", retrievedMovie.getReleaseDate());
        assertEquals(190000000, retrievedMovie.getBudget());
    }

    @Test
    void testSearchMovies() {
        MovieListingApp app = new MovieListingApp();
        Movie movie1 = new Movie("The Dark Knight",
                Arrays.asList("Christian Bale", "Heath Ledger", "Gary Oldman", "Morgan Freeman", "Cillian Murphy"),
                "Action", "2008", 185000000);
        Movie movie2 = new Movie("The Dark Knight Rises",
                Arrays.asList("Christian Bale", "Tom Hardy", "Anne Hathaway", "Gary Oldman", "Morgan Freeman", "Cillian Murphy"),
                "Action", "2012", 250000000);
        app.addMovie(movie1);
        app.addMovie(movie2);

        List<Movie> searchResults = app.searchMovies("Dark");
        assertEquals(2, searchResults.size());
        assertEquals("The Dark Knight", searchResults.get(0).getTitle());
    }

    @Test
    void testAddFavorites() {
        MovieListingApp app = new MovieListingApp();
        User user = new User("test","test@example.com");
        Movie movie = new Movie("Dredd", Arrays.asList("Karl Urban", "Olivia Thirlby"),
                "Science Fiction", "2012", 30000000);
        app.addToFavorites(user, movie);
        assertEquals(1, user.getFavorites().size());
        assertEquals("Dredd", user.getFavorites().get(0).getTitle());
    }

    @Test
    void testRemoveFavorites() {
        MovieListingApp app = new MovieListingApp();
        User user = new User("test","test@example.com");
        Movie movie = new Movie("Ratsasan", Arrays.asList("Vishnu Vishal", "Amala Paul"),
                "Crime Thriller", "2018", 600000);
        app.addToFavorites(user, movie);
        app.removeFromFavorites(user, movie);
        assertEquals(0, user.getFavorites().size());
    }

    @Test
    void testSearchFavoriteMovies() {
        MovieListingApp app = new MovieListingApp();
        User user = new User("test","test@example.com");
        Movie movie1 = new Movie("The Lord of the Rings: The Fellowship of the Ring",
                Arrays.asList("Elijah Wood", "Viggo Mortensen", "Ian McKellen", "Orlando Bloom", "Cate Blanchett"),
                "Fantasy", "2001", 93000000);
        Movie movie2 = new Movie("The Lord of the Rings: The Two Towers",
                Arrays.asList("Elijah Wood", "Viggo Mortensen", "Ian McKellen", "Orlando Bloom", "Miranda Otto", "Karl Urban"),
                "Fantasy", "2002", 94000000);
        Movie movie3 = new Movie("The Lord of the Rings: The Return of the King",
                Arrays.asList("Elijah Wood", "Viggo Mortensen", "Ian McKellen", "Orlando Bloom", "Karl Urban"),
                "Fantasy", "2003", 94000000);
        app.addToFavorites(user, movie1);
        app.addToFavorites(user, movie2);
        app.addToFavorites(user, movie3);

        List<Movie> searchResults = app.searchUserFavorites(user, "Lord of the Rings");
        assertEquals(3, searchResults.size());
        assertEquals("The Lord of the Rings: The Fellowship of the Ring", searchResults.get(0).getTitle());
    }
}

