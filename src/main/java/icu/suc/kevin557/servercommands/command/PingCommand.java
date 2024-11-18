package icu.suc.kevin557.servercommands.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public class PingCommand {

    public static void register(@NotNull CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("ping")
                .executes(PingCommand::execute));
    }

    private static int execute(@NotNull CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Pong!"), false);
        return 0;
    }
}
