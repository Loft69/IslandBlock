package dev.thew.skyBlock.service.island;

import dev.thew.skyBlock.model.Island;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IslandRegistry {

    private final List<Island> islands = new ArrayList<>();

    public boolean registerIsland(@NonNull Island island) {
        return islands.add(island);
    }

    public boolean unregisterIsland(@NonNull Island island) {
        return islands.remove(island);
    }

    @NonNull
    @Contract(pure = true)
    private @UnmodifiableView List<Island> getIslands() {
        return Collections.unmodifiableList(islands);
    }

    public Island getIsland(@NonNull String player) {
        for (Island island : getIslands()) if (island.containsPlayer(player)) return island;
        return null;
    }



}
