package com.vaadin;

public class hw1 {
    public static int[] twoArr(int[] one, int[] two) {
        int[] arr3 = new int[one.length + two.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {
            if (one[i] <= two[j]) {
                arr3[k] = one[i];
                i++;
            } else {
                arr3[k] = two[j];
                j++;
            }
            k++;
        }

        while (i < one.length) {
            arr3[k] = one[i];
            i++;
            k++;
        }

        while (j < two.length) {
            arr3[k] = two[j];
            j++;
            k++;
        }

        return arr3;
    }
}

