package mason.patriotmaps.model;

import java.util.ArrayList;

public class Class {
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

    private ArrayList<Integer> color;

    //for notes and descriptions... does this need to be any longer?
    private String notes;

    private String prof;

    public long getClass_id() {
        return class_id;
    }

    public void setClass_id(long class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getWeek_days() {
        return week_days;
    }

    public void setWeek_days(int week_days) {
        this.week_days = week_days;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<Integer> getColor() {
        return color;
    }

    public void setColor(ArrayList<Integer> color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}
