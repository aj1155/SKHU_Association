package me.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "origin_user")
@Entity
public class OriginUser extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "login_id")
	@NotNull
	private String loginId;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "birth")
	@NotNull
	private String birth;

	@Column(name = "phone_number")
	@NotNull
	private String phoneNumber;

	@Column(name = "company_number")
	private String companyNumber;

	@Column(name = "grade")
	@NotNull
	private int grade;

	@Column(name = "status")
	@NotNull
	private String status;

	@JoinColumn(name = "category_id")
	@NotNull
	@ManyToOne
	private Category category;

	@NotNull
	@Column(name= "user_id")
	private int userId;

	public static OriginUser of(int id, String loginId, String name, String birth, String phoneNumber, String companyNumber, int grade, String status, Category category, int userId){
		return OriginUser.builder()
				.id(id)
				.loginId(loginId)
				.name(name)
				.phoneNumber(phoneNumber)
				.companyNumber(companyNumber)
				.grade(grade)
				.status(status)
				.category(category)
				.userId(userId)
				.build();
	}
}
