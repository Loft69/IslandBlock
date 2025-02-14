package dev.thew.skyBlock.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public final class Island {

    @Setter
    private String owner;
    private final List<String> members = new ArrayList<>();
    private final World islandWorld;

    @Setter
    private Location centerLocation;

    public boolean containsPlayer(final String player) {
        return members.contains(player) || owner.equalsIgnoreCase(player);
    }

    public boolean kick(String member) {
        if (owner.equalsIgnoreCase(member)) return false;
        return members.remove(member);
    }

    public boolean invite(String member) {
        if (owner.equalsIgnoreCase(member)) return false;
        return members.add(member);
    }

    public boolean switchLeader(String member) {
        if (owner.equalsIgnoreCase(member)) return false;
        if (!members.contains(member)) return false;

        members.remove(member);
        members.add(owner);
        setOwner(owner);
        return true;
    }


}
