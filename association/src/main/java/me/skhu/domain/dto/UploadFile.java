package me.skhu.domain.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadFile {
	private String name;
	private CommonsMultipartFile fileData;
}
