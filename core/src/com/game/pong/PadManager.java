package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PadManager {

    public static final int PAD_AMOUNT = 2;
    public static final int PAD_X_POSITION = 100;
    public static final int PAD_HEIGHT = 100;
    public static final int PAD_WIDTH = 10;
    public static final int PAD_SPACING = 1000;
    public static final int PAD_Y_POSITION = App.HEIGHT / 2 - PAD_HEIGHT / 2;
    private final Shape[] pads;

    public PadManager() {
        this.pads = new Shape[PAD_AMOUNT];
        for (int padIndex = 0; padIndex < PAD_AMOUNT; padIndex++) {
            this.pads[padIndex] = new Shape(PAD_X_POSITION + (padIndex * PAD_SPACING),
                    PAD_Y_POSITION, PAD_WIDTH, PAD_HEIGHT);
        }
    }

    public void render(ShapeRenderer renderer, float delta) {
        for (int padIndex = 0; padIndex < PAD_AMOUNT; padIndex++) {
            this.pads[padIndex].render(renderer, delta);
            this.pads[0].updateLeft(delta);
            this.pads[1].updateRight(delta);
        }

    }

}
