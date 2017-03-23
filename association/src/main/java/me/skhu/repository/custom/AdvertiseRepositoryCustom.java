package me.skhu.repository.custom;

import java.util.List;

import me.skhu.domain.Advertise;
import me.skhu.util.Pagination;
import org.joda.time.DateTime;

public interface AdvertiseRepositoryCustom {

	List<Advertise> pagination(Pagination pagination, int categoryId);

	List<Advertise> paginationBySlogan(Pagination pagination, int categoryId);

	List<Advertise> paginationByUserName(Pagination pagination, int categoryId);

	int countByPagination(int cateogryId);

	int countBySlogan(String slogan,int categoryId);

	int countByUserName(String userName, int categoryId);

	List<Advertise> paginationByCompany(Pagination pagination, int categoryId);

	int countByCompany(String company, int categoryId);

}