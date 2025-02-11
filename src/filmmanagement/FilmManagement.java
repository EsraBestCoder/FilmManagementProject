/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filmmanagement;

/**
 *
 * @author macbookair
 */
public class FilmManagement {

    
    public static void main(String[] args) {
       
         // Film and actor management
        FilmAndActorManagement management = new FilmAndActorManagement();

        // Popularity rankings, revenue simulation, and search functionality classes
        PopularityRankings rankings = new PopularityRankings(20);
        RevenueSimulation revenueSimulation = new RevenueSimulation();
        RevenueHistory revenueHistory = new RevenueHistory();
        SearchFunctionality searchFunctionality = new SearchFunctionality();

        // Sample actors
        Actor[] actors = {
            new Actor("Leonardo DiCaprio", 101),
            new Actor("Kate Winslet", 102),
            new Actor("Brad Pitt", 103),
            new Actor("Angelina Jolie", 104),
            new Actor("Tom Hanks", 105),
            new Actor("Meryl Streep", 106),
            new Actor("Johnny Depp", 107),
            new Actor("Emma Watson", 108),
            new Actor("Robert Downey Jr.", 109),
            new Actor("Scarlett Johansson", 110)
        };

        // Sample films
        Film[] films = {
            new Film("Titanic", 201, "Drama/Romance", 1997),
            new Film("Inception", 202, "Sci-Fi/Thriller", 2010),
            new Film("The Matrix", 203, "Sci-Fi/Action", 1999),
            new Film("Avengers: Endgame", 204, "Action/Sci-Fi", 2019),
            new Film("Forrest Gump", 205, "Drama", 1994),
            new Film("The Godfather", 206, "Crime/Drama", 1972),
            new Film("Pulp Fiction", 207, "Crime/Drama", 1994),
            new Film("The Dark Knight", 208, "Action/Drama", 2008),
            new Film("Fight Club", 209, "Drama/Thriller", 1999),
            new Film("Interstellar", 210, "Sci-Fi/Drama", 2014),
            new Film("The Shawshank Redemption", 211, "Drama", 1994),
            new Film("Gladiator", 212, "Action/Drama", 2000),
            new Film("The Lion King", 213, "Animation/Adventure", 1994),
            new Film("Joker", 214, "Crime/Drama", 2019),
            new Film("Frozen", 215, "Animation/Family", 2013),
            new Film("Toy Story", 216, "Animation/Adventure", 1995),
            new Film("Star Wars: A New Hope", 217, "Sci-Fi/Adventure", 1977),
            new Film("The Avengers", 218, "Action/Sci-Fi", 2012)
        };

        // Adding actors and films
        for (Actor actor : actors) {
            management.addActor(actor);
            searchFunctionality.addActor(actor);
        }

        for (Film film : films) {
            management.addFilm(film);
            searchFunctionality.addFilm(film);
            rankings.addFilm(film);
            revenueSimulation.scheduleFilm(film);
        }

        // Adding feedback
        films[0].addFeedback(5, "A timeless classic!");
        films[1].addFeedback(4, "Incredible concept and execution.");
        films[2].addFeedback(5, "Revolutionary in its genre.");
        films[3].addFeedback(5, "Epic and action-packed.");
        films[4].addFeedback(5, "Heartwarming and inspirational.");
        films[5].addFeedback(4, "A cinematic masterpiece.");
        films[6].addFeedback(4, "Quirky and unpredictable.");
        films[7].addFeedback(5, "A thrilling and intense ride.");
        films[8].addFeedback(4, "Provocative and engaging.");
        films[9].addFeedback(5, "Visually stunning and emotional.");
        films[10].addFeedback(5, "A moving story of hope.");
        films[11].addFeedback(4, "Epic battles and heartfelt moments.");
        films[12].addFeedback(5, "A childhood favorite.");
        films[13].addFeedback(5, "Dark and thought-provoking.");
        films[14].addFeedback(4, "A delightful family adventure.");
        films[15].addFeedback(5, "Timeless and charming.");
        films[16].addFeedback(4, "A groundbreaking sci-fi classic.");
        films[17].addFeedback(5, "Exciting and full of action.");

        // Linking films and actors
        films[0].addActor(actors[0]);
        films[0].addActor(actors[1]);
        films[1].addActor(actors[0]);
        films[2].addActor(actors[2]);
        films[3].addActor(actors[3]);
        films[4].addActor(actors[4]);
        films[5].addActor(actors[5]);
        films[6].addActor(actors[6]);
        films[7].addActor(actors[7]);
        films[8].addActor(actors[8]);
        films[9].addActor(actors[9]);
        films[10].addActor(actors[0]);
        films[11].addActor(actors[1]);
        films[12].addActor(actors[2]);
        films[13].addActor(actors[3]);
        films[14].addActor(actors[4]);
        films[15].addActor(actors[5]);
        films[16].addActor(actors[6]);
        films[17].addActor(actors[7]);

        // Revenue simulation
        revenueSimulation.simulateRevenue(50000, 10.0);
        revenueSimulation.simulateRevenue(30000, 12.5);

        // Recording revenue history
        revenueHistory.recordRevenue(500000);
        revenueHistory.recordRevenue(300000);
        
       


        // Dynamic user operations (example: search operations)
        System.out.println("\n--- Film Search ---");
        searchFunctionality.searchFilm("Titanic");
        searchFunctionality.searchFilm("Unknown Film");

        System.out.println("\n--- Actor Search ---");
        searchFunctionality.searchActor("Leonardo DiCaprio");
        searchFunctionality.searchActor("Unknown Actor");

        // Outputs
        System.out.println("\n--- Actor List ---");
        management.displayAllActors();

        System.out.println("\n--- Film List ---");
        management.displayAllFilms();

        System.out.println("\n--- Popularity Rankings ---");
        rankings.displayPopularityRankings();

        System.out.println("\n--- Revenue History ---");
        revenueHistory.getLastNRevenues(2);

        System.out.println("\n--- All Films (Sorted) ---");
        searchFunctionality.displayAllFilms();

        System.out.println("\n--- All Actors (Sorted) ---");
        searchFunctionality.displayAllActors();
    }
}