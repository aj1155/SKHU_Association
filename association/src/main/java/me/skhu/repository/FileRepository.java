package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.skhu.domain.Files;

public interface FileRepository extends JpaRepository<Files, Integer>{

}
