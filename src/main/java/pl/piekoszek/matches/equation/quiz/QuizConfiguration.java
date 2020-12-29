package pl.piekoszek.matches.equation.quiz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class QuizConfiguration {

    @Bean
    QuizService getQuizService() {
        return new QuizServiceImplementation(new EquationGenerator());
    }

}
