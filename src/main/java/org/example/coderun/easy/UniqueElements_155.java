package org.example.coderun.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UniqueElements_155 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> unique = new HashMap<>();
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            unique.putIfAbsent(number, 0);
            unique.put(number, unique.get(number) + 1);
            if (unique.get(number) == 1) {
                count++;
            } else if (unique.get(number) == 2) {
                count--;
            }
        }
        System.out.println(count);
    }
}

// https://skr.sh/sJqquanKyTU
// Пример 1
//Ввод
//5
//1 2 3 4 5
//Вывод
//5
//Пример 2
//Ввод
//5
//1 2 3 4 4
//Вывод
//3
//Пример 3
//Ввод
//10
//9 3 10 5 7 6 4 1 2 8
//Вывод
//10