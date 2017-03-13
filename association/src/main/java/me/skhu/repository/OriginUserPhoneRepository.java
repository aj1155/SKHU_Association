package me.skhu.repository;

import me.skhu.domain.OriginUserPhone;
import me.skhu.repository.custom.OriginUserPhoneRepositoryCustom;
import me.skhu.util.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by iljun on 2017-02-21.
 */
@Repository
public interface OriginUserPhoneRepository extends JpaRepository<OriginUserPhone, Integer>, OriginUserPhoneRepositoryCustom{

}
