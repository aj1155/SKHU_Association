package me.skhu.repository;

import me.skhu.domain.Introduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by iljun on 2017-02-28.
 */
@Repository
public interface IntroduceRepository extends JpaRepository<Introduce,Integer>{
    Introduce findById(int id);
    Introduce save(Introduce introduce);

    @Query("SELECT max(t.id) FROM Introduce t")
    Integer getMaxId();

}
