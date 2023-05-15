package org.example.lineSearch;

/*
Дана последовательность чисел длиной N
Найти минимальное четное число в последовательности
или вывести -1,если такого не существует
 */

public class LineSearchMinEvenOfSeq {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 6, 4, 3, 2, 5};
        System.out.println(solution(arr));
    }

    /*
    В переменную для ответа положим -1. Если очередное число четное,а ответ равен -1
    или ответ больше текущего числа, то запишем в ответ текущее число
     */
    public static int solution(int[] seq) {
        int answer = -1;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] % 2 == 0 && (answer == -1 || seq[i] < answer)) {
                answer = seq[i];
            }
        }
        return answer;
    }
}

//    public static int solution(int[] seq) {
//        int answer = -1;
//        boolean flag = false;
//        for (int i = 0; i < seq.length; i++) {
//            if (seq[i] % 2 == 0 && (!flag || seq[i] < answer)) {
//                answer = seq[i];
//                flag = true;
//            }
//        }
//        return answer;
//    }
