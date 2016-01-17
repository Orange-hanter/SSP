package stud.bstu.model;
import stud.bstu.DB.userDB;

/**
 * Created by Leonardo on 07.12.2015.
 */
public class User {
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.name     = name;
        this.login    = login;
        this.password = password;

        userDB.addUser(name,login,password);
    }

    public User() {
        this.name     = "";
        this.login    = "";
        this.password = "";
    }

    public boolean enter(String login, String password) {

        if ( userDB.checkUser(login,password) )
        {
            this.name = userDB.getName(login,password);
            this.login = login;
            this.password = password;

            return true;
        }

        return false;
    }
}