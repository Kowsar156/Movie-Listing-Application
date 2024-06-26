package org.example;
import java.util.*;

public class MovieListingApp {
    private List<Movie> movies;
    private List<User> users;

    public MovieListingApp() {
        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Check user's previous registration
    public User getExistingUser(String email){
        for (User u : users){
//            System.out.println(u.getEmail());
//            List<Movie> fav = u.getFavorites();
//            for (Movie m : fav) {
//                System.out.println(m.getTitle());
//            }
            if (u.getEmail().equalsIgnoreCase(email)){
                return u;
            }
        }
        return null;
    }

    // Register user with email address
    public void registerUser(String name, String email) {
        users.add(new User(name, email));
    }

    // Add movie to the app
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    // Get User List
    public List<User> getUsers(){
        return users;
    }

    // Get Movie List
    public List<Movie> getMovies(){
        return movies;
    }

    // Get movie details
    public Movie getMovieDetails(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    // Search all movies matching title, cast, or category
    public List<Movie> searchMovies(String query) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCast().stream().anyMatch(castMember -> castMember.toLowerCase().contains(query.toLowerCase()))) {
                result.add(movie);
            }
        }
        Collections.sort(result, Comparator.comparing(Movie::getTitle));
        return result;
    }


    // Add movie to user's favorites
    public void addToFavorites(User user, Movie movie) {
        user.addFavorite(movie);
    }

    // Remove movie from user's favorites
    public void removeFromFavorites(User user, Movie movie) {
        user.removeFavorite(movie);
    }

    // Search only movies in user's favorites
    public List<Movie> searchUserFavorites(User user, String query){
        List<Movie> favorites = user.getFavorites();
        List<Movie> result = new ArrayList<>();
        for (Movie movie : favorites) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCast().stream().anyMatch(castMember -> castMember.toLowerCase().contains(query.toLowerCase()))) {
                result.add(movie);
            }
        }
        Collections.sort(result, Comparator.comparing(Movie::getTitle));
        return result;
    }
}
