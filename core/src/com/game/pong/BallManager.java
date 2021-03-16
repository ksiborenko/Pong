package com.game.pong;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class BallManager {

    private int playerOneScore;
    private int playerTwoScore;
    private static final int ballsSize = 1;
    private final Array<Ball> balls;

    public BallManager() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.balls = new Array<>();
        this.balls.add(new Ball());
    }

    public void render(ShapeRenderer renderer, float delta) {
        for (int ballIndex = 0; ballIndex < ballsSize; ballIndex++) {
            this.balls.get(ballIndex).render(renderer, delta);
        }
        this.update();
        this.scoreCount();
    }

    private void update() {
        for (int ballIndex = 0; ballIndex < ballsSize; ballIndex++) {
            if (this.balls.get(ballIndex).getXPosition() <= -Ball.SIZE ||
                    this.balls.get(ballIndex).getXPosition() >= App.WIDTH + Ball.SIZE) {
                this.balls.removeIndex(ballIndex);
            }
            if (this.balls.size == 0) {
                this.balls.add(new Ball());
            }
        }
    }

    private void scoreCount() {
        for (int ballIndex = 0; ballIndex < ballsSize; ballIndex++) {
            if (this.balls.get(ballIndex).getXPosition() >= App.WIDTH + (float) Ball.SIZE / 2) {
                this.playerOneScore++;
            }
            if (this.balls.get(ballIndex).getXPosition() <= (float) -Ball.SIZE / 2) {
                this.playerTwoScore++;
            }
        }
    }

    public Array<Ball> getBalls() {
        return balls;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}
