package me.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.skhu.domain.Position;
import me.skhu.repository.PositionRepository;

@Service
public class PositionService {

	@Autowired
	PositionRepository positonRepository;

    public List<Position> getUserType(){
    	return positonRepository.findAll();
    }

    public void createType(String type, String name){
    	positonRepository.save(Position.create(type, name));
    }


}
