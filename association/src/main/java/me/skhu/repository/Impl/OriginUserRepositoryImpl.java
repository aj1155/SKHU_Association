package me.skhu.repository.Impl;

import me.skhu.domain.OriginUser;
import me.skhu.domain.QOriginUser;
import me.skhu.repository.custom.OriginUserRepositoryCustom;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * Created by iljun on 2017-03-21.
 */
public class OriginUserRepositoryImpl extends QueryDslRepositorySupport implements OriginUserRepositoryCustom{
    private QOriginUser qOriginUser = QOriginUser.originUser;

    public OriginUserRepositoryImpl(){
        super(OriginUser.class);
    }

    @Override
    public int countToday(int categoryId, DateTime today, DateTime now){
        return (int)from(qOriginUser)
                .where(qOriginUser.category.id.eq(categoryId))
                .where(qOriginUser.createdDate.between(today,now))
                .fetchCount();
    }
}
