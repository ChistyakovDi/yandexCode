package org.example.contest.task2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = reader.readLine().split(" ");
        String[] input2 = reader.readLine().split(" ");

        long N = Long.parseLong(input1[0]),
             X = Long.parseLong(input1[1]),
             T = Long.parseLong(input1[2]);

        Map<Long, List<Integer>> map = new HashMap<>();
        long[] needTime = new long[(int) N];

        for (int i = 0; i < needTime.length; i++) {
            needTime[i] = Math.abs(Integer.parseInt(input2[i]) - X);
            if (map.containsKey(needTime[i])) {
                map.get(needTime[i]).add(i);
            } else {
                int finalI = i;
                map.put(needTime[i], new ArrayList<>() {{
                    add(finalI);
                }});
            }
        }

        Arrays.sort(needTime);

        ArrayList<Integer> result = new ArrayList<>();

        long time = T;
        boolean isTrue = false;
        long lastNeedTime = -1;
        for (int i = 0; i < needTime.length; i++) {
            if (lastNeedTime != needTime[i]) {
                lastNeedTime = needTime[i];
                if (time - needTime[i] >= 0) {
                    isTrue = true;
                    for (int indexOfSculpture : map.get(needTime[i])) {
                        if (time - needTime[i] >= 0) {
                            result.add(indexOfSculpture);
                            time -= needTime[i];
                        } else {
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        if (!isTrue) {
            System.out.println(0);
            return;
        }

        var res = result.toArray();
        int i = 0;
        int[] arr = new int[res.length];
        for (var s : res) {
            arr[i++] = (int) s;
        }
        Arrays.sort(arr);
        System.out.println(arr.length);
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + 1 + " ");
        }
    }
}