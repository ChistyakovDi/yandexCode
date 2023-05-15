package org.example.coderun.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ChastyElement360 {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        String[] parts = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(solveSimple(a));

        reader.close();
    }

    public static int solveSimple(int[] a) {
        int ans = 0;
        Arrays.sort(a);
        int count = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            count++;
            if ((i == a.length-1) || (a[i] != a[i+1])) {
                if (count >= max) {
                    max = count;
                    ans = a[i];
                }
                count = 0;
            }
        }
        return ans;
    }
}


// https://skr.sh/sJqxKEtkbGv