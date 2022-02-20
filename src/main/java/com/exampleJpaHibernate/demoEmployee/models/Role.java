package com.exampleJpaHibernate.demoEmployee.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@Data
@ToString
@EqualsAndHashCode
@Entity
public class Role {

    @Id
    /*
    * GenerationType.AUTO -> GenerationType.AUTO then by default hibernate uses hibernate_sequence for the sequence which is used by all tables and only one sequence value can be consumed at a time which means if sequence 1 is used then it can not be used anywhere else.
    * GenerationType.IDENTITY -> GenerationType.IDENTITY the ids are only unique for that particular column. (Test DB - MySQL)
    * */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

}
