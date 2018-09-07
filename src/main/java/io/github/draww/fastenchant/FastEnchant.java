package io.github.draww.fastenchant;

import co.aikar.commands.BukkitCommandManager;
import me.blackness.black.Blackness;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class FastEnchant extends JavaPlugin {

    private static FastEnchant instance;

    private BukkitCommandManager commandManager;

    private Config config;

    @Override
    public void onEnable() {
        instance = this;
        config = new Config(this).loadAndSaveConfig();
        new Blackness().prepareFor(this);
        commandManager = new BukkitCommandManager(this);
        commandManager.registerCommand(new FECommand());
        log("*--------------------------------------------*");
        log(" FastEnchant has been successfully enabled! ");
        log("                                            ");
        log(" Main Config Version: " + config.getVersion());
        log(" Command Library have been loaded and commands have been added.");
        log(" Inventory Library is loaded.");
        log("*--------------------------------------------*");
    }

    @Override
    public void onDisable() {
        log("*--------------------------------*");
        log(" FastEnchant has been disabled! ");
        log("*--------------------------------*");
        config.save();
        HandlerList.unregisterAll(this);
        commandManager.unregisterCommands();
    }

    public static FastEnchant getInstance() {
        return instance;
    }

    public BukkitCommandManager getCommandManager() {
        return commandManager;
    }

    public Config getMainConfig() {
        return config;
    }

    public void log(String string) {
        getLogger().info(() -> string);
    }

    public void logDebug(Object object) {
        getLogger().info(() -> "DEBUG: " + object);
    }

    public void logError(String error) {
        getLogger().severe(() -> error);
    }

    public void logWarning(String warning) {
        getLogger().warning(warning);
    }

    public void reload() {

    }
}
