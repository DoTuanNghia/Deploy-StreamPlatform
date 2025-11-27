package com.stream.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tblstream")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "keyStream", nullable = false, length = 255)
    private String keyStream;

    @Column(name = "timeStart")
    private LocalDateTime timeStart;   // map với DATETIME

    @Column
    private Integer duration;          // phút / giây tuỳ bạn quy ước

    // 1 Channel có N Stream
    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    // 1 Stream có 1 StreamSession
    @OneToOne(mappedBy = "stream")
    private StreamSession streamSession;
}
