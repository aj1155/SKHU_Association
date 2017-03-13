package me.skhu.service;

import me.skhu.domain.Introduce;
import me.skhu.domain.dto.IntroduceDto;
import me.skhu.repository.IntroduceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iljun on 2017-02-28.
 */
@Service
public class IntroduceService {

    @Autowired
    private IntroduceRepository introduceRepository;

    public IntroduceDto find(){
        System.out.println(introduceRepository.getMaxId());
        return IntroduceDto.of(introduceRepository.findById(introduceRepository.getMaxId()));
    }

    @Transactional(readOnly = false)
    public void save(Introduce introduce){
        introduceRepository.save(introduce);
    }
}
