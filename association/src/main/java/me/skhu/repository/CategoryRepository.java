package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByName(String name);

}
