package me.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.skhu.domain.Files;

public interface FilesRepository extends JpaRepository<Files, Integer>{
	List<Files> findByBoardId(int boardId);
	void deleteByBoardId(int boardId);
}
