package org.example.lineSearch;

import java.util.Arrays;

/*
Дана послудовательность чистел длинной N ( N > 0)
Найти максимальное число в последовательности
 */
public class MaxNumberOfSeq {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 3, 1, 2, 3, 2, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println(solution(arr));
    }

    public static int solution(int[] seq) {
        //кладём в ответ нулевой элемент последовательности
        int answer = 0;
        //далее перебираем все элементы
        //если текущий элемент больше ответа - запишем в ответ текущий элемент
        //если i=1 экономим 1 действие
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] > seq[answer]) {
                answer = i;
            }
        }
        return seq[answer];
    }
}


//    public static int solution(int[] seq) {
//        //кладём в ответ нулевой элемент последовательности
//        int answer = seq[0];
//        //далее перебираем все элементы
//        //если текущий элемент больше ответа - запишем в ответ текущий элемент
//        //если i=1 экономим 1 действие
//        for (int i = 1; i < seq.length; i++) {
//            if (seq[i] > answer) {
//                answer = seq[i];
//            }
//        }
//        return answer;
//    }