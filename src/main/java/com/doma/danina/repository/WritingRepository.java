package com.doma.danina.repository;

import com.doma.danina.entity.User;
import com.doma.danina.entity.Writing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WritingRepository extends JpaRepository <Writing, Long> {

    @Modifying
    @Query("UPDATE Writing w SET w.title=:newTitle, w.body=:newBody Where w.id=:id")
    int modify(@Param("id") long id, @Param("newTitle") String newTitle, @Param("newBody") String newBody);

    @Modifying
    @Query("DELETE FROM Writing w WHERE w.id=:id")
    int deleteWritingById(@Param("id") long id);

    @Query("SELECT w from Writing w")
    List<Writing> getWritings();

    @Query("SELECT w from Writing w where w.name=:name")
    List<Writing> getWritingsByName(@Param("name") String name);

    @Query("SELECT w from Writing w where w.id=:id")
    Writing getWritingById(@Param("id") Long id);

}
