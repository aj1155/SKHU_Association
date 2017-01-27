package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Admin findByLoginId(String loginId);
}
