package com.game.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class App extends Game {

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 800;
	public SpriteBatch batch;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
	}

	@Override
	public void render () {
		super.render();
		this.setScreen(new GameScreen(this));

	}
	
	@Override
	public void dispose () {
		super.dispose();
		this.batch.dispose();
	}
}
