package org.example.coderun.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Oshibka_204 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int pA = 0;
        int servers[] = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            servers[i] = a * b;
            pA += servers[i];
        }
        for (double element : servers) {
            System.out.printf("%.12f\n", element / pA);
        }
        reader.close();
    }
}

// https://skr.sh/sJqCDK2Wgnw
// Пример 1
//Ввод
//2
//50 1
//50 2
//Вывод
//0.333333333333
//0.666666666667

//Пример 2
//Ввод
//3
//10 100
//30 10
//60 2
//Вывод
//0.704225352113
//0.211267605634
//0.084507042254
