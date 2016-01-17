package stud.bstu.model;

import stud.bstu.DB.questionDB;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Leonardo on 15.01.2016.
 */
public class TestedUser extends User {

    private int questionCount;
    private int rightCount;



    public void test() {

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < questionDB.CountOfQuestions(); i++) {

            Question question = questionDB.ReturnQuestionByID(i);
            System.out.println(question.getText());

            System.out.println("You answer :");
            if (question.getAnswer(scan.nextInt()))
                this.rightCount++;
                this.questionCount++;
        }

    }

    public String result() {
        return "You result are " + rightCount + "correct answers from " + questionCount + " answers";
    }

    public void clear() {
        //System.console().clear();
    }


}
