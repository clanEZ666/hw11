package com.vaadin;

import static com.vaadin.hw1.twoArr;

public class Main {
    public static void main(String[] args) {
        // Создаём два отсортированных массива
        int[] arr = {-5, 0, 1, 1, 2, 3, 6, 8, 22, 45, 678};
        int[] arr2 = {-10, 2, 3, 6, 7, 7, 7, 9, 11, 1000, 1010, 1100};

        // Вызываем метод twoArr
        int[] arr3 = twoArr(arr, arr2);

        // Выводим результат
        System.out.print("Результат объединения: ");
        for (int num : arr3) {
            System.out.print(num + " ");
        }
    }
}