package mason.patriotmaps.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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

    private String password;



    //I don't really understand Lob but I think this should work?
    //also, this is effectively a foreign key LIST, where
    //each integer represents the primary key of the class in
    //the class entity (table name = "class_table")
    @ElementCollection
    private Collection<Integer> class_list = new ArrayList<Integer>();

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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Collection<Integer> getClass_list()
    {
        return class_list;
    }


    public void addClass(int classId){
        class_list.add(classId);
    }

    public void removeClass(int classId){
        class_list.remove(classId);
    }

}
