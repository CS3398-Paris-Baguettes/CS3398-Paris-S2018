package Sprint1;

public class User {

    private String username;
    private String password;
    private String bio;

    User() {

    }

    User(String un, String pw, String b) {
        this.username = un;
        this.password = pw;
        this.bio = b;
    }


    public static Movie[] userWatched(Movie movie, Movie[] list) {
        int i = 0;
        while (list[i] != null) {
            i++;
        }
        list[i] = movie;
        return list;
    }




}