package me.skhu.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.skhu.domain.dto.AdvertiseDto;

@Getter
@Setter
@Builder
@Entity
@Table(name = "advertise")
@AllArgsConstructor
@NoArgsConstructor
public class Advertise {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "image")
	private String image;

	@Column(name = "advertising_slogan")
	private String slogan;

	@Column(name = "company")
	private String company;

	@Lob
	@NotNull
	@Column(name = "content")
	private String content;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "start_Date")
	private Date startDate;

	@Column(name = "end_Date")
	private Date endDate;

	@JoinColumn(name = "category_id")
	@ManyToOne
	private AdvertiseCategory category;

	@Column(name = "user_name")
	private String userName;

	static SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static Advertise of(AdvertiseDto advertiseDto,AdvertiseCategory category,String image) throws ParseException{
		return Advertise.builder()
				.image(image)
				.slogan(advertiseDto.getSlogan())
				.company(advertiseDto.getCompany())
				.content(advertiseDto.getContent())
				.phoneNumber(advertiseDto.getPhoneNumber())
				.startDate(transFormat.parse(advertiseDto.getStartDate()))
				.endDate(transFormat.parse(advertiseDto.getEndDate()))
				.userName(advertiseDto.getUserName())
				.category(category)
				.build();
	}

	public String getContent(){
		return this.content;
	}

	public void setContent(String content){
		this.content = content;
	}
}
