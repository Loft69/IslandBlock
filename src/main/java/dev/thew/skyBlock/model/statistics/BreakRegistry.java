package dev.thew.skyBlock.model.statistics;

import lombok.RequiredArgsConstructor;
import org.bukkit.Material;

import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class BreakRegistry {

    private final ConcurrentHashMap<Material, Integer> breaks;

    public void registerBreak(Material material) {
        int count = breaks.getOrDefault(material, 0);
        breaks.put(material, count + 1);
    }

    public Integer getBreakBlocks(Material material) {
        return breaks.getOrDefault(material, 0);
    }

}
