package GameLogic;

public abstract class MovableObject extends Object {
    protected double velocityX, velocityY;

    public MovableObject(double x, double y, double h, double w, double velocityX, double velocityY) {
        super(x, y, h, w);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public abstract void moveLeft();
    public abstract void moveRight();
    public abstract void fall();
}
