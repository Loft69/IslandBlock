package dev.thew.skyBlock.service.user;

import dev.thew.skyBlock.model.User;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public final class UserRegistry {

    private final ConcurrentHashMap<Player, User> users = new ConcurrentHashMap<>();

    public boolean registryUser(Player player, @NonNull User user) {
        return users.put(player, user) == null;
    }

    public boolean unregisterUser(Player player) {
        return users.remove(player) != null;
    }

    public User getUser(Player player) {
        return users.get(player);
    }


}
