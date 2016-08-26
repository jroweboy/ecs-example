package com.jroweboy.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jroweboy.tetris.TetrisMultiplayer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ECS Tetris Example";
        config.width = 600;
        config.height = 800;
		new LwjglApplication(new TetrisMultiplayer(), config);
	}
}
