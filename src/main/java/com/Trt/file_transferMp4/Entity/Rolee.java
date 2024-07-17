package com.Trt.file_transferMp4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

    public class Rolee implements Serializable {

    @Id
    @SequenceGenerator(name ="role" )
    @GeneratedValue(generator = "role", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String role;



}

