package com.vaadin.HWUniversity.objects;

import com.vaadin.HWUniversity.DB;

import java.sql.*;
import java.sql.SQLException;

public class Groups {
    public static void createGroup(String name, int year, int departmentId) throws SQLException {
        String sql = "INSERT INTO Groups (Name, Year, DepartmentId) VALUES (?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, year);
            stmt.setInt(3, departmentId);
            stmt.executeUpdate();
            System.out.println("Группа добавлена!");
        }
    }

    public static void readGroups() throws SQLException {
        String sql = "SELECT * FROM Groups";
        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("Id") +
                                ", Название: " + rs.getString("Name") +
                                ", Курс: " + rs.getInt("Year") +
                                ", Кафедра ID: " + rs.getInt("DepartmentId")
                );
            }
        }

    }
    public static void updateGroup(int id, String newName, int newYear, int newDepartmentId) throws SQLException {
        String sql = "UPDATE Groups SET Name = ?, Year = ?, DepartmentId = ? WHERE Id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, newYear);
            stmt.setInt(3, newDepartmentId);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Группа обновлена!");
        }
    }
    public static void deleteGroup(int id) throws SQLException {
        String sql = "DELETE FROM Groups WHERE Id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Группа удалена!");
        }
    }

}