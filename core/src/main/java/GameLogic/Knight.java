package GameLogic;

import static GameLogic.CONST.*;

public class Knight extends MovableObject implements Attackable, Jumpable {
    private boolean isOnGround;
    private boolean onAttacking;
    private boolean hurting;
    private boolean jumping;
    private boolean moveLeft, moveRight;
    private Sprite currentSprite;
    private double HP;

    public Knight(double x, double y, double h, double w, double velocityX, double velocityY) {
        super(x, y, h, w, velocityX, velocityY);
    }

    public void moveLeft() {
        x -= velocityX;
    }

    public void moveRight() {
        x += velocityX;
    }

    public void fall() {
        if (isOnGround) return;
        double tmpVelocityY = velocityY + gravity;
        velocityY = Math.min(10, tmpVelocityY);
    }

    public void attack() {

    }

    public void hurt() {
        HP -= 5;
    }

    public void jump() {
        if (!isOnGround) return;
        isOnGround = false;
        velocityY = DEFAULT_JUMP_VELOCITY;
    }

    public void updateState() {
        fall();
        if (hurting) {
            hurt();
            currentSprite = KnightHurtSprite;
            resetOtherSprite(currentSprite);
            return;
        }
        if (onAttacking) {
            attack();
            currentSprite = KnightAttackSprite;
            currentSprite.nextFrame();
            resetOtherSprite(currentSprite);
            if (currentSprite.isTerminated()) onAttacking = false;
            return;
        }
        if (jumping) {
            jump();
            currentSprite = KnightMoveSprite;
            resetOtherSprite(currentSprite);
        }
        if (moveLeft || moveRight) {
            if (moveLeft && moveRight) ;
            else if (moveLeft) moveLeft();
            else if (moveRight) moveRight();
            currentSprite = KnightMoveSprite;
            resetOtherSprite(currentSprite);
        }
        currentSprite.nextFrame();
    }

    public void resetOtherSprite(Sprite sprite) {
        if (KnightMoveSprite != sprite) KnightMoveSprite.reset();
        if (KnightHurtSprite != sprite) KnightHurtSprite.reset();
        if (KnightAttackSprite != sprite) KnightAttackSprite.reset();
    }

    public void setOnGround(boolean flag) {
        isOnGround = flag;
    }

    public void setOnAttacking(boolean flag) {
        onAttacking = flag;
    }

    public void setHurting(boolean flag) {
        hurting = flag;
    }

    public void setCurrentSprite(Sprite sprite) {
        currentSprite = sprite;
    }
}
