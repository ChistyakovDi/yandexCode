package org.example.lineSearch;

/*
Дана послудовательность чистел длинной N
Найти последнее(правое) вхождение числа,
если число не встречалось, вывести -1
 */

import java.util.Arrays;

public class LineSearchLastRight {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2, 3, 2, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(solution(arr, 3));
    }
    public static int solution(int[] seq, int x) {
        int answer = -1;

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == x) {
                answer = i;
            }
        }
        return answer;
    }

}

