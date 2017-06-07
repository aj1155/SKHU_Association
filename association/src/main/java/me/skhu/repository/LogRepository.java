package me.skhu.repository;

import me.skhu.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by iljun on 2017-06-06.
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long>{
    Log save(Log log);
}
