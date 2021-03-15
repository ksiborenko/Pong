package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Pad {

    public static final int PAD_SPEED = 200;
    private final int width, height;
    private final int xPosition;
    private int yPosition;

    public Pad(int xPosition, int yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }

    public void render(ShapeRenderer renderer) {
        renderer.rect(this.xPosition, this.yPosition, this.width, this.height);
    }

    protected void updateLeft(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.yPosition += PAD_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.yPosition -= PAD_SPEED * delta;
        }
        this.padBoarders();

    }

    protected void updateRight(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.yPosition += PAD_SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.yPosition -= PAD_SPEED * delta;
        }
        this.padBoarders();
    }

    private void padBoarders() {
        if (this.yPosition >= App.HEIGHT - this.height) {
            this.yPosition = App.HEIGHT - this.height;
        }
        if (this.yPosition <= 0) {
            this.yPosition = 0;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}
