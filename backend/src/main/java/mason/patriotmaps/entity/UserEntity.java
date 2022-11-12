package mason.patriotmaps.entity;

import mason.patriotmaps.model.Class;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name = "user_table")
public class UserEntity {
    //this class is used for the database, please all the variables
    //of the user table.

    //note: psql version of long is ="bigint"
    @Id
    @GeneratedValue(generator ="emp_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "emp_seq", sequenceName = "emp_sequence", initialValue = 0, allocationSize = 1)
    private long userId;

    private String username;

    //why make String if could be Date?
    private String dateJoined;

    //this is not something we need to store in the database-
    //its usage can be called live and does not need to be accessed
    //(as opposed to the date joined, and last access timestamp)
    private Date date = new Date();

    private String password;

    private String last_access;

    //the reason why this is made to be an int[]
    //rather than an ArrayList<Integer> is because, in theory,
    //we shouldn't be appending any additional settings,
    //but rather only changing (or reading from) a list of predefined ones
    @Lob
    private ArrayList<Integer> toggleable_settings;

    //I don't really understand Lob but I think this should work?
    //also, this is effectively a foreign key LIST, where
    //each integer represents the primary key of the class in
    //the class entity (table name = "class_table")
    @Lob
    private ArrayList<Integer> class_list;

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

    public ArrayList<Integer> getClass_list()
    {
        return class_list;
    }

    public ArrayList<Integer> getToggleable_settings() {
        return toggleable_settings;
    }

    public void addClass(int classId){
        class_list.add(classId);
    }

    public void removeClass(int classId){
        class_list.remove(classId);
    }

    //TODO: figure out what settings are supposed to be toggleable (and add setter methods for them specifically!)
    //most of which I figure will be display options for the map itself:
    //class name shown (CS321), building name shown (peterson), time shown (12:00pm), etc
}
