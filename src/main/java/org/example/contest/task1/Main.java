package org.example.contest.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] inputTwo = reader.readLine().split(" ");
        String[] inputThree = reader.readLine().split(" ");

        int k = Integer.parseInt(reader.readLine());
        String[] inputFive = reader.readLine().split(" ");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(inputTwo[i]);
            int row = Integer.parseInt(inputThree[i]);
            map.put(num, row);
        }

        int counter = 0;
        int lastRow = map.get(Integer.parseInt(inputFive[0]));
        for (int i = 0; i < k; i++) {
            int cur = Integer.parseInt(inputFive[i]);
            if (map.get(cur) != lastRow) {
                lastRow = map.get(cur);
                counter++;
            }
        }
        System.out.println(counter);
    }
}