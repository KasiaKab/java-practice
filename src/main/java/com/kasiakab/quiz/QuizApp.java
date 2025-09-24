package com.kasiakab.quiz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class QuizApp {

    public void run() {

        List<Question> questions = loadQuestionsFromFile("questions.txt");

        ConsoleHandler consoleHandler = new ConsoleHandler();
        QuizService quizService = new QuizService(questions);

        int score = quizService.runQuiz(consoleHandler);
        consoleHandler.showResult(score, questions.size());
        consoleHandler.close();

    }

    private List<Question> loadQuestionsFromFile(String fileName) {

        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        List<String> lines = new BufferedReader(new InputStreamReader(is))
                .lines()
                .collect(Collectors.toList());

        return lines.stream()
                //  | to w wyrażeniach regularnych (regex) specjalny znak, więc musimy go zdublować (\\|)
                .map(line -> line.split("\\|"))
                .filter(parts -> parts.length == 2)
                .map(parts -> new Question(parts[0], parts[1]))
                .collect(Collectors.toList());

                /*
                [linia1, linia2, linia3]
                → stream() → [pyt|odp, pyt|odp, pyt|odp]
                → split("\\|") → [[pyt, odp], [pyt, odp], [pyt, odp]]
                → filter → [[pyt, odp], [pyt, odp]]
                → map → [Question, Question]
                → collect() → List<Question>
                */
    }

}
