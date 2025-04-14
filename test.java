package com.puzzlegame;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();

        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            int m = r.nextInt(arr.length);
            x = arr[i];
            arr[i] = arr[m];
            arr[m] = x;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int[][] abab = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                abab[i][j] = arr[i * 4 + j];
            }
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(abab[i][j] + " ");
            }
            System.out.println();

        }
    }
}
