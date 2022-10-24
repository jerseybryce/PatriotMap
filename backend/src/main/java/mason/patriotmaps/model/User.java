package mason.patriotmaps.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a user of the system.
 */
public class User {
    /**
     * unique indentifier of the user.
     */
    private int userId;
    private String name;
    private String dateJoined;
    private Date date = new Date();
    private String password;
    private String last_access;
    private boolean toggleable_settings;
    private ArrayList<Class> classes;

    public User(int userId, String name, String password){
        this.userId = userId;
        this.name = name;
        this.password = password;
        setDateJoined();
    }

    public String getName() {
        return name;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public Date getDate() {
        return date;
    }

    public String getPassword() {
        return password;
    }

    public String getLast_access() {
        return last_access;
    }

    public boolean isToggleable_settings() {
        return toggleable_settings;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    /**
     * will only be used once in the program,
     * the moment the user creates their account.
     */
    private void setDateJoined(){dateJoined = date.toString();}

    /**
     * This method resets the password of the user
     * @param password newPassword
     */
    public void reSetPassword(String password){this.password = password;}
}
