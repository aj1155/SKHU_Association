package me.skhu.service;

import me.skhu.domain.dto.OriginUserDto;
import me.skhu.repository.OriginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by iljun on 2017-02-21.
 */
@Service
public class OriginUserService {
    @Autowired
    private OriginUserRepository originUserRepository;

    public OriginUserDto findById(int id){
        return OriginUserDto.of(originUserRepository.findById(id));
    }
}
