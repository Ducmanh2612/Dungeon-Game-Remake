package GameLogic;

public abstract class MovableObject extends Object {
    private double velocityX, velocityY;

    public MovableObject(double x, double y, double h, double w, double velocityX, double velocityY) {
        super(x, y, h, w);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void moveHLeft() {
        this.setX(x - velocityX);
    }

    public void moveRight() {
        this.setX(x - velocityY);
    }

    public void fall() {
        velocityY += CONST.gravity;
    }

    public void jump() {
        velocity -=
    }
}
