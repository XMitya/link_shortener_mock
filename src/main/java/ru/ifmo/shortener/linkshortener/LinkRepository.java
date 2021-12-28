package ru.ifmo.shortener.linkshortener;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ifmo.shortener.linkshortener.entity.LinkEntity;

@Repository
public interface LinkRepository extends CrudRepository<LinkEntity, String> {
    default boolean insertIfAbsent(@Param("entity") LinkEntity entity) {
        return insertIfAbsent(entity.getShortString(), entity.getLongLink()) > 0;
    }

    @Modifying
    @Query("insert into links (short_string, long_link) values (:shortString, :longLink) on conflict do nothing")
    int insertIfAbsent(String shortString, String longLink);
}
