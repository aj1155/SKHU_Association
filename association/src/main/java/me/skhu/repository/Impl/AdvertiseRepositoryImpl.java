package me.skhu.repository.Impl;

import java.util.List;

import me.skhu.domain.QAdvertise;
import me.skhu.domain.QAdvertiseCategory;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import me.skhu.domain.Advertise;
import me.skhu.repository.custom.AdvertiseRepositoryCustom;
import me.skhu.util.Pagination;

public class AdvertiseRepositoryImpl extends QueryDslRepositorySupport implements AdvertiseRepositoryCustom{
	private QAdvertise qAdvertise = QAdvertise.advertise;
	private QAdvertiseCategory qAdvertiseCategory= QAdvertiseCategory.advertiseCategory;

	public AdvertiseRepositoryImpl() {
		super(Advertise.class);
	}

	@Override
	public List<Advertise> pagination(Pagination pagination, int categoryId){
		return from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.category.id.eq(categoryId))
				.orderBy(qAdvertise.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public List<Advertise> paginationBySlogan(Pagination pagination, int categoryId){
		return from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.slogan.eq(pagination.getSrchText()))
				.where(qAdvertise.category.id.eq(categoryId))
				.orderBy(qAdvertise.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public List<Advertise> paginationByUserName(Pagination pagination, int categoryId){
		return from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.userName.eq(pagination.getSrchText()))
				.where(qAdvertise.category.id.eq(categoryId))
				.orderBy(qAdvertise.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public int countByPagination(int categoryId){
		return (int)from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.category.id.eq(categoryId))
				.fetchCount();
	}

	@Override
	public int countBySlogan(String slogan, int categoryId){
		return (int)from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.slogan.eq(slogan))
				.where(qAdvertise.category.id.eq(categoryId))
				.fetchCount();
	}

	@Override
	public int countByUserName(String userName, int categoryId){
		return (int)from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.userName.eq(userName))
				.where(qAdvertise.category.id.eq(categoryId))
				.fetchCount();
	}

	@Override
	public List<Advertise> paginationByCompany(Pagination pagination, int categoryId){
		return from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.company.eq(pagination.getSrchText()))
				.where(qAdvertise.category.id.eq(categoryId))
				.orderBy(qAdvertise.id.desc())
				.offset((pagination.getCurrentPage() - 1 ) * pagination.getPageSize())
				.limit(pagination.getPageSize())
				.fetch();
	}

	@Override
	public int countByCompany(String company, int categoryId){
		return (int)from(qAdvertise)
				.leftJoin(qAdvertise.category,qAdvertiseCategory)
				.where(qAdvertise.category.id.eq(categoryId))
				.where(qAdvertise.company.eq(company))
				.fetchCount();
	}

}
