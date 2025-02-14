package dev.thew.skyBlock.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;

@RequiredArgsConstructor
@Getter
public final class Island {

    private final String owner;
    private final List<String> members;
    private final World islandWorld;

    @Setter
    private Location centerLocation;

    public boolean kick(String member) {
        if (owner.equalsIgnoreCase(member)) return false;
        return members.remove(member);
    }

    public boolean invite(String member) {
        if (owner.equalsIgnoreCase(member)) return false;
        return members.add(member);
    }


}
