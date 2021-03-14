package com.game.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class App extends Game {

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 800;
	public ShapeRenderer renderer;
	@Override
	public void create () {
		this.renderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		super.render();
		this.setScreen(new GameScreen(this));

	}
	
	@Override
	public void dispose () {
		super.dispose();
		this.renderer.dispose();
	}
}
