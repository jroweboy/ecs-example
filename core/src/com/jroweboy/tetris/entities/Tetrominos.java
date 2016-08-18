package com.jroweboy.tetris.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.MathUtils;
import com.jroweboy.tetris.components.StateComponent;
import com.jroweboy.tetris.components.TetrominoComponent;

public class Tetrominos {
    public enum Tetromino {
        I, O, T, S, Z, J, L
    }
    public static Entity createRandomTetromino() {
        switch (MathUtils.random(0,7)) {
            case 0:
                return createI();
            case 1:
                return createO();
            case 2:
                return createT();
            case 3:
                return createS();
            case 4:
                return createZ();
            case 5:
                return createJ();
            case 6:
                return createL();
            default:
                throw new RuntimeException("Unreachable");
        }
    }

    public static Entity createI() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.I;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createO() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.O;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createT() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.T;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createS() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.S;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createZ() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.Z;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createJ() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.J;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
    public static Entity createL() {
        Entity e = new Entity();
        TetrominoComponent t = new TetrominoComponent();
        t.shape = Tetromino.L;
        e.add(t);

        StateComponent s = new StateComponent();
        s.state = StateComponent.TetrominoState.QUEUE;
        e.add(s);
        return e;
    }
}
