package com.Trt.file_transferMp4.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;


@Entity
@Table(name = "sunucu_erisim_izinleri")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServerAccess implements Serializable {


    @Id
    @SequenceGenerator(name = "izin",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator ="izin", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean approved;



}
