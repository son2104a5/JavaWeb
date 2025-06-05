package com.data.repository;

import com.data.model.ScreenRoom;

import java.util.List;

public interface ScreenRoomRepository {
    List<ScreenRoom> getActiveScreenRooms();
    void saveScreenRoom(ScreenRoom screenRoom);
    ScreenRoom getScreenRoomById(Long id);
    void updateScreenRoom(ScreenRoom screenRoom);
    void deleteScreenRoom(ScreenRoom screenRoom);
    void addScreenRoomWithSeat(ScreenRoom screenRoom);
}
