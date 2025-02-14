package dev.thew.skyBlock.service.island;

import dev.thew.skyBlock.model.Island;
import dev.thew.skyBlock.service.Service;
import lombok.Getter;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class IslandService implements Service {

    private IslandService() {}

    @Getter
    private static final IslandService instance = new IslandService();

    private final IslandRegistry registry = new IslandRegistry();
    private final IslandFactory factory = new IslandFactory();

    @Override
    public void load() {

    }

    @Override
    public void shutdown() {

    }

    public void createNewIsland(Player owner) {
        Island island = factory.createIsland()
    }

    public boolean registerIsland(World world) {
        return registry.registerIsland(factory.createIsland(world));
    }

    public boolean unregisterIsland(Island island) {
        return registry.unregisterIsland(island);
    }

    public Island getIsland(String player) {
        return registry.getIsland(player);
    }

}
