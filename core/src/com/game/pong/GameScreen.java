package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen implements Screen {

    private final App app;
    private final PadManager padManager;
    private final BallManager ballManager;
    private final CollisionDetection collisionDetection;
    private final Hud hud;

    public GameScreen(App app) {
        this.app = app;
        this.padManager = new PadManager();
        this.ballManager = new BallManager();
        this.collisionDetection = new CollisionDetection();
        this.hud = new Hud(this.ballManager);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.app.renderer.begin(ShapeRenderer.ShapeType.Filled);
        this.padManager.render(this.app.renderer, Gdx.graphics.getDeltaTime());
        this.ballManager.render(this.app.renderer, Gdx.graphics.getDeltaTime());
        this.app.renderer.end();
        this.collisionDetection.detection(this.padManager.getPads(), this.ballManager.getBalls());
        this.hud.stage.draw();
        this.hud.updatePoints(this.ballManager);
    }


    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
