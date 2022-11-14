package mason.patriotmaps.repository;

import mason.patriotmaps.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    @Query(value = "select obj_description('public.news_table'\\:\\:regclass)", nativeQuery = true)
    String getLastUpdated();
}
