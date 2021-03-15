package com.game.pong;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

public class BallManager {

    private static final int ballsSize = 1;
    private final Array<Ball> balls;

    public BallManager() {
        this.balls = new Array<>();
        this.balls.add(new Ball());
    }

    public void render(ShapeRenderer renderer, float delta) {
        for (int ballIndex = 0; ballIndex < ballsSize; ballIndex++) {
            this.balls.get(ballIndex).render(renderer, delta);
        }
        this.update();
    }

    protected void update() {
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

    public Array<Ball> getBalls() {
        return balls;
    }
}
