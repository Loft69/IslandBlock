package dev.thew.skyBlock.service.user;

import dev.thew.skyBlock.model.User;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public final class UserRegistry {

    private final ConcurrentHashMap<Player, User> userMap = new ConcurrentHashMap<>();

    public void registryUser(Player player, User data) {
        userMap.put(player, data);
    }

    public User getData(Player player) {
        return userMap.get(player);
    }

    public void unregisterUser(Player player) {
        userMap.remove(player);
    }

    public boolean userExist(Player player) {
        return userMap.containsKey(player);
    }

}
