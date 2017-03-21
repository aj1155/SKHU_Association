package me.skhu.repository.custom;

import me.skhu.domain.OriginUserPhone;
import me.skhu.util.Pagination;

import java.util.List;

/**
 * Created by iljun on 2017-02-23.
 */
public interface OriginUserPhoneRepositoryCustom {
    List<OriginUserPhone> pagination(Pagination pagination, int categoryId);
    int resultCount(Pagination pagination, int categoryId);
    int countBoolean(int categoryId);
}
