package me.wertytop;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BotCommands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("ping")) {
            event.reply("Pong! `" + event.getJDA().getGatewayPing() + " ms` :ping_pong: ").queue();
        }
        if (event.getName().equals("help")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("Are You lost, Traveler?", null);
            eb.setDescription("Select a category to get more detailed help");
            eb.setColor(Color.PINK);
            eb.setThumbnail("https://media.istockphoto.com/id/926159754/vector/bowl-with-ramen-noodles-chopsticks-holding-noodle-korean-japanese-chinese-food-vector.jpg?s=612x612&w=0&k=20&c=xHHQQPOa0S-BvszFGKD4A1k0gzHVOEK1nLs0eXq4DkA=");
            event.replyEmbeds(eb.build()).setActionRow(sendButtons()).queue();
        }
        if (event.getName().equals("cat")){

        }
    }
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        System.out.println(event.getButton());
        if (event.getButton().getId().equals("help")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("General help", null);
            eb.addField("**/help**", "It's the command you ran to get here, silly", false);
            eb.addField("**/diffusion**", "Generates an image using stable diffusion", false);
            eb.addField("**/ping**", "Returns the ping of the bot", false);
            eb.setColor(Color.PINK);
            event.editMessageEmbeds(eb.build()).queue();
        }
        if (event.getButton().getId().equals("cats")) {
            EmbedBuilder eb = new EmbedBuilder();
            HashMap<Integer, String> cats = new HashMap<>();
            cats.put(1,"https://cataas.com/cat/cute");
            cats.put(2,"https://cataas.com/cat/gif");
            cats.put(3,"https://cataas.com/cat/cat");
            eb.setImage(cats.get(ThreadLocalRandom.current().nextInt(1, 3 + 1)));
            eb.setColor(Color.PINK);
            event.editMessageEmbeds(eb.build()).queue();
        }
    }
    private static java.util.List<Button> sendButtons() {

        List<Button> buttons = new ArrayList<>();
        buttons.add(Button.success("help", "General"));
        buttons.add(Button.primary("cats", "Cats"));

        return buttons;
    }
}