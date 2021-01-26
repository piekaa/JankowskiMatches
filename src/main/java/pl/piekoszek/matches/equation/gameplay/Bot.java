package pl.piekoszek.matches.equation.gameplay;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

public class Bot {
    public static void main(String[] args) {
        GatewayDiscordClient client = DiscordClientBuilder.create("ODAzNTYwNzA0NTQ3MjI1NjEw.YA_kOQ.05-eHAVvU9xb7wOtzJo9qyXms4A")
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
                .flatMap(channel -> channel.createMessage(messageCreateSpec -> messageCreateSpec.addFile()))
                .subscribe();

        client.onDisconnect().block();
    }
}
