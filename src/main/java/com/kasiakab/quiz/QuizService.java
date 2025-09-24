package com.kasiakab.quiz;

import java.util.List;

// zadanie: przeprowadzić quiz (zadawać pytania, sprawdzać odpowiedzi, liczyć punkty)
public class QuizService {

    private List<Question> questions;

    public QuizService(List<Question> questions) {
        this.questions = questions;
    }

    public int runQuiz(ConsoleHandler consoleHandler) {
        int score = 0;
        for (Question question : questions) {
            consoleHandler.displayQuestion(question.getQuestion());
            String answer = consoleHandler.getUserAnswer();
            if (answer.equals(question.getAnswer())) {
                score++;
            }
        }
        return score;
    }
}
