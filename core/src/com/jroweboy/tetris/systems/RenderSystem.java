package com.jroweboy.tetris.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.jroweboy.tetris.components.TextureComponent;
import com.jroweboy.tetris.components.TransformComponent;

public class RenderSystem extends IteratingSystem {
    ComponentMapper<TextureComponent> tm;
    ComponentMapper<TransformComponent> trm;

    public RenderSystem() {
        super(Family.all(TextureComponent.class, TransformComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
