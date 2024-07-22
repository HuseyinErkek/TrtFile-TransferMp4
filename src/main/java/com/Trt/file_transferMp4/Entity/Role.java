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
    @SequenceGenerator(name ="role", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "role", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String rolename;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "role_durumu")
    private User user;
}
