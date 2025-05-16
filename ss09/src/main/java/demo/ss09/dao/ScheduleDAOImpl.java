package demo.ss09.dao;

import demo.ss09.model.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static demo.ss09.utils.ConnectionDB.getConnection;

public class ScheduleDAOImpl implements ScheduleDAO{
    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        List<Schedule> schedules = new ArrayList<>();
        String sql = "SELECT * FROM schedules WHERE movieId = ? ORDER BY showTime ASC";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setMovieId(rs.getLong("movieId"));
                schedule.setShowTime(rs.getTimestamp("showTime"));
                schedule.setScreenRoomId(rs.getLong("screenRoomId"));
                schedule.setAvailableSeats(rs.getInt("availableSeats"));
                schedule.setFormat(rs.getString("format"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
}
