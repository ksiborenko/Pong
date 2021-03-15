package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;


public class Ball {

    public static final int SIZE = 10;
    private double xSpeed = 0;
    private double ySpeed = 0;
    private float xPosition, yPosition;
    private final Random random;
    private final int[] randomSpeed;
    private Draw draw;

    public Ball() {
        this.xPosition = (float) App.WIDTH / 2;
        this.yPosition = (float) App.HEIGHT / 2;
        this.random = new Random();
        this.randomSpeed = new int[]{-300, 300, 0};
        this.draw = Draw.INITIAL;
    }

    public void render(ShapeRenderer renderer, float delta) {
        renderer.circle(this.xPosition, this.yPosition, SIZE);
        this.update(delta);
    }

    private void update(float delta) {
        if (this.draw == Draw.INITIAL) {
            this.xSpeed = this.randomSpeed[this.random.nextInt(2)];
            this.ySpeed = 300 * Math.cos(random.nextInt(180));
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

    public void reverseSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
        this.xSpeed = -this.xSpeed;
    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public void setXSpeed() {
        this.xSpeed = this.xSpeed * 1.1f;
    }

    public int[] getRandomSpeed() {
        return randomSpeed;
    }
}
