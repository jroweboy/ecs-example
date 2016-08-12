package com.jroweboy.tetris.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.physics.box2d.World;
import com.jroweboy.tetris.systems.AnimationSystem;
import com.jroweboy.tetris.systems.InputSystem;
import com.jroweboy.tetris.systems.NetworkSystem;
import com.jroweboy.tetris.systems.RenderSystem;

public class Game extends ScreenAdapter {

    private World world;
    private Engine engine;

    public Game() {
        super();
        init();
    }

    private void init() {
        engine = new Engine();
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new InputSystem());
        engine.addSystem(new NetworkSystem());
        engine.addSystem(new RenderSystem());
    }

    private void update(float delta) {
        engine.update(delta);
    }
}
