package org.example.contest.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countCountries = Integer.parseInt(reader.readLine());
        int[] minIncomeForCountry = parseIntArray(reader.readLine());
        int[] isEducation = parseIntArray(reader.readLine());
        int[] childNoCond = parseIntArray(reader.readLine());
        int countClassmate = Integer.parseInt(reader.readLine());
        int[] incomeClassmate = parseIntArray(reader.readLine());
        int[] isEducationOfClassmates = parseIntArray(reader.readLine());
        int[] citizenship = parseIntArray(reader.readLine());

        List<Integer> list = new ArrayList<>();

        for (int j = 0; j < countClassmate; j++) {
            for (int i = 0; i < countCountries; i++) {
                if ((incomeClassmate[j] >= minIncomeForCountry[i] && (isEducationOfClassmates[j] == isEducation[i] ||
                        isEducation[i] == 0)) || (childNoCond[i] == 1 && citizenship[j] == i + 1)) {
                    list.add(j, i + 1);
                    break;
                }
            }
            if (list.size() < j + 1) {
                list.add(j, 0);
            }
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static int[] parseIntArray(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        int[] array = new int[tokenizer.countTokens()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
        return array;
    }
}
