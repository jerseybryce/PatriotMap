package mason.patriotmaps.repository;

import mason.patriotmaps.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    @Query(value = "select obj_description('public.news_table'\\:\\:regclass)", nativeQuery = true)
    String getLastUpdated();

    @Modifying
    @Transactional
    @Query(value = "delete from news_table", nativeQuery = true)
    void clear();

    @Query(value = "comment on table news_table is '?1'", nativeQuery = true)
    void updateDay(String date);
}
