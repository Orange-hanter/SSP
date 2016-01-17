package com.company.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String text = "";
        try {
             text = new String(Files.readAllBytes(Paths.get("rfc2818.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> vocabulary = new TreeMap<>();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            Integer value = vocabulary.get(matcher.group());
            if(value == null) {
                value = 1;
            } else {
                value++;
            }
            vocabulary.put(matcher.group(), value);
        }


        vocabulary.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(20)
                .forEach(e -> System.out.println("" + e.getValue() + " - " + e.getKey()));
    }
}

