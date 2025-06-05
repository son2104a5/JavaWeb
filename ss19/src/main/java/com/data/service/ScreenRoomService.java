package com.data.service;

import com.data.model.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoom> getActiveScreenRooms();
    void saveScreenRoom(ScreenRoom screenRoom);
    ScreenRoom getScreenRoomById(Long id);
    void updateScreenRoom(ScreenRoom screenRoom);
    void deleteScreenRoom(ScreenRoom screenRoom);
    void addScreenRoomWithSeat(ScreenRoom screenRoom);
}
