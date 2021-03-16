package com.game.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class Hud {

    public Stage stage;

    private final Label playerOnePoints;
    private final Label playerTwoPoints;

    public Hud(BallManager ballManager) {
        this.stage = new Stage();
        this.playerOnePoints = new Label(String.format("%02d", ballManager.getPlayerOneScore()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        this.playerTwoPoints = new Label(String.format("%02d", ballManager.getPlayerTwoScore()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(playerOnePoints).expandX().padTop(10);
        table.add(playerTwoPoints).expandX().padTop(10);
        this.stage.addActor(table);
    }

    public void updatePoints(BallManager ballManager) {
        this.playerOnePoints.setText(ballManager.getPlayerOneScore());
        this.playerTwoPoints.setText(ballManager.getPlayerTwoScore());

    }
}