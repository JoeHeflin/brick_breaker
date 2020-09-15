package breakout;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {


    int width;
    int height;
    double speed;

    Paddle(double spd){
        super(Game.STAGE_WIDTH/2, Game.STAGE_HEIGHT - 15, Game.PADDLE_WIDTH, Game.PADDLE_HEIGHT);

        speed = spd;
        this.setFill(Game.PADDLE_COLOR);

    }


    void handleHorizontalMovement (KeyCode code, double elapsedTime) {
        switch (code) {
            case LEFT -> {
                if(getX() > 0){setX(getX() - (speed * elapsedTime));}
            }
            case RIGHT -> {
                if(getX() + getWidth() < Game.STAGE_WIDTH){setX(getX() + (speed * elapsedTime));}
            }
        }
    }

}
