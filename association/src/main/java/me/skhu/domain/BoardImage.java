package me.skhu.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import me.skhu.domain.dto.BoardImageDto;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static me.skhu.domain.QBaseEntity.baseEntity;

/**
 * Created by iljun on 2017-03-03.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = " board_image")
public class BoardImage extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "path")
    private String path;

    @Column(name = "board_post_id")
    private int boardId;

    public static BoardImage of(BoardImageDto boardImageDto){
        return BoardImage.builder()
                .path(boardImageDto.getPath())
                .boardId(boardImageDto.getBoardId())
                .build();
    }

    public static BoardImage of(String path, int boardId){
        return BoardImage.builder()
                .path(path)
                .boardId(boardId)
                .build();
    }

    public static BoardImage of(String path){
        return BoardImage.builder()
                .path(path)
                .boardId(-1)
                .build();
    }
}
