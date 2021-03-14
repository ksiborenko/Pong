package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Shape {

    public static final int PAD_SPEED = 200;
    private final int width, height;
    private int xPosition;
    private int yPosition;

    public Shape(int xPosition, int yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }

    public void render(ShapeRenderer renderer, float delta) {
        renderer.rect(this.xPosition, this.yPosition, this.width, this.height);
    }

    protected void updateLeft(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.yPosition += PAD_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.yPosition -= PAD_SPEED * delta;
        }
    }

    protected void updateRight(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.yPosition += PAD_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.yPosition -= PAD_SPEED * delta;
        }
    }

}
