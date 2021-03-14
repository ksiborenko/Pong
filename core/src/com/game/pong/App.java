package com.game.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class App extends Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public SpriteBatch batch;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		this.batch.dispose();
	}
}
