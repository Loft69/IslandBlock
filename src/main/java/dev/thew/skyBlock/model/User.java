package dev.thew.skyBlock.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@Getter
@RequiredArgsConstructor
public final class User {

    private final Player source;
    private final Rank rank;
    private final Island island;

}
