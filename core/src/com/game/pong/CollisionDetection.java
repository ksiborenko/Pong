package com.game.pong;

import com.badlogic.gdx.utils.Array;

public class CollisionDetection {


    public void detection(Pad[] pads, Array<Ball> balls) {
        for (int padIndex = 0; padIndex < PadManager.PAD_AMOUNT; padIndex++) {
            for (int ballIndex = 0; ballIndex < balls.size; ballIndex++) {
                if (balls.get(ballIndex).getXPosition() - Ball.SIZE <= pads[padIndex].getXPosition() + pads[padIndex].getWidth() &&
                        balls.get(ballIndex).getXPosition() + Ball.SIZE >= pads[padIndex].getXPosition() &&
                        balls.get(ballIndex).getYPosition() + Ball.SIZE >= pads[padIndex].getYPosition() &&
                        balls.get(ballIndex).getYPosition() - Ball.SIZE <= pads[padIndex].getYPosition() + pads[padIndex].getHeight()) {
                    if (balls.get(ballIndex).getYPosition() - Ball.SIZE <= pads[padIndex].getYPosition() + (float) pads[padIndex].getHeight() / 3) {
                        balls.get(ballIndex).setXSpeed();
                        balls.get(ballIndex).reverseSpeed(balls.get(ballIndex).getRandomSpeed()[0]);
                    } else if (balls.get(ballIndex).getYPosition() - Ball.SIZE >= pads[padIndex].getYPosition() + (float) pads[padIndex].getHeight() / 3 * 2) {
                        balls.get(ballIndex).setXSpeed();
                        balls.get(ballIndex).reverseSpeed(balls.get(ballIndex).getRandomSpeed()[1]);
                    } else if (balls.get(ballIndex).getYPosition() - Ball.SIZE <= pads[padIndex].getYPosition() + (float) pads[padIndex].getHeight() / 3 * 2 &&
                            balls.get(ballIndex).getYPosition() - Ball.SIZE >= pads[padIndex].getYPosition() + (float) pads[padIndex].getHeight() / 3) {
                        balls.get(ballIndex).setXSpeed();
                        balls.get(ballIndex).reverseSpeed(balls.get(ballIndex).getRandomSpeed()[2]);
                    }
                }
            }
        }
    }
}