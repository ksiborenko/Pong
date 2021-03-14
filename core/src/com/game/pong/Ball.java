package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Ball {

    private static final int size = 10;
    private int xSpeed = 0;
    private int ySpeed = 0;
    private int xPosition, yPosition;
    private final Random random;
    private final int[] randomSpeed;
    private Draw draw;

    public Ball() {
        this.xPosition = App.WIDTH / 2;
        this.yPosition = App.HEIGHT / 2;
        this.random = new Random();
        this.randomSpeed = new int[3];
        this.draw = Draw.INITIAL;
        this.randomSpeed[0] = -200;
        this.randomSpeed[1] = 200;
    }

    public void render(ShapeRenderer renderer, float delta) {
        renderer.circle(this.xPosition, this.yPosition, size);
        this.update(delta);
    }

    private void update(float delta) {
        if (this.draw == Draw.INITIAL) {
            xSpeed = this.randomSpeed[this.random.nextInt(2)];
            ySpeed = this.randomSpeed[this.random.nextInt(3)];
            this.draw = Draw.BALL_IN_GAME;
        }
        if (this.draw == Draw.BALL_IN_GAME) {
            this.xPosition += xSpeed * delta;
            this.yPosition += ySpeed * delta;
        }
        if (this.yPosition >= App.HEIGHT - size || this.yPosition <= size) {
            this.ySpeed = -ySpeed;
        }
    }
}
