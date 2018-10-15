package sample;

public class Users {
    private String firstname;
    private String lasttname;
    private String username;
    private String password;
    private String gender;
    private String country;

    public Users(String firstname, String lasttname, String username, String password, String gender, String country) {
        this.firstname = firstname;
        this.lasttname = lasttname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.country = country;
    }

    public Users() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLasttname() {
        return lasttname;
    }

    public void setLasttname(String lasttname) {
        this.lasttname = lasttname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
