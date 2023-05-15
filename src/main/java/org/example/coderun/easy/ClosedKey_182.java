package org.example.coderun.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ClosedKey_182 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        System.out.println(countOfKeys(x, y));
        reader.close();
    }

    public static long countOfKeys(long x, long y) {
        if (y % x != 0) {
            return 0;
        }
        if (x == y) {
            return 1;
        }

        long d = y / x;

        Map<Long, Integer> factor = factorize(d);

        int p = factor.size();

        return (long) Math.pow(2, p);
    }

    public static Map factorize(long x) {

        Map<Long, Integer> map = new HashMap();

        for (int i = 2; i <= Math.sqrt(x) + 1; ++i) {
            int k = 0;
            while ((x % i) == 0) {
                x /= i;
                map.put((long) i, ++k);
            }
        }
        if (x != 1) {
            map.put(x, 1);
        }
        return map;
    }
}

// https://skr.sh/sJqibW868FD
// Пример 1
//Ввод
//5 10
//Вывод
//2
//Пример 2
//Ввод
//10 11
//Вывод
//0
//Пример 3
//Ввод
//527 9486
//Вывод
//4