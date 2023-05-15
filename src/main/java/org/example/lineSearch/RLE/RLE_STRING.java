package org.example.lineSearch.RLE;

/*
Есть строка(возможно, пустая) состоящая из букв A-Z: -"AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBB"
Нужно написать функцию RLE, которая на выходе даст строку вида
A4B3C2XYZD4E3F3A6B22
Сгенерирует ошибку, если на вход пришла невалидная строка

Если символ встречается 1 раз, то он остаётся без изменений
Если символ повторяется более 1 раза, то к нему прибавляется количество повторений

Сначала выводим только буквы -> усложнаяем до полного функционала
 */
public class RLE_STRING {
    public static void main(String[] args) {
        String string = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBB";
//        String string = "aabbcaaabb";
//        String string = "";
        System.out.println(solution(string));
    }

    public static String pack(char s, int count) {
        if (count > 1) {
            return s + Integer.toString(count);
        }
        return Character.toString(s);
    }

    public static String solution(String s) {

        String regex = "[^A-Z]+";
        if (s == null || s.equals("") || s.matches(regex)) {

        } else {
            StringBuilder ans = new StringBuilder();
            char lastSymbol = s.charAt(0);
            int lastPosition = 0;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != lastSymbol) {
                    ans.append(pack(lastSymbol, i - lastPosition));
                    lastPosition = i;
                    lastSymbol = s.charAt(i);
                }
            }
            ans.append(pack(s.charAt(lastPosition), s.length() - lastPosition));
            return ans.toString();
        }
        return "Error";
    }
}

