package breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public abstract class Brick extends Rectangle {

    double x;
    double y;
    int health;
    int width;
    int height;
    String type;
    Color color;
    //int lives;

    //TODO: Make the bricks look distinct
    //TODO: Add more types of bricks
    //Constructor
    Brick(double x, double y){
        super(x, y, Game.BRICK_WIDTH, Game.BRICK_HEIGHT);
        this.x = x;
        this.y = y;
        this.type = type;
//        alive = true;
        width = Game.BRICK_WIDTH;
        height = Game.BRICK_HEIGHT;

    }


    void setColor(){
        this.setFill(color);
    }

    void takeDamage(Ball ball, MenuBar menuBar, LevelBuilder layout){
        health = health - ball.getDamage();
        if(!checkIfAlive()){
            actOnDeath();
            menuBar.addPoints();
            layout.removeBrickFromCount();
        }
    }

    boolean checkIfAlive(){
        return health > 0;
    }


    void actOnDeath(){
        health = 0;
        color = Game.BACKGROUND_COLOR;
        setColor();
    }


}
