package dev.thew.skyBlock.service.user;

import dev.thew.skyBlock.model.User;
import lombok.NonNull;
import org.bukkit.entity.Player;

public final class UserFactory {

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    public User createUser(@NonNull Player player) {
        return new User(player, null, null);
    }

}
