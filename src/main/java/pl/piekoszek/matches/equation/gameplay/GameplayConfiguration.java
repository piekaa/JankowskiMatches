package pl.piekoszek.matches.equation.gameplay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.piekoszek.matches.equation.quiz.QuizService;

@Configuration
class GameplayConfiguration {

    @Bean
    GameplayService gameplayService(QuizService quizService) {
        return new GameplayServiceImplementation(quizService);
    }

}
