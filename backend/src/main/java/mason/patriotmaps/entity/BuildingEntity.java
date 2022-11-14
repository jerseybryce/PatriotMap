package mason.patriotmaps.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "building_table")
public class BuildingEntity {
    @Id
    private int building_id;

    @ElementCollection
    private Collection<String> akas = new ArrayList<String>();

    private long longitude;
    private long latitude;

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public Collection<String> getAkas() {
        return akas;
    }

    public void addAka(String name){
        akas.add(name);
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLatitude() {
        return latitude;
    }
}
