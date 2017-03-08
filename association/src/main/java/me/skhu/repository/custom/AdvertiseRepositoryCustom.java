package me.skhu.repository.custom;

import java.util.List;

import me.skhu.domain.Advertise;
import me.skhu.util.Pagination;

public interface AdvertiseRepositoryCustom {

	List<Advertise> pagination(Pagination pagination, int categoryId);

	List<Advertise> paginationBySlogan(Pagination pagination, int categoryId);

	List<Advertise> paginationByUserName(Pagination pagination, int categoryId);

	int countByPagination(int cateogryId);

	int countBySlogan(String slogan,int categoryId);

	int countByUserName(String userName, int categoryId);

}