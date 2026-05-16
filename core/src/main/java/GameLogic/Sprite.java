package GameLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;

public class Sprite {
    private boolean terminated;
    private int numberOfFrame;
    private int currentFrame;
    private int width, height;
    private TextureRegion texture;
    private TextureRegion frame;

    public Sprite(TextureRegion texture, int numberOfFrame) {
        this.texture = texture;
        this.numberOfFrame = numberOfFrame;
        width = texture.getRegionWidth() / numberOfFrame;
        height = texture.getRegionHeight() / numberOfFrame;
    }

    public Sprite(TextureRegion texture, int numberOfFrame, Rectangle rect) {
        this.texture = new TextureRegion(texture, rect.x, rect.y, rect.width, rect.height);
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void nextFrame() {
        currentFrame = (currentFrame + 1) % numberOfFrame;
        frame = new TextureRegion(texture, currentFrame * width, currentFrame * height, width, height);
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
