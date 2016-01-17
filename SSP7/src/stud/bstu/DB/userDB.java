package stud.bstu.DB;


/**
 * Created by Leonardo on 07.12.2015.
 */



public class userDB {


    //TODO: add a SQLite database

    public static boolean checkUser( String login, String pas ) {
        //TODO: find a user in DB, if he is find return false
        return login.equals(pas);
    }

    public static String getName(String login, String pas) {
        return "name";
    }

    public static int getLastPoint(String login, String pas) {
        return 0;
    }


    public static void addUser(String userName, String login, String pass ){
    //TODO: add a new user in DB
    }

}
