package comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(2, 3, "Câu hỏi 2"));
        questions.add(new Question(1, 2, "Câu hỏi 1"));
        questions.add(new Question(4, 4, "Câu hỏi 4"));
        questions.add(new Question(3, 1, "Câu hỏi 3"));

        System.out.println("---- BEFORE ----");
        for (Question question : questions) {
            System.out.println("question = " + question);
        }

        Collections.sort(questions);

        System.out.println("---- AFTER ----");
        for (Question question : questions) {
            System.out.println("question = " + question);
        }
    }
}
