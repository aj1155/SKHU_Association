package me.skhu.repository.Impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.sql.JPASQLQuery;
import me.skhu.domain.QUser;
import me.skhu.domain.User;
import me.skhu.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import javax.persistence.EntityManager;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by iljun on 2017-04-19.
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom{
    private QUser qUser = QUser.user;

    public UserRepositoryImpl(){
        super(QUser.class);
    }
/*
   @Override
    public User findMaxUserNumber(int categoryId){
       JPASQLQuery
        return from(qUser)
               .where(qUser.category.id.eq(categoryId))
               .where(qUser.userNumber.eq(new JPASubQuery()
                                            .from(qUser)
                                            .unique(qUser.userNumber.max())))
                .fetchResults();
    }
    */

    @Override
    public List<User> findByCategoryIdAndImage(int categoryId){
        return from(qUser)
                .where(qUser.category.id.eq(categoryId))
                .where(qUser.image.isNotNull())
                .fetch();
    }
}
