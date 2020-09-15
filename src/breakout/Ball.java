package breakout;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball extends Circle{

    int radius;
    double x;
    double y;

    double up;
    double down;
    double left;
    double right;
    double speed;
    double xVel;
    double yVel;
    int damage;


    public Ball(double startingX, double startingY, double spd, int r){
        super(startingX, startingY, r);
        this.radius = r;
        this.x = startingX;
        this.y = startingY;
        this.up = y + radius;
        this.down = y - radius;
        this.left = x - radius;
        this.right = x + radius;
        this.xVel = 0;
        this.yVel = 0;
        this.speed = spd;
        this.damage = 1;
    }

    //Makes the ball start moving // stop moving
    void startStop(boolean go, double launchAngle){
        if(go){
            this.xVel = (double) (speed * Math.cos(Math.toRadians(launchAngle)));
            this.yVel = (double) (speed * Math.sin(Math.toRadians((launchAngle))));
        }
        else{
            this.xVel = 0;
            this.yVel = 0;
        }
    }

    void moveAndDetectStage(){

        if(left < 0){
            bounce(true);
            x = 0;
        }
        if(right > Game.STAGE_WIDTH){
            bounce(true);
            x = Game.STAGE_WIDTH;
        }
        if(up < 0){
            bounce(false);
            y = 0;
        }

        x += xVel * (double)(1/Game.FRAMES_PER_SECOND);
        y += yVel * (double)(1/Game.FRAMES_PER_SECOND);
    }

    void bounce(Boolean xOtherwiseY){
        if(xOtherwiseY){
            this.xVel = -this.xVel;
        }
        else{
            this.yVel = -this.yVel;
        }
    }


}
