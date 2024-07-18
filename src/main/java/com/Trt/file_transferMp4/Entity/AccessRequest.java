package com.Trt.file_transferMp4.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "sunucu_erisim_talep_istek")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessRequest implements Serializable {

    @Id
    @SequenceGenerator(name ="erisim")
    @GeneratedValue(generator = "erisim", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private String unit_title;

    @Column(nullable = false,unique = true,columnDefinition = "TEXT NOT NULL")
    private String address;



}

