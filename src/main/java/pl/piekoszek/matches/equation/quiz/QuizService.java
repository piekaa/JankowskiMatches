package pl.piekoszek.matches.equation.quiz;

public interface QuizService {

    String randomQuiz();

    boolean isSolutionCorrect(String quiz, String solution);

}
