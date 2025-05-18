package demo.ss09.dao;

import demo.ss09.dao.ScreenRoomDAO;
import demo.ss09.model.ScreenRoom;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static demo.ss09.utils.ConnectionDB.getConnection;

@Repository
public class ScreenRoomDAOImpl implements ScreenRoomDAO {
    @Override
    public List<ScreenRoom> getAllScreenRooms() {
        List<ScreenRoom> rooms = new ArrayList<>();
        String sql = "SELECT * FROM screenRooms";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ScreenRoom room = new ScreenRoom();
                room.setId(rs.getLong("id"));
                room.setScreenRoomName(rs.getString("screenRoomName"));
                room.setTotalSeat(rs.getInt("totalSeat"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
