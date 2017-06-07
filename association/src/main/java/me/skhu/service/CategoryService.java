package me.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.Category;
import me.skhu.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategory(){
		return categoryRepository.findAll();
	}

	public Category findOne(String categoryName){
		return categoryRepository.findByName(categoryName);
	}

}
