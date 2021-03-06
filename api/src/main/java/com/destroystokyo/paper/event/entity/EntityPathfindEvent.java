package com.destroystokyo.paper.event.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fired when an Entity decides to start moving towards a location.
 *
 * This event does not fire for the entities actual movement. Only when it
 * is choosing to start moving to a location.
 */
public class EntityPathfindEvent extends EntityEvent implements Cancellable {
    @Nullable private final Entity targetEntity;
    @NotNull private final Location loc;

    public EntityPathfindEvent(@NotNull Entity entity, @NotNull Location loc, @Nullable Entity targetEntity) {
        super(entity);
        this.targetEntity = targetEntity;
        this.loc = loc;
    }

    /**
     * The Entity that is pathfinding.
     * @return The Entity that is pathfinding.
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }

    /**
     * If the Entity is trying to pathfind to an entity, this is the entity in relation.
     *
     * Otherwise this will return null.
     *
     * @return The entity target or null
     */
    @Nullable
    public Entity getTargetEntity() {
        return targetEntity;
    }

    /**
     * The Location of where the entity is about to move to.
     *
     * Note that if the target happened to of been an entity
     * @return Location of where the entity is trying to pathfind to.
     */
    @NotNull
    public Location getLoc() {
        return loc;
    }

    private static final HandlerList handlers = new HandlerList();

    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
