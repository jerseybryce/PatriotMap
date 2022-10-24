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

    @Id
    private String userId;
    private String name;
    private String dateJoined;
    private Date date = new Date();
    private String password;
    private String last_access;
    private boolean toggleable_settings;
    /**
     * work in progress
     */
    //TODO: mmake sure you are able to access this.
    private ArrayList<Class> classes;
}
