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
        Movie movie = new Movie("Interstellar", Arrays.asList("Matthew McConaughey", "Anne Hathaway", "Timothée Chalamet", "Matt Damon"), "Science Fiction", "2014", 165000000);
        app.addMovie(movie);
        assertEquals(1, app.getMovies().size());
    }

    @Test
    void testGetMovieDetails() {
        MovieListingApp app = new MovieListingApp();
        Movie movie = new Movie("Dune: Part Two", Arrays.asList("Timothée Chalamet", "Zendaya", "Rebecca Ferguson", "Florence Pugh", "Austin Butler"), "Science Fiction", "2024", 190000000);
        app.addMovie(movie);

        Movie retrievedMovie = app.getMovieDetails("Dune: Part Two");
        assertNotNull(retrievedMovie);
        assertEquals("Dune: Part Two", retrievedMovie.getTitle());
        assertEquals(Arrays.asList("Timothée Chalamet", "Zendaya", "Rebecca Ferguson", "Florence Pugh", "Austin Butler"), retrievedMovie.getCast());
        assertEquals("Science Fiction", retrievedMovie.getCategory());
        assertEquals("2024", retrievedMovie.getReleaseDate());
        assertEquals(190000000, retrievedMovie.getBudget());
    }
}

