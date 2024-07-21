package com.Trt.file_transferMp4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sunucu_erisim_talep_istek")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessRequest implements Serializable {

    @Id
    @SequenceGenerator(name ="erisim", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "erisim", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private String unitTitle;

    @Column(nullable = false, columnDefinition = "TEXT NOT NULL")
    private String serverName;

    @Column
    private LocalDateTime requestTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        requestTime = LocalDateTime.now();
    }
}
