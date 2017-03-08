package me.skhu.service;

import me.skhu.domain.OriginUserPhone;
import me.skhu.domain.User;
import me.skhu.domain.dto.UserDto;
import me.skhu.repository.OriginUserPhoneRepository;
import me.skhu.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iljun on 2017-02-21.
 */
@Service
public class OriginUserPhoneService {
    @Autowired
    private OriginUserPhoneRepository originUserPhoneRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    public List<OriginUserPhone> pagination(Pagination pagination){
        int categoryId=adminService.getCurrentAdmin().getCategory().getId();
        pagination.setRecordCount(originUserPhoneRepository.resultCount(pagination,categoryId));
        return originUserPhoneRepository.pagination(pagination,categoryId);
    }

    @Transactional(readOnly = false)
    public void agree(int id){
        OriginUserPhone origin = originUserPhoneRepository.findOne(id);
        origin.setAgree(true);
        originUserPhoneRepository.save(origin);
        User user = userService.findByUserId(origin.getUser().getId());
        user.setLoginId(origin.getLoginId());
        userService.save(user);
    }

    @Transactional(readOnly = false)
    public void agrees(List<Integer> id){
        for(int i : id)
            agree(i);
    }
}
