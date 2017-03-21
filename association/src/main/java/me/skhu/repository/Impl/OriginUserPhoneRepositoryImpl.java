package me.skhu.repository.Impl;

import me.skhu.domain.OriginUserPhone;
import me.skhu.domain.QOriginUserPhone;
import me.skhu.domain.QUser;
import me.skhu.repository.custom.OriginUserPhoneRepositoryCustom;
import me.skhu.util.Pagination;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

/**
 * Created by iljun on 2017-02-23.
 */
public class OriginUserPhoneRepositoryImpl extends QueryDslRepositorySupport implements OriginUserPhoneRepositoryCustom {
    private QOriginUserPhone qOriginUserPhone = QOriginUserPhone.originUserPhone;
    private QUser qUser = QUser.user;

    public OriginUserPhoneRepositoryImpl(){
        super(OriginUserPhone.class);
    }

    @Override
    public List<OriginUserPhone> pagination(Pagination pagination, int categoryId){
        switch(pagination.getSrchType()){
            case 1 :
                return from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.grade.eq(Integer.parseInt(pagination.getSrchText())))
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
                        .limit(pagination.getPageSize())
                        .fetch();
            case 2 :
                return from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.name.eq(pagination.getSrchText()))
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .offset((pagination.getCurrentPage() - 1) * pagination.getPageSize())
                        .limit(pagination.getPageSize())
                        .fetch();
            case 3 :
                return from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.birth.eq(pagination.getSrchText()))
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
                        .limit(pagination.getPageSize())
                        .fetch();
            default :
                return from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
                        .limit(pagination.getPageSize())
                        .fetch();

        }
    }

    @Override
    public int resultCount(Pagination pagination, int categoryId){
        switch(pagination.getSrchType()){
            case 1 :
                return (int)from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.grade.eq(Integer.parseInt(pagination.getSrchText())))
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .fetchCount();
            case 2 :
                return (int)from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.name.eq(pagination.getSrchText()))
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .fetchCount();
            case 3 :
                return (int)from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.birth.eq(pagination.getSrchText()))
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .fetchCount();
            default :
                return (int)from(qOriginUserPhone)
                        .leftJoin(qOriginUserPhone.user,qUser)
                        .where(qUser.category.id.eq(categoryId))
                        .orderBy(qUser.id.desc())
                        .orderBy(qOriginUserPhone.agree.desc())
                        .fetchCount();

        }
    }

    @Override
    public int countBoolean(int categoryId){
        return (int)from(qOriginUserPhone)
                .where(qOriginUserPhone.agree.eq(false))
                .where(qOriginUserPhone.category.id.eq(categoryId))
                .fetchCount();

    }
}
