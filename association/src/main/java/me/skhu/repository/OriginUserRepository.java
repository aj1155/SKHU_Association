package me.skhu.repository;

import me.skhu.domain.OriginUser;
import me.skhu.repository.custom.OriginUserRepositoryCustom;
import me.skhu.util.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by iljun on 2017-02-20.
 */
@Repository
public interface OriginUserRepository extends JpaRepository<OriginUser, Integer>, OriginUserRepositoryCustom{

    Page<OriginUser> findByCategoryId(int categoryId, Pageable pageable);
    Page<OriginUser> findByCategoryIdAndGrade(int categoryId, int grade, Pageable pageable);
    Page<OriginUser> findByCategoryIdAndName(int categoryId, String name, Pageable pageable);
    Page<OriginUser> findByCategoryIdAndBirth(int categoryId, String birth, Pageable pageable);

    public default List<OriginUser>  pagination(Pagination pagination, int categoryId){
        PageRequest pageRequest = new PageRequest(pagination.getCurrentPage() - 1 , pagination.getPageSize(), Sort.Direction.DESC, "id");
        Page<OriginUser> page = this.findAll(pageRequest);

        switch(pagination.getSrchType()){
            case 1 :
                page = this.findByCategoryIdAndGrade(categoryId, Integer.parseInt(pagination.getSrchText()),pageRequest);
                break;
            case 2 :
                page = this.findByCategoryIdAndName(categoryId, pagination.getSrchText(),pageRequest);
                break;
            case 3 :
                page = this.findByCategoryIdAndBirth(categoryId, pagination.getSrchText(),pageRequest);
                break;
            default :
                page = this.findByCategoryId(categoryId,pageRequest);
                break;
        }
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    OriginUser findById(int id);
}
