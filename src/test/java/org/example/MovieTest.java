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
}

