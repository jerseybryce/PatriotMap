package mason.patriotmaps.repository;

import mason.patriotmaps.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    @Query(value = "SELECT b.latitude, b.longitude, c.class_id, c.class_name, c.notes, c.prof, c.color, c.time, c.week_days  FROM class_table c JOIN building_table b ON c.building_id = b.building_id WHERE c.class_id = ?1", 
    nativeQuery = true)
    Collection withLocation(Long id);
}
