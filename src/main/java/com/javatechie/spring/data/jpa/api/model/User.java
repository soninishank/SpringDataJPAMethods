package com.javatechie.spring.data.jpa.api.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class User {
    @Id
    @GeneratedValue()
    private int id;
    private String name;
    private String profession;
    private int age;
}