package pl.piekoszek.matches.discord.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.piekoszek.matches.equation.quiz.QuizService;

@Configuration
class BotConfiguration {

    @Value("${app.protocol.host.port}")
    private String protocolHostPort;

    @Value("${DISCORD_TOKEN}")
    private String token;

    @Bean
    QuizBot quizBot(QuizService quizService) {
        System.out.println(token);
        return new QuizBot(quizService, protocolHostPort, token);
    }

}
