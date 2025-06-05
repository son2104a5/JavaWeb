package com.data.service;

import com.data.model.ScreenRoom;
import com.data.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomServiceImpl implements ScreenRoomService{
    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    @Override
    public List<ScreenRoom> getActiveScreenRooms() {
        return screenRoomRepository.getActiveScreenRooms();
    }

    @Override
    public void saveScreenRoom(ScreenRoom screenRoom) {
        screenRoomRepository.saveScreenRoom(screenRoom);
    }

    @Override
    public ScreenRoom getScreenRoomById(Long id) {
        return screenRoomRepository.getScreenRoomById(id);
    }

    @Override
    public void updateScreenRoom(ScreenRoom screenRoom) {
        screenRoomRepository.updateScreenRoom(screenRoom);
    }

    @Override
    public void deleteScreenRoom(ScreenRoom screenRoom) {
        ScreenRoom existingScreenRoom = screenRoomRepository.getScreenRoomById(screenRoom.getId());
        if (existingScreenRoom != null) {
            screenRoomRepository.deleteScreenRoom(existingScreenRoom);
        }
    }

    @Override
    public void addScreenRoomWithSeat(ScreenRoom screenRoom) {
        screenRoomRepository.addScreenRoomWithSeat(screenRoom);
    }
}
