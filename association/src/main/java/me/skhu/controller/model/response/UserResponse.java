package me.skhu.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.skhu.domain.Position;
import me.skhu.domain.User;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponse {
    private int id;
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


    public static UserResponse ofUser(User user){
        return UserResponse.builder()
                .id(user.getId())
                .loginId(user.getLoginId())
                .name(user.getName())
                .grade(user.getGrade())
                .phoneNumber(user.getPhoneNumber())
                .companyNumber(user.getCompanyNumber())
                .status(user.getStatus())
                .birth(user.getBirth())
                .email(user.getEmail())
                .image(user.getImage())
                //.categoryId(user.getCategoryId())
                .position(user.getPosition())
                .build();
    }
}
