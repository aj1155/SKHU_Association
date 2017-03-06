package me.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name="user_discloser")
@NoArgsConstructor
@AllArgsConstructor
public class UserDiscloser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;


	@Column(name="user_id")
	@NotNull
	private int userId;

	@Column(name="is_phone_number")
	@NotNull
	private boolean isPhoneNumber;

	@Column(name="is_company_number")
	@NotNull
	private boolean isCompanyNumber;

	@Column(name="is_status")
	@NotNull
	private boolean isStatus;

	@Column(name="is_image")
	@NotNull
	private boolean isImage;

	@Column(name="is_email")
	@NotNull
	private boolean isEmail;

	public static UserDiscloser of(int user_id){
		return UserDiscloser.builder()
				.userId(user_id)
				.isPhoneNumber(false)
				.isCompanyNumber(false)
				.isStatus(false)
				.isImage(false)
				.isEmail(false)
				.build();
	}

}
