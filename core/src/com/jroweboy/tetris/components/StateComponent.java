package com.jroweboy.tetris.components;

import com.badlogic.ashley.core.Component;

// This is kinda a bad class to have i suppose. The point of having a component is so it can be reused
// between different entities, but this is pretty much only used for Tetromino and NetworkedTetromino...
public class StateComponent implements Component {
    public enum TetrominoState {
        QUEUE,
        HOLD,
        FALLING,
        LANDED
    }
    public TetrominoState state;
}
