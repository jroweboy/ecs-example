package com.jroweboy.tetris.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.jroweboy.tetris.components.StateComponent;
import com.jroweboy.tetris.components.TetrominoComponent;
import com.jroweboy.tetris.components.TextureComponent;

public class Tetrominos {
    public enum Tetromino {
        I, O, T, S, Z, J, L
    }
    public static Entity createRandomTetromino(AssetManager manager) {
        switch (MathUtils.random(0,6)) {
            case 0:
                return createI(manager);
            case 1:
                return createO(manager);
            case 2:
                return createT(manager);
            case 3:
                return createS(manager);
            case 4:
                return createZ(manager);
            case 5:
                return createJ(manager);
            case 6:
                return createL(manager);
            default:
                throw new RuntimeException("Unreachable");
        }
    }

    public static Entity createI(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.I;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("I.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createO(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.O;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("O.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createT(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.T;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("T.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createS(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.S;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("S.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createZ(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.Z;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("Z.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createJ(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.J;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("J.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createL(AssetManager manager) {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.L;
        e.add(t);

        TextureComponent tex = new TextureComponent();
        tex.texture = manager.get("L.png", Texture.class);
        e.add(tex);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
}
