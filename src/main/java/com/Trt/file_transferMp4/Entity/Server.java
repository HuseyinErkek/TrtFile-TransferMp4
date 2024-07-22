package com.Trt.file_transferMp4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "serves_bilgileri")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Server implements Serializable {

    @Id
    @SequenceGenerator(name = "sunucu_bilgileri", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "sunucu_bilgileri", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT NOT NULL")
    private String serverName;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT NOT NULL")
    private String address;

    @Column
    private String ipAdress;

    @Column
    private int port;

    @Column
    private String serverUsername;

    @Column
    private String serverPassword;
}
