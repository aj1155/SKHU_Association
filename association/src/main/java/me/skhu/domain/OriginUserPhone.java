package me.skhu.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by iljun on 2017-02-21.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "origin_user_phone")
@Entity
public class OriginUserPhone  extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "login_id")
    @NotNull
    private String loginId;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(name = "is_agree")
    @NotNull
    private boolean agree;

    @JoinColumn(name = "category_id")
    @NotNull
    @ManyToOne
    private Category category;

    public static OriginUserPhone of(User user){
        return OriginUserPhone.builder()
                .loginId(user.getPhoneNumber())
                .user(user)
                .agree(false)
                .category(user.getCategory())
                .build();
    }
}
