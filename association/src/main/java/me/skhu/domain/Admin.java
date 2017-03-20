package me.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skhu.domain.dto.AdminDto;

@Getter
@Setter
@Builder
@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
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
				.name(name)
				.build();
	}

	public static Admin create(AdminDto adminDto,Category category, String passwd){
		return Admin.builder()
				.loginId(adminDto.getLoginId())
				.password(passwd)
				.category(category)
				.email(adminDto.getEmail())
				.birth(adminDto.getBirth())
				.phoneNumber(adminDto.getPhoneNumber())
				.name(adminDto.getName())
				.build();
	}

	public static Admin of(AdminDto adminDto, Category category){
		return Admin.builder()
				.loginId(adminDto.getLoginId())
				.password(adminDto.getPassword())
				.category(category)
				.email(adminDto.getEmail())
				.birth(adminDto.getBirth())
				.phoneNumber(adminDto.getPhoneNumber())
				.name(adminDto.getName())
				.build();
	}
}
