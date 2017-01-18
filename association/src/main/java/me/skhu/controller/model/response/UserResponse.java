package me.skhu.controller.model.response;

import lombok.*;
import me.skhu.domain.Position;
import me.skhu.domain.User;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
    private Long id;
    private String loginId;
    private String name;
    private int grade;
    private String phoneNumber;
    private String companyNumber;
    private String status;
    private String birth;
    private String email;
    private String image;
    //Todo categoryId 빼고 categoryName으로 데이터 response
    private int categoryId;
    private Position position;

    public UserResponse(User user){
        this.id = user.getId();
        this.loginId = user.getLoginId();
        this.name = user.getName();
        this.grade = user.getGrade();
        this.phoneNumber = user.getPhoneNumber();
        this.companyNumber = user.getCompanyNumber();
        this.status = user.getStatus();
        this.birth = user.getBirth();
        this.email = user.getEmail();
        this.image = user.getImage();
        this.categoryId = user.getCategoryId();
        this.position = user.getPosition();
    }
}
