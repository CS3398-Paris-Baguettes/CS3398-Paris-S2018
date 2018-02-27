package Sprint1;



public class Movie {

    private String title;
    private String description;
    private String genre;
    private String provider;

    // constructor for Movie
    Movie(String t, String g, String p, String d) {
        this.title = t;
        this.genre = g;
        this.provider = p;
        this.description = d;
    }

    // this function prints an array of Movie objects for testing purposes
    public static void printArray(Movie[] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                System.out.print("\n\nTitle: " + m[i].title);
                System.out.print("\nGenre: " + m[i].genre);
                System.out.print("\nProvider: " + m[i].provider);
                System.out.print("\nDescription: " + m[i].description);
                count++;
            }
        }
        System.out.print("\n\nThe number of movies listed: " + count);
    }


    // this function returns an array of Movie objects from a specific provider
    public static Movie[] movieByProvider (Movie[] m, String p){
        Movie[] newList = new Movie[m.length];
        int j = 0;
        for (int i = 0; i < newList.length; i++) {
            if (m[i] != null) {
                if (m[i].provider.equals(p)) {
                    newList[j] = m[i];
                    j++;
                }
            }
        }
        return newList;
    }
}
