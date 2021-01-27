package pl.piekoszek.matches.discord.bot;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import pl.piekoszek.matches.equation.quiz.QuizService;

class QuizBot {

    private QuizService quizService;
    private String protocolHostPort;
    private String token;

    public QuizBot(QuizService quizService, String protocolHostPort, String token) {
        this.quizService = quizService;
        this.protocolHostPort = protocolHostPort;
        this.token = token;

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
                        spec -> spec.setImage(protocolHostPort+"/gameplay/quiz/1+2=3")
                        .setTitle(protocolHostPort+"/gameplay/quiz/1+2=3")
                        .setDescription("Dupa kościotrupa")
                        )
                )
                .subscribe();

//        client.onDisconnect().block();


    }

}
