package me.skhu.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by iljun on 2017-02-28.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "introduce")
@Entity
public class Introduce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Lob
    @Column(name="content")
    private String content;

}
