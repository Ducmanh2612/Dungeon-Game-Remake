package GameLogic;

public abstract class Object {
    protected double x, y, w, h;

    public Object(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getH() {
        return h;
    }

    public double getW() {
        return w;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setW(double w) {
        this.w = w;
    }
}
