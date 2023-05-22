package org.example.coderun.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class awdawdaw {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arrJ = reader.readLine().toCharArray();
        char[] arrS = reader.readLine().toCharArray();

        Set<Character> setJ = new HashSet<>();
        for (char ch: arrJ) {
            setJ.add(ch);
        }

        int sum = 0;
        for (char ch: arrS) {
            if (setJ.contains(ch)) {
                sum += 1;
            }
        }
        writer.write(String.valueOf(sum));

        reader.close();
        writer.close();
    }
}
