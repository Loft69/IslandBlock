package dev.thew.skyBlock.service.island;

import dev.thew.skyBlock.model.Island;
import lombok.NonNull;
import org.bukkit.World;

public class IslandFactory {

    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    public Island createIsland(@NonNull World world) {
        return new Island(world);
    }

    public Island

}
