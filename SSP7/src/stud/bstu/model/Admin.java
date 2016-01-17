package stud.bstu.model;

import com.sun.org.apache.xerces.internal.xs.StringList;
import stud.bstu.DB.questionDB;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Leonardo on 15.01.2016.
 */
public class Admin extends User {

    public static void addQ() {
        Scanner scan= new Scanner(System.in);
        StringList badAnswers = (StringList) new ArrayList<>();

        System.out.println("Write a question: \n");
        String question = scan.next();
        System.out.println("Write a correct answer: \n");
        String answer = scan.next();
        System.out.println("Write a incorrect answers: \n");
        while (scan.hasNext()){
            badAnswers.add(scan.next());
        }

        if (questionDB.AddQuestion(question,answer,badAnswers))
            System.out.println("You question are successful added!");
        else
            System.out.println("ERROR! You question are not added! ");
    }

}
