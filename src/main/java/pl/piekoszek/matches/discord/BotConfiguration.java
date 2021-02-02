package pl.piekoszek.matches.discord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.piekoszek.matches.equation.quiz.QuizService;

@Configuration
class BotConfiguration {
    @Value("${app.protocol.host.port}")
    String protocolHostPort;

    @Value("")
    String token;

    @Bean
    QuizBot quizBot(QuizService quizService) {
        System.out.println(token);
        return new QuizBot(protocolHostPort, quizService, token);
    }
}
