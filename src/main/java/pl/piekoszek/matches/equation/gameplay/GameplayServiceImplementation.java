package pl.piekoszek.matches.equation.gameplay;

import pl.piekoszek.matches.equation.image.ImageService;
import pl.piekoszek.matches.equation.quiz.QuizService;

class GameplayServiceImplementation implements GameplayService {

    private QuizService quizService;
    private ImageService imageService;

    GameplayServiceImplementation(QuizService quizService, ImageService imageService) {
        this.quizService = quizService;
        this.imageService = imageService;
    }

    @Override
    public String randomQuiz() {
        return quizService.randomQuiz();
    }

    @Override
    public byte[] randomQuizImage() { return imageService.drawEquation(quizService.randomQuiz()); }
}
