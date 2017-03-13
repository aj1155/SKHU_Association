package me.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.AdvertiseCategory;
import me.skhu.repository.AdvertiseCategoryRepository;

@Service
public class AdvertiseCategoryService {

	@Autowired
	private AdvertiseCategoryRepository advertiseCategoryRepository;

	public List<AdvertiseCategory> findAll(){
		return advertiseCategoryRepository.findAll();
	}

	public String add(String name){
		AdvertiseCategory advertiseCategory = advertiseCategoryRepository.save(AdvertiseCategory.of(name));
		if(advertiseCategory==null)
			return "false";
		return "success";
	}
}
