package org.example.meetUp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[] platesWidth = new long[n];
        long[] shouldersWidth = new long[m];
        int maxGuardCount = 0;

        for (int i = 0; i < n; i++) {
            platesWidth[i] = scanner.nextLong();
        }
        for (int i = 0; i < m; i++) {
            shouldersWidth[i] = scanner.nextLong();
        }

        long lightMax = platesWidth[n - 1];
        long[] lightWidth = new long[n];
        lightWidth[n - 1] = lightMax;
        int freePlatesCount = 1;

        if (n > 1) {
            for (int i = n - 2; i >= 0; i--) {
                if (platesWidth[i] > lightMax) {
                    lightWidth[i] = platesWidth[i] - lightMax;
                    freePlatesCount += 1;
                    lightMax = platesWidth[i];
                } else {
                    lightWidth[i] = 0;
                }
            }
        } else {
            lightWidth[0] = platesWidth[0];
        }
        Arrays.sort(lightWidth);
        Arrays.sort(shouldersWidth);

        for (int person = m - 1; person >= 0 && maxGuardCount < freePlatesCount; person--) {
            for (int plate = n - 1 - maxGuardCount; plate >= 0; plate--) {
                if (shouldersWidth[person] <= lightWidth[plate]) {
                    maxGuardCount += 1;
                }
                break;
            }
        }
        System.out.println(maxGuardCount);
    }
}


//public class Main {
//    public static void main(String[] args) throws IOException {
//        StreamTokenizer in = new StreamTokenizer(
//                new BufferedInputStream(
//                        new FileInputStream(new File("C:\\input.txt"))));
//        PrintStream out = new PrintStream(new File("C:\\output.txt"));
//        int n,m;
//        in.nextToken();
//        n = (int) in.nval;
//        in.nextToken();
//        m = (int) in.nval;
//        int[] platesWidth = new int[n];
//        int[] shouldersWidth = new int[m];
//        int maxGuardCount = 0;
//
//        for (int i = 0; i < n; i++) {
//            platesWidth[i] = in.nextToken();
//            platesWidth[i] = (int) in.nval;
//        }
//        for (int i = 0; i < m; i++) {
//            shouldersWidth[i] = in.nextToken();
//            shouldersWidth[i] = (int) in.nval;
//
//        }
//
//        int lightMax = platesWidth[n - 1];
//        int[] lightWidth = new int[n];
//        lightWidth[n - 1] = lightMax;
//        int freePlatesCount = 1;
//
//        if (n > 1) {
//            for (int i = n - 2; i >= 0; i--) {
//                if (platesWidth[i] > lightMax) {
//                    lightWidth[i] = platesWidth[i] - lightMax;
//                    freePlatesCount += 1;
//                    lightMax = platesWidth[i];
//                } else {
//                    lightWidth[i] = 0;
//                }
//            }
//        } else {
//            lightWidth[0] = platesWidth[0];
//        }
//        Arrays.sort(lightWidth);
//        Arrays.sort(shouldersWidth);
//
//        for (int person = m - 1; person >= 0 && maxGuardCount < freePlatesCount; person--) {
//            for (int plate = n - 1 - maxGuardCount; plate >= 0; plate--) {
//                if (shouldersWidth[person] <= lightWidth[plate]) {
//                    maxGuardCount += 1;
//                }
//                break;
//            }
//        }
//        out.println(maxGuardCount);
//    }
//}
