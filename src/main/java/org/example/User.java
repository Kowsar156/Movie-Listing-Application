package org.example;
import java.util.*;

public class User {
    private String name;
    private String email;
    private List<Movie> favorites;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.favorites = new ArrayList<>();
    }

    // Add movie to favorites
    public void addFavorite(Movie movie) {
        favorites.add(movie);
    }

    // Remove movie from favorites
    public void removeFavorite(Movie movie) {
        favorites.remove(movie);
    }

    // Get user's favorites
    public List<Movie> getFavorites() {
        return favorites;
    }

    // Get user's email
    public String getEmail() {
        return email;
    }
}
