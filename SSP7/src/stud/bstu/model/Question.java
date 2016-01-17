package stud.bstu.model;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.Random;

/**
 * Created by Leonardo on 07.12.2015.
 */
public class Question {

    private String question;
    private int indexOfTrueAnswer;


    public void newQuestion( String question, String answer, StringList badAnswers) {

        this.question= question + "\n";
        indexOfTrueAnswer = new Random().nextInt( badAnswers.getLength() + 1 );

        for (int i = 0; i < badAnswers.getLength() + 1; i++) {
            if (indexOfTrueAnswer == i) {
                //this.answers.add(answer);
                this.question += i + answer + "\n";
                continue;
            }
            //this.answers.add(badAnswers.item(i));
            this.question += i + badAnswers.item(i) + "\n";
        }


    }

    public String getText() {
        return question;
    }

    public boolean getAnswer( int answer) {
        if (answer == indexOfTrueAnswer)
            return true;
        return false;
    }

}
