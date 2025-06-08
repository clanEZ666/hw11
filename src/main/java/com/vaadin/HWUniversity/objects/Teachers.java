package com.vaadin.HWUniversity.objects;
import com.vaadin.HWUniversity.DB;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;


public class Teachers {
    public static void createTeacher(String name, String surname, double salary) throws SQLException {
        String sql = "INSERT INTO Teachers (Name, Surname, Salary) VALUES (?, ?, ?)";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Преподаватель добавлен!");
        }
    }
    public static void readTeachers() throws SQLException {
        String sql = "SELECT * FROM Teachers";
        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("Id") +
                                ", Имя: " + rs.getString("Name") +
                                ", Фамилия: " + rs.getString("Surname") +
                                ", Зарплата: " + rs.getDouble("Salary")
                );
            }
        }
    }
    public static void updateTeacher(int id, String newName, String newSurname, double newSalary) throws SQLException {
        String sql = "UPDATE Teachers SET Name = ?, Surname = ?, Salary = ? WHERE Id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setString(2, newSurname);
            stmt.setDouble(3, newSalary);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Преподаватель обновлён!");
        }
    }
    public static void deleteTeacher(int id) throws SQLException {
        String sql = "DELETE FROM Teachers WHERE Id = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Преподаватель удалён!");
        }
    }
}
