package me.skhu.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by iljun on 2017-03-03.
 */
@Getter
@Setter
public class Photo {
    private MultipartFile fileData;
}
