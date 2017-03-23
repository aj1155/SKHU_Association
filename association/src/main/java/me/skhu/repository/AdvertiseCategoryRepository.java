package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.AdvertiseCategory;

@Repository
public interface AdvertiseCategoryRepository extends JpaRepository<AdvertiseCategory,Integer>{
	AdvertiseCategory findById(int id);
	AdvertiseCategory save(AdvertiseCategory advertiseCategory);
	AdvertiseCategory findByName(String name);
	void delete(AdvertiseCategory advertiseCategory);
}
