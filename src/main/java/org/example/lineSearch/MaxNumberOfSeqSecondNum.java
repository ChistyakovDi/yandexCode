package org.example.lineSearch;


import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
Дана послудовательность чистел длинной N ( N > 1)
Найти максимальное число в последовательности
и второе по величине число(такое, которое будет макс,
если вычеркнуть из последовательности одно максимальное число
 */

public class MaxNumberOfSeqSecondNum {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 1, 4, 3, 2, 5};
        System.out.println(solution(arr));
    }

    public static String solution(int[] seq) {
        /*заведём две переменные для max1 and max2
        Возьмём первые два числа из последовательности и запишем
        большее в max1, меньшее в max2
        Пройдём по всей последовательности. Если очередное число > max1, то запишем
        в max2 значение max1, а в max1 - текущее число. Если только больше max2, то
        запишем текущее число в max2
         */

        int max1 = max(seq[0], seq[1]);
        int max2 = min(seq[0], seq[1]);

        for (int i = 2; i < seq.length; i++) {
            if (seq[i] > max1) {
                max2 = max1;
                max1 = seq[i];
            } else if (seq[i] > max2) {
                max2 = seq[i];
            }
        }
        System.out.println(max1);
        System.out.println(max2);

        return (Arrays.toString(seq));
    }
}


