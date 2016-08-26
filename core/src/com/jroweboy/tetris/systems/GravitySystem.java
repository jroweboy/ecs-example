package com.jroweboy.tetris.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IntervalIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.jroweboy.tetris.components.InputComponent;
import com.jroweboy.tetris.components.TransformComponent;

public class GravitySystem extends IntervalIteratingSystem {

    private ComponentMapper<InputComponent> im;
    private ComponentMapper<TransformComponent> trm;
//    private Array<Entity> fallingBlocks;

    public GravitySystem(float interval) {
        super(Family.all(InputComponent.class, TransformComponent.class).get(), interval);
        im = ComponentMapper.getFor(InputComponent.class);
        trm = ComponentMapper.getFor(TransformComponent.class);
    }

    @Override
    protected void processEntity(Entity entity) {
        TransformComponent t = trm.get(entity);
        t.pos.add(0, -6f, 0);
    }

}
