package ru.ifmo.shortener.linkshortener;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ifmo.shortener.linkshortener.entity.LinkEntity;

@Repository
public interface LinkRepository extends CrudRepository<LinkEntity, String> {
    default int insert(@Param("entity") LinkEntity entity) {
        return insert(entity.getShortString(), entity.getLongLink());
    }

    @Modifying
    @Query("insert into links (short_string, long_link) values (:shortString, :longLink) on conflict do nothing")
    int insert(String shortString, String longLink);
}
