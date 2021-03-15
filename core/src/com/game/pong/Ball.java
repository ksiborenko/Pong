package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Ball {

    public static final int SIZE = 10;
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
        this.randomSpeed = new int[]{-200, 200, 0};
        this.draw = Draw.INITIAL;
    }

    public void render(ShapeRenderer renderer, float delta) {
        renderer.circle(this.xPosition, this.yPosition, SIZE);
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
        if (this.yPosition <= SIZE) {
            this.yPosition = SIZE;
            this.ySpeed = -this.ySpeed;
        }
        if (this.yPosition >= App.HEIGHT - SIZE) {
            this.yPosition = App.HEIGHT - SIZE;
            this.ySpeed = -this.ySpeed;
        }
    }
    public void reverseSpeed () {
        this.ySpeed = -this.ySpeed;
        this.xSpeed = -this.xSpeed;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }
}
