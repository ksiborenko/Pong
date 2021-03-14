package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Shape {

    public static final int SPEED = 200;
    private final int x, width, height;
    private int y;

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(ShapeRenderer renderer) {
        renderer.rect(this.x, this.y, this.width, this.height);
    }

    public void leftPadMovement(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            this.y += SPEED * delta;
            System.out.println(this.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.y += -SPEED * delta;
            System.out.println(this.y);
        }
    }
}
