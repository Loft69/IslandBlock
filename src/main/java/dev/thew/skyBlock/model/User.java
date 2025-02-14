package dev.thew.skyBlock.model;


import dev.thew.skyBlock.model.statistics.BreakRegistry;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

@Getter
@RequiredArgsConstructor
public final class User {

    private final Player source;
    private final Statistic statistic;
    private final Rank rank;
    private final Island island;


    @Builder
    public static class Statistic {

        private final BreakRegistry breakRegistry;

        private final int deaths;
        private final int kills;

        public void registryBreak(Material material) {
            breakRegistry.registerBreak(material);
        }

        public int getBreakBlocks(Material material) {
            return breakRegistry.getBreakBlocks(material);
        }

        @Getter
        public record Death(long time, EntityDamageEvent.DamageCause cause) {}

        @Getter
        public record Kill(long time, EntityType entityType) {}

    }
}
