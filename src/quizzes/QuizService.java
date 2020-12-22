package quizzes;

public interface QuizService {

    String randomQuiz();

    boolean isSolutionCorrect(String quiz, String solution);

}
