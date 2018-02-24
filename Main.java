package Sprint1;

public class Main {

    public static void main(String[] args) {

        Movie[] movie = new Movie[10];

        movie[0] = new Movie("The Open House", "Horror", "Netflix",
                "Mother and son move to a home where eerie and unexplained forces conspire against them.");
        movie[1] = new Movie("Guardians of the Galaxy Vol.2", "Action", "Netflix",
                "Band of miscreants return to unravel the mystery of Peter \"Star Lord\" Quill's origins.");
        movie[2] = new Movie("The Vault", "Horror", "Netflix",
                "A robbery at a haunted bank vault gone wrong.");
        movie[3] = new Movie("Exeter", "Horror", "Hulu",
                "A bloody nightmare at an abandoned asylum.");
        movie[4] = new Movie("The Benchwarmers", "Comedy", "Hulu",
                "Three-man baseball team challenge a squad of elementary school baseballers.");
        movie[5] = new Movie("Daybreakers", "Action", "Hulu",
                "Vampires fight each other for the most precious resource, blood.");
        movie[6] = new Movie("Sin City", "Action", "Hulu",
                "Four tales of crime, murder, revenge and horror play out in a dark, dazzling neo-noir world in this anthology.");
        movie[7] = new Movie("Time Lapse", "Action", "Amazon",
                "Three friends discover a mysterious machine that takes pictures 24 hours into the future.");
        movie[8] = new Movie("A Ghost Story", "Drama", "Amazon",
                "Recently deceased ghost returns home to connect with his wife");
        movie[9] = new Movie("Wonderstruck", "Drama", "Amazon",
                "Ben and Rose are children from two different eras who secretly wish their lives were different.");


        movie = Movie.movieByProvider(movie, "Netflix");

        Movie.printArray(movie);
    }
}
