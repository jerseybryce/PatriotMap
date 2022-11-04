package mason.patriotmaps.model;
import java.util.ArrayList;

public class Building {
    private String name;
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
