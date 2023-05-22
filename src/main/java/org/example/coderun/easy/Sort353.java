package org.example.coderun.easy;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;



public class Sort353 {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String server = r.readLine();
        String port = r.readLine();
        String a = r.readLine();
        String b = r.readLine();

        URL yahoo = new URL(server + ":" + port + "/?" + "a=" + a + "&b=" + b);
        URLConnection yc = yahoo.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(in);
        for (int i = 0; i < jsonArray.size(); i++) {
            Integer value = ((Long) jsonArray.get(i)).intValue();
            if (value > 0) {
                numbers.add(value);
            }
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);

        for (Integer n : numbers) {
            System.out.println(n);
        }
    }
}

//https://skr.sh/sJxfRH7aHFs
//пример
//https://skr.sh/sJxGT7760na