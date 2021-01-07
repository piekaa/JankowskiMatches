package pl.piekoszek.matches.equation.gameplay;

interface GameplayService {

    String randomQuiz();
    byte[] randomQuizImage();

    byte[] quizImage(String quiz);

    boolean checkSolution(String quiz, String solution);
}