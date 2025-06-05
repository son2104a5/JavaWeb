package com.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "screen_room")
@Data
public class ScreenRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomName;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String screenType;

    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToMany(mappedBy = "screenRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;
}
