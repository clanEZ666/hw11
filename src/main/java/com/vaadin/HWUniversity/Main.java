package com.vaadin.HWUniversity;
import com.vaadin.HWUniversity.objects.Subjects;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DB.getConnection();
            System.out.println("Подключение успешно!");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }

        try {
            // CREATE
            System.out.println("Добавляем дисциплину...");
            Subjects.createSubject("Математика");
            Subjects.createSubject("Физика");
            Subjects.createSubject("История");

            // READ
            System.out.println("\nСписок дисциплин:");

            // UPDATE
            System.out.println("\nИзменяем дисциплину с ID=2...");
            Subjects.updateSubject(2, "Химия");

            //deLete
            System.out.println("\nУдаляем дисциплину с ID=3...");
            Subjects.deleteSubject(3);


        } catch (SQLException e) {
            System.err.println("Ошибка при работе с базой данных: " + e.getMessage());
        }
    }

}

