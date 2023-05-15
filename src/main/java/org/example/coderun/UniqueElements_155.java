package org.example.coderun;

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