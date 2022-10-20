package mason.patriotmaps.model;

import java.util.ArrayList;

public class Building {
    private String name;
    //work in progress
    private ArrayList<String> aliases;
    private double latitude;
    private double longitude;

    public Building(String name){
        this.name = name;
    }

    /**
     * Method to add aliases to the building
     * @param name an alias of the building
     */
    public void addAlias(String name){
        aliases.add(name);
    }


}
