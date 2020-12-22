package quizzes;

public class QuizConfiguration {

    private static QuizService quizService;

    public static QuizService getQuizService() {
        if (quizService == null) {
            quizService = new QuizServiceImplementation(new EquationGenerator());
        }

        return quizService;
    }

}
