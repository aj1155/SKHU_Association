package me.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.skhu.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{

	Position findByName(String positionName);

}
