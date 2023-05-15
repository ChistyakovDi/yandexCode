package org.example.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class closedKey182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if (b % a != 0) {
            System.out.println(0);
        } else {
            int n = b / a;
            int c = 0;
            int d = 2;
            while (d * d <= n) {
                if (n % d == 0) {
                    while (n % d == 0) {
                        n /= d;
                    }
                    c++;
                }
                d++;
            }
            if (n > 1) {
                c++;
            }
            System.out.println((int) Math.pow(2, c));
        }
    }
}

