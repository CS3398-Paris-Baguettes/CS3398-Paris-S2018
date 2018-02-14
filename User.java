package Sprint1;

public class User {

    private String username;
    private String password;
    private String bio;

    public void setPassword(String pw) {
        this.password = pw;
    }
    public void setUsername(String un){
        this.username = un;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }

    public void setBio(String b) {
        this.bio = b;
    }

    public String getBio() {
        return bio;
    }


}