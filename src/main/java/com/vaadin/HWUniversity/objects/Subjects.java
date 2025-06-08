package com.vaadin.HWUniversity.objects;
import com.vaadin.HWUniversity.DB;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class Subjects {
    public static void createSubject(String name) throws SQLException {
        String sql = "INSERT INTO Subjects (Name) VALUES (?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Дисциплина добавлена!");
        }


    }

    public static void readSubjects() throws SQLException {
        String sql = "SELECT * FROM Subjects";
        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("Id") +
                                ", Название: " + rs.getString("Name")
                );
            }
        }
    }

    public static void updateSubject(int id, String newName) throws SQLException {
        String sql = "UPDATE Subjects SET Name = ? WHERE Id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Дисциплина обновлена!");
        }
    }

    public static void deleteSubject(int id) throws SQLException {
        String sql = "DELETE FROM Subjects WHERE Id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Дисциплина удалена!");
        }
    }

}