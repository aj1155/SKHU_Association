package me.skhu.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "login_id")
	@NotNull
	private String loginId;

	@Column(name = "password")
	@NotNull
	private String password;

	@JoinColumn(name = "category_id")
	@NotNull
	@OneToOne
	private Category category;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "birth")
	@NotNull
	private String birth;

	@Column(name = "phone_number")
	@NotNull
	private String phoneNumber;

	@Column(name = "name")
	@NotNull
	private String name;

	public static Admin of(int id, String loginId, String password, Category category, String email, String birth, String phoneNumber, String name){
		return Admin.builder()
				.id(id)
				.loginId(loginId)
				.password(password)
				.category(category)
				.email(email)
				.birth(birth)
				.phoneNumber(phoneNumber)
				.name(name).build();
	}
}
