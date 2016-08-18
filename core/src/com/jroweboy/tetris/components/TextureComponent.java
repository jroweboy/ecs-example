package com.jroweboy.tetris.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureComponent implements Component {
    // TODO? Just use ShapeRenderer for Tetromino instead of textures?
    public Texture texture;
    public TextureRegion region;
}
