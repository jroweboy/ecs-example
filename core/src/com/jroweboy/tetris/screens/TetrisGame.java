package com.jroweboy.tetris.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.jroweboy.tetris.components.InputComponent;
import com.jroweboy.tetris.components.TransformComponent;
import com.jroweboy.tetris.entities.Tetrominos;
import com.jroweboy.tetris.systems.*;

public class TetrisGame extends ScreenAdapter {

    private World world;
    private Engine engine;
    private SpriteBatch spriteBatch;
    private AssetManager manager;

    private RenderSystem renderSystem;

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
        engine.addSystem(new GravitySystem(1f));
        renderSystem = new RenderSystem(spriteBatch);
        engine.addSystem(renderSystem);

        Entity e = Tetrominos.createRandomTetromino(manager);
        TransformComponent t = new TransformComponent();
        t.pos.set(0,0,1);
        e.add(t);
        InputComponent i = new InputComponent();
        e.add(i);
        engine.addEntity(e);
    }

    @Override
    public void render (float delta) {
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderSystem.resize(width, height);
    }
}
