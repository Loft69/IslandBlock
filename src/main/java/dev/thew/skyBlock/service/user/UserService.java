package dev.thew.skyBlock.service.user;

import dev.thew.skyBlock.SkyBlock;
import dev.thew.skyBlock.model.User;
import dev.thew.skyBlock.service.Service;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class UserService implements Service, Listener {

    private UserService() {}

    @Getter
    private static final UserService instance = new UserService();

    private final UserRegistry registry = new UserRegistry();
    private final UserFactory factory = new UserFactory();

    @Override
    public void load() {
        Bukkit.getOnlinePlayers().forEach(this::createUser);
        Bukkit.getPluginManager().registerEvents(this, SkyBlock.getInstance());
    }

    @Override
    public void shutdown() {

    }

    private void createUser(Player player) {
        registry.registryUser(player, factory.createUser(player));
    }
    private void removeUser(Player player) {
        registry.unregisterUser(player);
    }

    private User getUser(Player player) {
        return registry.getData(player);
    }

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        createUser(player);
    }

    @EventHandler(ignoreCancelled = true)
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        removeUser(player);
    }
}
