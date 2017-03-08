package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.skhu.domain.UserDiscloser;

@Repository
public interface UserDiscloserRepository extends JpaRepository<UserDiscloser, Integer>{

	@Transactional
	void deleteByUserId(int id);

}
