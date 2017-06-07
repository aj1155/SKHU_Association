package me.skhu.domain;

import lombok.*;
import me.skhu.domain.dto.LogDto;

import javax.persistence.*;

/**
 * Created by iljun on 2017-06-06.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "log")
public class Log extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Log_id")
    private Long id;

    @Column(name = "ip")
    private String ip;

    @Column(name= "url")
    private String url;

    @Column(name = "body")
    @Lob
    private String body;

    public static Log of(LogDto logDto){
        return Log.builder()
                .ip(logDto.getIp())
                .url(logDto.getUrl())
                .body(logDto.getBody())
                .build();
    }

    public static Log of(String ip, String url, String body){
        return Log.builder()
                .ip(ip)
                .url(url)
                .body(body)
                .build();
    }
}
