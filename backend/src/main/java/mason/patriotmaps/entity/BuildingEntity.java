package mason.patriotmaps.entity;
import javax.persistence.*;

@Entity
@Table(name = "building_table")
public class BuildingEntity {
    @Id
    private long building_id;

    private String building_name;

    private String building_akas;

    private long longitude;
    private long latitude;

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public long getBuilding_id() {
        return building_id;
    }

    public String getName() {
        return building_name;
    }

    public void setName(String building_name) {
        this.building_name = building_name;
    }

    public String getAka() {
        return building_akas;
    }

    public void setAka(String building_aka){
        this.building_akas = building_aka;
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
