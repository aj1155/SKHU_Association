package me.skhu.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.skhu.domain.Log;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

/**
 * Created by iljun on 2017-06-06.
 */
@Getter
@Setter
@Builder
public class LogDto {

    private String ip;
    private String url;
    private String body;
    private DateTime createdDate;
    private DateTime modifiedDate;

    public static LogDto of(Log log){
        return LogDto.builder()
                .ip(log.getIp())
                .url(log.getUrl())
                .body(log.getBody())
                .createdDate(log.getCreatedDate())
                .modifiedDate(log.getLastModifiedDate())
                .build();
    }
}
