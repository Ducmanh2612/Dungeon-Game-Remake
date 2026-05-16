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
    public abstract void land();

    public void align(StaticObject other) {

        double centerX = x + w / 2;
        double centerY = y + h / 2;

        double otherCenterX = other.getX() + other.getW() / 2;
        double otherCenterY = other.getY() + other.getH() / 2;

        double dx = centerX - otherCenterX;
        double dy = centerY - otherCenterY;

        double overlapX = (w + other.getW()) / 2 - Math.abs(dx);
        double overlapY = (h + other.getH()) / 2 - Math.abs(dy);

        if(overlapX < overlapY) {

            x += dx > 0 ? overlapX : -overlapX;
            velocityX = 0;
        }
        else {

            y += dy > 0 ? overlapY : -overlapY;
            velocityY = 0;

            if(dy < 0) land();
        }
    }
}
