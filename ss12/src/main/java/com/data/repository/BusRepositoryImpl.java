package com.data.repository;

import com.data.dto.BusDTO;
import com.data.model.Bus;
import com.data.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BusRepositoryImpl implements BusRepository {

    @Override
    public void save(BusDTO bus) {
        String sql = "INSERT INTO bus (license_plate, bus_type, row_seat, col_seat, total_seat, image) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BusDTO bus) {
        String sql = "UPDATE bus SET license_plate=?, bus_type=?, row_seat=?, col_seat=?, total_seat=?, image=? WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bus.getLicensePlate());
            stmt.setString(2, bus.getBusType());
            stmt.setInt(3, bus.getRowSeat());
            stmt.setInt(4, bus.getColSeat());
            stmt.setInt(5, bus.getRowSeat() * bus.getColSeat());
            stmt.setString(6, bus.getImage());
            stmt.setInt(7, bus.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement deleteSeats = conn.prepareStatement("DELETE FROM seat WHERE bus_id = ?");
                 PreparedStatement deleteBus = conn.prepareStatement("DELETE FROM bus WHERE id = ?")) {

                deleteSeats.setInt(1, id);
                deleteSeats.executeUpdate();

                deleteBus.setInt(1, id);
                deleteBus.executeUpdate();

                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bus findById(int id) {
        String sql = "SELECT * FROM bus WHERE id=?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
                return bus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bus> findAll() {
        List<Bus> list = new ArrayList<>();
        String sql = "SELECT * FROM bus";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
                list.add(bus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
