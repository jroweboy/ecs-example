package com.jroweboy.tetris.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.jroweboy.tetris.entities.Tetrominos;
import com.jroweboy.tetris.systems.AnimationSystem;
import com.jroweboy.tetris.systems.InputSystem;
import com.jroweboy.tetris.systems.NetworkSystem;
import com.jroweboy.tetris.systems.RenderSystem;

public class TetrisGame extends ScreenAdapter {

    private World world;
    private Engine engine;
    private SpriteBatch spriteBatch;
    private AssetManager manager;

    public TetrisGame(AssetManager manager) {
        super();
        spriteBatch = new SpriteBatch();
        this.manager = manager;
        initEngine();
    }

    private void initEngine() {
        engine = new Engine();
        engine.addSystem(new AnimationSystem());
        engine.addSystem(new InputSystem());
        engine.addSystem(new NetworkSystem());
        engine.addSystem(new RenderSystem(spriteBatch));

        engine.addEntity(Tetrominos.createL());
    }

    private void update(float delta) {
        engine.update(delta);
    }

    @Override
    public void render (float delta) {
        update(delta);
//        draw();
    }
}
