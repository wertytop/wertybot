package me.wertytop;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import javax.security.auth.login.LoginException;

public class wertybot{

    public static void main(String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("TOKEN"));
        JDA jda = JDABuilder.createDefault(dotenv.get("TOKEN")).build();
        jda.addEventListener(new BotCommands());
        jda.upsertCommand("ping", "Ping your pong").queue();
        jda.upsertCommand("help", "Unsure what to do? Run this.").queue();
        Guild testServer = jda.getGuildById("1113884879252369438");
        if(testServer != null){
            testServer.upsertCommand("ping", "Ping your pong").queue();
            testServer.upsertCommand("help", "Unsure what to do? Run this.").queue();


        }
    }


}
