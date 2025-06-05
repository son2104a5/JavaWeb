package com.data.repository;

import com.data.model.ScreenRoom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ScreenRoomRepositoryImpl implements ScreenRoomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ScreenRoom> getActiveScreenRooms() {
        return em.createQuery("SELECT sr FROM ScreenRoom sr WHERE sr.status = true", ScreenRoom.class)
                 .getResultList();
    }

    @Override
    public void saveScreenRoom(ScreenRoom screenRoom) {
        if (screenRoom.getId() == null) {
            em.persist(screenRoom);
        } else {
            em.merge(screenRoom);
        }
    }

    @Override
    public ScreenRoom getScreenRoomById(Long id) {
        return em.find(ScreenRoom.class, id);
    }

    @Override
    public void updateScreenRoom(ScreenRoom screenRoom) {
        ScreenRoom existingScreenRoom = em.find(ScreenRoom.class, screenRoom.getId());
        if (existingScreenRoom != null) {
            existingScreenRoom.setRoomName(screenRoom.getRoomName());
            existingScreenRoom.setCapacity(screenRoom.getCapacity());
            existingScreenRoom.setStatus(screenRoom.isStatus());
            em.merge(existingScreenRoom);
        }
    }

    @Override
    public void deleteScreenRoom(ScreenRoom screenRoom) {
        ScreenRoom existingScreenRoom = em.find(ScreenRoom.class, screenRoom.getId());
        if (existingScreenRoom != null) {
            em.remove(existingScreenRoom);
        }
    }

    @Override
    public void addScreenRoomWithSeat(ScreenRoom screenRoom) {
        if (screenRoom.getId() == null) {
            em.persist(screenRoom);
        } else {
            em.merge(screenRoom);
        }
    }
}
