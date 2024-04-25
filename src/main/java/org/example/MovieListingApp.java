package org.example;
import java.util.*;

public class MovieListingApp {
    private List<Movie> movies;
    private List<User> users;

    public MovieListingApp() {
        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Register user with email address
    public void registerUser(String name, String email) {
        users.add(new User(name, email));
    }

    // Get User List
    public List<User> getUsers(){
        return users;
    }
}
