package com.Trt.file_transferMp4.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "kullanici_tablosu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {


    @Id
    @SequenceGenerator(name = "ad")
    @GeneratedValue(generator = "ad",strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    @Column
    private LocalDateTime acces_time;


    @OneToMany
    @JoinColumn(name = "role_durumu")
    private List<Role> role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FileUploadLog> fileUploadLogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccessRequest> accessRequests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ServerAccess> serverAccessList;


    }

