package com.game.pong;

import com.badlogic.gdx.utils.Array;

public class CollisionDetection {

    public void detection(Pad[] pads, Array<Ball> balls) {
        for (int padIndex = 0; padIndex < PadManager.PAD_AMOUNT; padIndex++) {
            for (int ballIndex = 0; ballIndex < balls.size; ballIndex++) {
                if (balls.get(ballIndex).getXPosition() + Ball.SIZE <= pads[padIndex].getXPosition() + pads[padIndex].getWidth() &&
                balls.get(ballIndex).getXPosition() >= pads[padIndex].getXPosition()) {
                    balls.get(ballIndex).reverseSpeed();
                }
            }
        }
    }
}