package me.skhu.service;

import me.skhu.domain.OriginUser;
import me.skhu.domain.User;
import me.skhu.domain.dto.OriginUserDto;
import me.skhu.repository.OriginUserRepository;
import org.joda.time.DateTime;
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

    public int findCount(int categoryId){
        DateTime dateTime = new DateTime();
        DateTime midNight = dateTime.toDateMidnight().toDateTime();
        DateTime now = DateTime.now();
        return originUserRepository.countToday(categoryId,midNight,now);
    }

    public void save(User user){
        originUserRepository.save(OriginUser.of(user));
    }
}
