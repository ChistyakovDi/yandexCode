package org.example.coderun.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MnogoStulev_324 {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = reader.readLine().split(" ");
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[m];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        input = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());
        int min = Math.min(a.length, b.length);
        long result = 0;
        for (int i = 0; i < min; i++) {
            if ((b[i] - a[i]) < 0) {
                break;
            }
            result = result + (b[i] - a[i]);
        }
        System.out.println(result);

        reader.close();
    }
}

// https://skr.sh/sJqTk6evMJ8

// Пример 1
//Ввод
//2 3
//1 1
//3 3 3
//Вывод
//4
//Пример 2
//Ввод
//6 5
//5 10 8 4 7 2
//3 1 11 18 9
//Вывод
//27