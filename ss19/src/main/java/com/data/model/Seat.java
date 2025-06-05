package com.data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seatName;

    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "screen_room_id")
    private ScreenRoom screenRoom;
}
