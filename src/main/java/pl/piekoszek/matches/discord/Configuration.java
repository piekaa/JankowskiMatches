package pl.piekoszek.matches.discord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import pl.piekoszek.matches.equation.quiz.QuizService;

class Configuration {
    @Value("${app.protocol.host.port}")
    private String protocolHostPort;

    @Value("${ODAzNTYwNzA0NTQ3MjI1NjEw.YA_kOQ.U-aQDn1mcfgHFVF22zcWxI7qiBQ}")
    private String token;

    @Bean
    Bot Bot(QuizService quizService) {
        System.out.println(token);
        return new Bot(protocolHostPort, quizService, token);
    }
}
