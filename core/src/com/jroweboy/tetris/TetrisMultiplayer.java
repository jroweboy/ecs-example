package com.jroweboy.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jroweboy.tetris.screens.TetrisGame;

import java.util.Stack;

public class TetrisMultiplayer extends Game {
	public enum GameState {
        FIRST_TIME_LOAD,
        MENU,
        LOADING_GAME,
        PAUSE,
    }

    public enum NetworkState {
        NONE,
        LISTENING,
        CONNECTING,
        HOST,
        CLIENT,
    }

	private Stack<Screen> currentScreen;
    private AssetManager manager;
	
	@Override
	public void create () {

        currentScreen = new Stack<Screen>();
        manager = new AssetManager();
        loadAssets();
        setScreen(new TetrisGame(manager));
	}

	private void loadAssets() {
        manager.load("I.png", Texture.class);
        manager.load("J.png", Texture.class);
        manager.load("L.png", Texture.class);
        manager.load("O.png", Texture.class);
        manager.load("S.png", Texture.class);
        manager.load("T.png", Texture.class);
        manager.load("Z.png", Texture.class);
        manager.finishLoading();
    }

	@Override
	public void render () {
	    super.render();
	}
	
	@Override
	public void dispose () {
	    super.dispose();
	}
}
