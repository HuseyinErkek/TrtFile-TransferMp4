package com.Trt.file_transferMp4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Entity
@Table(name = "rolee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

    public class Role implements Serializable {

    @Id
    @SequenceGenerator(name ="role" )
    @GeneratedValue(generator = "role", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String username;


    @ManyToOne
    @JoinColumn(name= "role_durumu")
    private User user;




}

