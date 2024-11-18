package icu.suc.kevin557.servercommands;

import icu.suc.kevin557.servercommands.command.ModsCommand;
import icu.suc.kevin557.servercommands.command.PingCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ServerCommands implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            ModsCommand.register(dispatcher);
            PingCommand.register(dispatcher);
        });
    }
}
