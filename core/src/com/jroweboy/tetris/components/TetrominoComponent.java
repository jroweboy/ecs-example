package com.jroweboy.tetris.components;

import com.badlogic.ashley.core.Component;
import com.jroweboy.tetris.entities.Tetrominos;

public class TetrominoComponent implements Component {
    public Tetrominos.Tetromino shape;
}
