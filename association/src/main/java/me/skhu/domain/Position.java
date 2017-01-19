package me.skhu.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Manki Kim on 2017-01-18.
 */
@Entity
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type")
    private int user_type;

    @Column(name = "name")
    private String name;

}
