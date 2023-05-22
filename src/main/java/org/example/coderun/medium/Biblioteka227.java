package org.example.coderun.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteka227 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        long k = Long.parseLong(parts[0]);
        long m = Long.parseLong(parts[1]);
        int d = Integer.parseInt(parts[2]);

        System.out.println(solveFast(k, m, d));

        reader.close();
    }


    private static long solveFast(long k, long m, int d) {
        if (d > 5 && m < 3) {
            if (m == 0) return 0;
            if (d != 7) return solveSlow(k, m, d);
        }
        double a = -24.5;
        double b = 5 * k - 3.5;
        double c = m;
        double[] s = solveQuadraticEquation(a, b, c);
        double q = Math.max(s[0], s[1]);
        long numberOfWeek = (long) q;
        long result = numberOfWeek * 7 + 1;
        long perDay;
        double countBeginD = -24.5 * numberOfWeek * numberOfWeek + numberOfWeek * (5 * k - 3.5) + m;
        long countBegin = (long) countBeginD;
        for (int i = 1; i <= 7; i++) {
            perDay = (d > 5 ? 0 : k);
            countBegin = countBegin + perDay - result;
            if (countBegin < 0) {
                break;
            }
            result++;
            d = d % 7 + 1;
        }
        return result - 1;
    }

    private static double[] solveQuadraticEquation(double a, double b, double c) {
        double[] result = new double[2];
        if (b == 0 && c == 0) {
            result[0] = 0;
            return result;
        }
        if (b == 0 && a != 0 && c != 0) {
            double n = -c / a;
            if (n < 0) return null;
            result[0] = Math.sqrt(n);
            result[1] = -result[0];
            return result;
        }
        if (a == 0 && b != 0) {
            result[0] = -c / b;
            return result;
        }
        double d = b * b - 4 * a * c;
        if (d < 0) {
            return null;
        }
        if (d == 0) {
            result[0] = -b / (2 * a);
            return result;
        }
        result[0] = (-b - Math.sqrt(d)) / (2 * a);
        result[1] = (-b + Math.sqrt(d)) / (2 * a);
        return result;
    }


    private static int solveSlow(long k, long m, int d) {
        int count = 0;
        long rest = m;
        long perDay;
        while (rest >= 0) {
            perDay = (d > 5 ? 0 : k);
            count++;
            rest = rest + perDay - count;
            d = d % 7 + 1;
        }
        return count - 1;
    }
}

//https://skr.sh/sJxYyvog2JW
// Пример 1
//Ввод
//4 2 5
//Вывод
//4

//Пример 2
//Ввод
//4 3 5
//Вывод
//5