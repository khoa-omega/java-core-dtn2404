package comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, 3, "Câu hỏi 2"));
        questions.add(new Question(1, 2, "Câu hỏi 1"));
        questions.add(new Question(2, 1, "Câu hỏi 3"));
        questions.add(new Question(2, 4, "Câu hỏi 4"));

        System.out.println("---- BEFORE ----");
        for (Question question : questions) {
            System.out.println("question = " + question);
        }

        // Method reference
        Comparator<Question> comparator = Comparator
                .comparingInt(Question::getId)
                .thenComparingDouble(Question::getScore);
        Collections.sort(questions, comparator);

        System.out.println("---- AFTER ----");
        for (Question question : questions) {
            System.out.println("question = " + question);
        }
    }
}
