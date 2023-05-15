package org.example.lineSearch.two_pass_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestWordsOfSeqWords {

    public static void main(String[] args) {
        String[] arr = new String[]{"aa", "bb", "c", "aaa", "a"};
        System.out.println(Arrays.toString(arr));
        System.out.println(solution(arr));
    }

    public static String solution(String[] words) {
        int minlength = words[0].length();

        for (String word : words) {
            if (word.length() < minlength) {
                minlength = word.length();
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() == minlength) {
                ans.add(word);
            }
        }
        return String.join(" ", ans);
    }
}