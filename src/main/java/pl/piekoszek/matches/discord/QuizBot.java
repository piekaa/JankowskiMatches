package pl.piekoszek.matches.discord;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import pl.piekoszek.matches.equation.quiz.QuizService;


class QuizBot {

    public QuizBot(String protocolHostPort, QuizService quizService, String token) {
            GatewayDiscordClient client = DiscordClientBuilder.create(token)
                    .build()
                    .login()
                    .block();

            client.getEventDispatcher().on(ReadyEvent.class)
                    .subscribe(event -> {
                        final User self = event.getSelf();
                        System.out.println(String.format(
                                "Logged in as %s#%s", self.getUsername(), self.getDiscriminator()
                        ));
                    });

            client.getEventDispatcher().on(MessageCreateEvent.class)
                    .map(MessageCreateEvent::getMessage)
                    .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                    .filter(message -> message.getContent().equalsIgnoreCase("!quiz"))
                    .flatMap(Message::getChannel)
                    .flatMap(channel -> channel.createEmbed(
                            spec -> spec.setImage(protocolHostPort + "/gameplay/quiz" + quizService.randomQuiz()))
                    )
                    .subscribe();

        }
}
