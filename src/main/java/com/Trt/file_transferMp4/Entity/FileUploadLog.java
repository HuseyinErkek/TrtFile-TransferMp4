package com.Trt.file_transferMp4.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "yukleme_bilgileri")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileUploadLog implements Serializable {

    @Id
    @SequenceGenerator(name="log", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "log", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String fileName;

    @Column
    private LocalDateTime transferTime;

    @Column(nullable = false)
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        transferTime = LocalDateTime.now();
    }
}
