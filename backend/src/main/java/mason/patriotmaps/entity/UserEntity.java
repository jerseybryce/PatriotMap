package mason.patriotmaps.entity;

import mason.patriotmaps.model.Class;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "user_table")
public class UserEntity {
    //this class is used for the database, please all the variables
    //of the user table.
    @Id
    private long userId;
    private String username;
    private String dateJoined;
    private Date date = new Date();
    private String password;
    private String last_access;
    private boolean toggleable_settings;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_access() {
        return last_access;
    }

    public void setLast_access(String last_access) {
        this.last_access = last_access;
    }

    public boolean isToggleable_settings() {
        return toggleable_settings;
    }

    public void setToggleable_settings(boolean toggleable_settings) {
        this.toggleable_settings = toggleable_settings;
    }
    /**
     * work in progress
     */
    //TODO: mmake sure you are able to access this.
}
