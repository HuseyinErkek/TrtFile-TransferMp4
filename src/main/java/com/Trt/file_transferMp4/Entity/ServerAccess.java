package com.Trt.file_transferMp4.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Entity
@Table(name = "sunucu_erisim_izinleri")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServerAccess implements Serializable {

    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(name = "izin")
    @GeneratedValue(generator ="izin", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private boolean approved;



}
