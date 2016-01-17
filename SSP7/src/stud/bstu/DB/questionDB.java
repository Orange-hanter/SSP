package stud.bstu.DB;

import com.sun.org.apache.xerces.internal.xs.StringList;
import stud.bstu.model.Question;

/**
 * Created by Leonardo on 07.12.2015.
 */
public class questionDB {


    public static boolean AddQuestion( String question, String answer, StringList incorrectAnswers)
    {
     return true;
    }

    public static int CountOfQuestions() {
        return 2;
    }

    public static Question ReturnQuestionByID(int ID) {

        return new Question();
    }

}
