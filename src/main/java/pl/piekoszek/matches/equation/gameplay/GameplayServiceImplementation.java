package pl.piekoszek.matches.equation.gameplay;

import pl.piekoszek.matches.equation.quiz.QuizService;

class GameplayServiceImplementation implements GameplayService {

    private QuizService quizService;

    GameplayServiceImplementation(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public String randomQuiz() {
        return quizService.randomQuiz();
    }
}
