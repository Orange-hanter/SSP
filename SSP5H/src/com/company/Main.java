package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static List<Airline> airlines = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static void menu() {
        System.out.println("List airlines by:");
        System.out.println("1 - destination place");
        System.out.println("2 - departure day of the week");
        System.out.println("3 - plane type");
        System.out.println("4 - passengers count bigger than ... ");
        System.out.println("5 - nothing, just show all");
        System.out.println("6 - planes, in one day");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("type place");
                String place = scanner.next();
                airlines.stream().filter(s -> s.getTo().equals(place)).forEach(System.out::println);
                break;
            case 2:
                System.out.println("type day number");
                int day = scanner.nextInt();
                airlines.stream().filter(s -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(s.getDepartureDate());
                    return cal.get(Calendar.DAY_OF_WEEK) == day;
                }).forEach(System.out::println);
                break;
            case 3:
                System.out.println("type planetype");
                String plane = scanner.next();
                airlines.stream().filter(s -> s.getPlane() == Airplane.valueOf(plane)).forEach(System.out::println);
                break;
            case 4:
                System.out.println("type number");
                int num = scanner.nextInt();
                airlines.stream().filter(s -> s.getPassengers() > num).forEach(System.out::println);
                break;
            case 5:
                airlines.stream().forEach(System.out::println);
                break;
            case 6:
                for (int i = 0; i < airlines.size(); i++) {
                    for (int j = i+1; j < airlines.size(); j++) {
                        if (airlines.get(i).equalsDate( airlines.get(j) ))
                            System.out.println( airlines.get(i).toString() + "\n in one day \n" + airlines.get(j).toString() + "\n" );
                    }
                }
                break;
            default:
                System.out.println("Something bad happened =)");
                break;
        }
    }

    static void serialize(String filename) throws IOException, ParseException {
        Scanner sc = new Scanner(Paths.get(filename));
        while(sc.hasNext()) {
            String entry = sc.nextLine();
            Scanner scl = new Scanner(entry);
            Airline arl = new Airline();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            if(scl.hasNext()) {
                arl.setFrom(scl.next().replace("\"", ""));
                arl.setTo(scl.next().replace("\"", ""));
                arl.setPassengers(Integer.valueOf(scl.next().replace("\"", "")));
                arl.setNumber(scl.next().replace("\"", ""));
                arl.setPlane(Airplane.valueOf(scl.next().replace("\"", "")));
                cal.setTime(sdf.parse(scl.findInLine("\".*?\"").replace("\"", "")));
                arl.setDepartureDate(cal.getTime());
                cal.setTime(sdf.parse(scl.findInLine("\".*?\"").replace("\"", "")));
                arl.setReturnDate(cal.getTime());
            }
            airlines.add(arl);
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
        serialize("./airlines.txt");
        menu();
    }
}
