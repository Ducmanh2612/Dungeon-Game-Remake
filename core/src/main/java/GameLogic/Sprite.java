package GameLogic;

import com.badlogic.gdx.graphics.Texture;

public class Sprite {
    private boolean terminated;
    private int numberOfFrame;
    private int currentFrame;
    private double width, height;
    private Texture texture;

    public Sprite(Texture texture, int numberOfFrame) {
        this.texture = texture;
        this.numberOfFrame = numberOfFrame;
        width = texture.getWidth() / numberOfFrame;
        height = texture.getHeight() / numberOfFrame;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void nextFrame() {
        currentFrame = (currentFrame + 1) % numberOfFrame;
        if (currentFrame == 1) terminated = true;
        else terminated = false;
    }

    public double getFrameHeight() {
        return height;
    }

    public double getFrameWidth() {
        return width;
    }

    public int getNumberOfFrame() {
        return numberOfFrame;
    }

    public void reset() {
        currentFrame = 0;
    }
}
