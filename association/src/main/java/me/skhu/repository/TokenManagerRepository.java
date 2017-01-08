package me.skhu.repository;

import me.skhu.domain.TokenManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by USER on 2017-01-06.
 */
@Repository
public interface TokenManagerRepository extends JpaRepository<TokenManager, Long> {

    @Modifying
    @Transactional
    @Query(value="update token_manager t set t.token=?1 where t.facebook_id=?2",nativeQuery=true)
    void setFixedTokenFor(String token, String facebookId);

    TokenManager findByFacebookId(@Param("facebookId") String facebookId);
}
