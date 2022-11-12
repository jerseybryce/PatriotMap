package mason.patriotmaps.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "class_table")
public class ClassEntity {
    @Id
    private long class_id;

    private String class_name;

    //the system i think we should use is this:
    //M T W t F
    //0 1 0 1 0
    //= 2 + 8 = 10
    //(use binary representation) where
    //M=16, T=8, W=4, t=2, F=1
    //though i suppose we could have used smaller datatype
    private int week_days;

    //note: i am not sure if we NEED the foreign key jpa annotation?
    //but that's effectively what this is
    private int building_id;

    private String time;

    public void setColor(ArrayList<Integer> color) {
        this.color = color;
    }

    //[0] = R value [0-255]
    //[1] = G value
    //[2] = B value
    @Lob
    private ArrayList<Integer> color;

    //for notes and descriptions... does this need to be any longer?
    private String notes;

    private String prof;

    public void setClass_id(long class_id) {
        this.class_id = class_id;
    }

    public long getClass_id() {
        return class_id;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setWeek_days(int week_days) {
        this.week_days = week_days;
    }

    public int getWeek_days() {
        return week_days;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    //this doesn't check if the colors are out of bounds
    //but hopefully they'll never be?
    //xd
    public void setColor(int r, int g, int b) {
        this.color.set(0, r);
        this.color.set(1, g);
        this.color.set(2, b);
    }

    public ArrayList<Integer> getColor() {
        return color;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getProf() {
        return prof;
    }
}
