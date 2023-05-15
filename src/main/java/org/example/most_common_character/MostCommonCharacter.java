package org.example.most_common_character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Дана строка, найти самый встречающийся в ней символ.
Если несколько символов встречаются одинаково часто, то можно вывести любой
#1 Проход по строке для каждого символа в строке       Время - O(N2)  Память - O(N)
#2 Проход по строке для каждого символа в множестве    Время - O(NK)  Память - O(N+K) = O(N)
#3 Проход по строке + проход по ключам в словаре       Время - O(N)  Память - O(K)
 */


class MostCommonCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
//        String str = "abcabcabca";
        System.out.println(solution(str));
    }

    public static String solution(String values) {

        char mostCommon = ' ';
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < values.length(); i++) {

            char nowCount = values.charAt(i);

            if (map.containsKey(nowCount)) {
                int count = map.get(nowCount);
                map.put(nowCount, count + 1);

            } else {
                map.put(nowCount, 1);
            }
        }

        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count > maxCount) {
                maxCount = count;
                mostCommon = key;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return String.valueOf(mostCommon);
    }
}


//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());

//        for (int i = 0; i < array.length; i++) {
//        int nowCount = 0;
//        for (int j = 0; j < array.length; j++) {
//        if (array[i] == array[j]) {
//        nowCount += 1;
//        }
//        }
//        if (nowCount > answerCount) {
//        answer = String.valueOf(array[i]);
//        answerCount = nowCount;
//        }
//        }