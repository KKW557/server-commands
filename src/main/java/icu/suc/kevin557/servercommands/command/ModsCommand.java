package icu.suc.kevin557.servercommands.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public class ModsCommand {

    public static void register(@NotNull CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("mods")
                .executes(ModsCommand::execute));
    }

    private static int execute(@NotNull CommandContext<ServerCommandSource> context) {
        var mods = FabricLoader.getInstance().getAllMods();
        var size = mods.size();
        context.getSource().sendFeedback(() -> Text.literal(String.format("Mods(%d): %s", size, String.join(", ", mods.stream().filter(mod -> mod.getContainingMod().isEmpty()).map(mod -> mod.getMetadata().getId()).toList()))), false);
        return size;
    }
}
