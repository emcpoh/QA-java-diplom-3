package xxx.models;

public class User {
    private String email;
    private String name;
    private String password;

    public User(String email, String password, String name) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
