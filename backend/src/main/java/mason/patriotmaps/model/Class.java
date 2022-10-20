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
}
