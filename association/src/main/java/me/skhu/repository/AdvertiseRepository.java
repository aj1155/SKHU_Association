package me.skhu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Advertise;
import me.skhu.repository.custom.AdvertiseRepositoryCustom;
import me.skhu.util.Pagination;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise,Integer>, AdvertiseRepositoryCustom{
	@Override
	List<Advertise> findAll();

	public default List<Advertise> findAll(Pagination pagination){
		PageRequest pageRequest = new PageRequest(pagination.getCurrentPage() - 1 , pagination.getPageSize(), Sort.Direction.DESC, "id");
		Page<Advertise> page = this.findAll(pageRequest);
		pagination.setRecordCount((int)page.getTotalElements());
		return page.getContent();
	}

	void deleteByCategoryId(int categoryId);
}
