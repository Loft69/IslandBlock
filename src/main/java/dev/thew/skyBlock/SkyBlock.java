package dev.thew.skyBlock;

import dev.thew.skyBlock.service.ServiceInitializer;
import dev.thew.skyBlock.service.user.UserService;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyBlock extends JavaPlugin {

    @Getter
    private static SkyBlock instance;

    @Override
    public void onEnable() {
        instance = this;

        ServiceInitializer.registerService(UserService.getInstance());

        ServiceInitializer.initializeServices();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void runTask(Runnable runnable, boolean async) {
        if (async) Bukkit.getScheduler().runTaskAsynchronously(instance, runnable);
        else Bukkit.getScheduler().runTask(instance, runnable);
    }
}
