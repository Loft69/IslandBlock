package dev.thew.skyBlock.service.user;

import dev.thew.skyBlock.SkyBlock;
import dev.thew.skyBlock.model.User;
import dev.thew.skyBlock.service.Service;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
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
        Bukkit.getOnlinePlayers().forEach(this::registryUser);
        Bukkit.getPluginManager().registerEvents(this, SkyBlock.getInstance());
    }

    @Override
    public void shutdown() {

    }

    private boolean registryUser(Player player) {
        return registry.registryUser(player, factory.createUser(player));
    }

    private boolean unregisterUser(Player player) {
        return registry.unregisterUser(player);
    }

    public User getUser(Player player) {
        return registry.getUser(player);
    }

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) throws EventException {
        Player player = event.getPlayer();
        if (!registryUser(player)) throw new EventException("User " + player.getName() + " is already registered");
    }

    @EventHandler(ignoreCancelled = true)
    public void onQuit(PlayerQuitEvent event) throws EventException {
        Player player = event.getPlayer();
        if (!unregisterUser(player)) throw new EventException("User " + player.getName() + " is already unregistered");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        User user = getUser(player);
        if (user == null) return;

        Block block = event.getBlock();
        Material material = block.getType();

        User.Statistic userStatistic = user.getStatistic();
        userStatistic.registryBreak(material);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        User user = getUser(player);
        if (user == null) return;

        EntityDamageEvent damage = player.getLastDamageCause();
        if (damage == null) return;

        EntityDamageEvent.DamageCause cause = damage.getCause();

//        User.Death death = new User.Death(System.currentTimeMillis(), cause);
//        user.registerDeath(death);
    }
}
