package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        MovieListingApp app = new MovieListingApp();

        app.addMovie(new Movie("Interstellar",
                Arrays.asList("Matthew McConaughey", "Anne Hathaway", "Timothée Chalamet", "Matt Damon"),
                "Science Fiction", "2014", 165000000));
        app.addMovie(new Movie("Dune: Part Two",
                Arrays.asList("Timothée Chalamet", "Zendaya", "Rebecca Ferguson", "Florence Pugh", "Austin Butler"),
                "Science Fiction", "2024", 190000000));
        app.addMovie(new Movie("The Dark Knight",
                Arrays.asList("Christian Bale", "Heath Ledger", "Gary Oldman", "Morgan Freeman", "Cillian Murphy"),
                "Action", "2008", 185000000));
        app.addMovie(new Movie("Dredd", Arrays.asList("Karl Urban", "Olivia Thirlby"),
                "Science Fiction", "2012", 30000000));
        app.addMovie(new Movie("Ratsasan", Arrays.asList("Vishnu Vishal", "Amala Paul"),
                "Crime Thriller", "2018", 600000));
        app.addMovie(new Movie("The Lord of the Rings: The Fellowship of the Ring",
                Arrays.asList("Elijah Wood", "Viggo Mortensen", "Ian McKellen", "Orlando Bloom", "Cate Blanchett"),
                "Fantasy", "2001", 93000000));
        app.addMovie(new Movie("Godzilla: King of the Monsters",
                Arrays.asList("Millie Bobby Brown", "Ken Watanabe", "Kyle Chandler"),
                "Science Fiction", "2019", 200000000));

        while(true){
            System.out.print("Welcome to Movie Listing App!\n" +
                    "Please register using email address and name!\n" + "Name: ");
            String name = scn.nextLine();
            System.out.print("Email: ");
            String email = scn.nextLine();

            User user;

            if (app.getExistingUser(email) == null){
                app.registerUser(name, email);
                user = new User(name, email);
            }
            else {
                user = app.getExistingUser(email);
            }
            while (true) {
                System.out.println("Please choose your option: \n" +
                        "1. Search a Movie in the app\n" +
                        "2. See details of a movie\n" +
                        "3. Add a movie to your favorites\n" +
                        "4. Remove a movie from your favorites\n" +
                        "5. See your personal details and favorite movies\n" +
                        "6. Search from favorite movies\n" +
                        "7. Logout\n");
                //int g = scn.nextInt();
                int input = scn.nextInt();

                if (input == 1) {
                    System.out.println("Please enter the title/cast/category of the movie you want to search!\n");
                    String g = scn.nextLine();
                    String query = scn.nextLine();
                    List<Movie> result = app.searchMovies(query);
                    if (result.isEmpty()) {
                        System.out.println("Sorry! The movie does not exist!\n");
                    }
                    else {
                        System.out.println("Search Results: ");
                        for (Movie movie : result) {
                            System.out.println(movie.getTitle());
                        }
                    }
                    System.out.println("\n");
                } else if (input == 2) {
                    System.out.println("Please enter the title of the movie\n");
                    String g = scn.nextLine();
                    String title = scn.nextLine();
                    Movie movie = app.getMovieDetails(title);
                    if (movie == null) {
                        System.out.println("Sorry! This movie does not exist!\n");
                    }
                    else {
                        System.out.println("Title: " + movie.getTitle() + "\n" +
                                "Category: " + movie.getCategory() + "\n" +
                                "Cast :" + movie.getCast() + "\n" +
                                "Release Date: " + movie.getReleaseDate() + "\n" +
                                "Budget: " + movie.getBudget()/1000000 + " Million USD\n");
                    }
                } else if (input == 3) {
                    System.out.println("Please enter the title of the movie\n");
                    String g = scn.nextLine();
                    String title = scn.nextLine();
                    Movie movie = app.getMovieDetails(title);
                    if (movie == null) {
                        System.out.println("Sorry! This movie does not exist!\n");
                    }
                    else {
                        app.addToFavorites(user, movie);
                        System.out.println(movie.getTitle() + " successfully added to your favorites list!\n");
                    }
                } else if (input == 4) {
                    System.out.println("Please enter the title of the movie\n");
                    String g = scn.nextLine();
                    String title = scn.nextLine();
                    Movie movie = app.getMovieDetails(title);
                    if (movie == null) {
                        System.out.println("Sorry! This movie does not exist!\n");
                    }
                    else {
                        app.removeFromFavorites(user, movie);
                        System.out.println(movie.getTitle() + " successfully removed from your favorites list!\n");
                    }
                } else if (input == 5) {
                    System.out.println("Your name: " + name);
                    System.out.println("Your email: " + email);
                    List<Movie> favorites = user.getFavorites();
                    System.out.println("Your favorite movies are: ");
                    for (Movie movie : favorites) {
                        System.out.println(movie.getTitle());
                    }
                    System.out.println("\n");
                } else if (input == 6) {
                    System.out.println("Please enter the title/cast/category of the movie\n");
                    String g = scn.nextLine();
                    String query = scn.nextLine();
                    List<Movie> result = app.searchUserFavorites(user, query);
                    if (result.isEmpty()) {
                        System.out.println("Sorry! This movie does not exist!\n");
                    }
                    else {
                        System.out.println("Search Results: ");
                        for (Movie movie : result) {
                            System.out.println(movie.getTitle());
                        }
                    }
                    System.out.println("\n");
                } else if (input == 7) {
                    System.out.println("Logged out successfully!\n");
                    String g = scn.nextLine();
                    break;
                } else {
                    System.out.println("Please enter a valid option number!\n");
                }
            }
        }
    }
}