package com.jroweboy.tetris.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.jroweboy.tetris.components.NetworkComponent;

public class NetworkSystem extends IteratingSystem {
    ComponentMapper<NetworkComponent> nm;
    public NetworkSystem() {
        super(Family.all(NetworkComponent.class).get());
        nm = ComponentMapper.getFor(NetworkComponent.class);
    }
    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
