package org.example.coderun.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDecryption286 {
    private static Map<Character, Integer> mapChar = new HashMap();
    private static Map<Integer, Character> mapInteger = new HashMap();

    public static void main(String[] args) throws IOException {
        fillMap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] textArray = reader.readLine().split(" ");
        long n = Long.parseLong(reader.readLine());
        List<String> message = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            message.add(reader.readLine());
        }
        reader.close();

        decoder(textArray, message);
    }

    public static void decoder(String[] textArray, List<String> message) {
        Map<String, String> match = new HashMap<>();

        for (String word : textArray) {
            match.put(convertWord(word), word);
        }
        StringBuilder sb = new StringBuilder();

        for (String word : message) {
            String tmp = convertWord(word);
            sb.append(match.get(tmp));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String convertWord(String word) {
        char[] charArray = word.toCharArray();
        int k = 1 - mapChar.get(charArray[0]);
        if (k == 0) {
            return word;
        }
        StringBuilder sb = new StringBuilder();

        for (char ch : charArray) {
            int n = mapChar.get(ch) + k;
            if (n <= 0) {
                n += 26;
            }
            sb.append(mapInteger.get(n));
        }
        return sb.toString();
    }

    private static void fillMap() {
        int i = 1;

        for (char c = 'a'; c <= 'z'; c++) {
            mapChar.put(c, i);
            mapInteger.put(i, c);
            i++;
        }
    }
}
