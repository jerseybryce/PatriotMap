package mason.patriotmaps.model;

import mason.patriotmaps.model.Building;

public class Class {
    private String name;
    private String instructorName;
    private Building location;


    public Class(String name, String instructorName, String location){
        this.name = name;
        this.instructorName = instructorName;
        this.location = new Building(location);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setLocation(Building location) {
        this.location = location;
    }
}
