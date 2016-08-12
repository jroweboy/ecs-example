package com.jroweboy.tetris.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.jroweboy.tetris.components.InputComponent;

public class InputSystem extends IteratingSystem {
    ComponentMapper<InputComponent> im;

    public InputSystem() {
        super(Family.all(InputComponent.class).get());
        im = ComponentMapper.getFor(InputComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
