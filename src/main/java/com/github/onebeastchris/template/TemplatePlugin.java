package com.github.onebeastchris.template;

import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.event.EventRegistrar;
import org.geysermc.geyser.api.event.bedrock.SessionJoinEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;

import java.util.logging.Logger;

public class TemplatePlugin extends JavaPlugin implements EventRegistrar {

    public static Logger logger;
    @Override
    public void onEnable(){
        logger = getLogger();
        getLogger().info("no manual subscribe");
        GeyserApi.api().eventBus().register(this, this);
        //GeyserApi.api().eventBus().subscribe(this, GeyserPostInitializeEvent.class, this::onInit);
        //GeyserApi.api().eventBus().subscribe(this, SessionJoinEvent.class, this::onJoin);
    }

    @Override
    public void onDisable() {

    }

    @Subscribe
    public void onInit(GeyserPostInitializeEvent event) {
        logger.info("Geyser has initialized!");
    }

    @Subscribe
    public void onJoin(SessionJoinEvent event) {
        logger.info("A player has joined!");
    }
}
