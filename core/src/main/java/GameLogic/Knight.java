package GameLogic;

import static GameLogic.CONST.*;

public class Knight extends MovableObject implements Attackable, Jumpable {
    private boolean isOnGround;
    private boolean onAttacking;
    private boolean hurting, takingDmg;
    private boolean jumping;
    private boolean moveLeft, moveRight;
    private Sprite currentSprite;
    private double HP;
    private double dmg;
    private int counter = -1;

    public Knight(double x, double y, double h, double w, double velocityX, double velocityY) {
        super(x, y, h, w, velocityX, velocityY);
    }

    public void idle() {
        velocityX = 0;
    }

    public void moveLeft() {
        velocityX = -Math.abs(DEFAULT_TURN_VELOCITY);
    }

    public void moveRight() {
        velocityX = Math.abs(DEFAULT_TURN_VELOCITY);
    }

    public void fall() {
        if (isOnGround) return;
        double tmpVelocityY = velocityY + gravity;
        velocityY = Math.min(10, tmpVelocityY);
    }

    public void jump() {
        if (!isOnGround) return;
        isOnGround = false;
        velocityY = DEFAULT_JUMP_VELOCITY;
        jumping = false;
    }

    public void land() {
        isOnGround = true;
        velocityY = 0;
    }

    public void move(double delta) {
        x += velocityX * delta;
        y += velocityY * delta;
    }

    public double attack() {
        velocityX = 0;
        counter = (counter + 1) % currentSprite.getNumberOfFrame();
        if (counter == currentSprite.getNumberOfFrame() - 1) onAttacking = false;
        return dmg;
    }

    public void takeDamage() {
        HP -= 5;
    }

    public void hurt() {
        velocityX = 0.1 * DEFAULT_TURN_VELOCITY;
        counter = (counter + 1) % currentSprite.getNumberOfFrame();
        if (counter == currentSprite.getNumberOfFrame() - 1) hurting = false;
    }

    private void updateLogic(double delta) {
        idle();
        fall();
        if (takingDmg) {
            takeDamage();
            takingDmg = false;
        }
        if (hurting) {
            hurt();
            move(delta);
            return;
        }
        if (onAttacking) {
            attack();
            move(delta);
            return;
        }
        if (jumping) {
            jump();
        }
        if (moveLeft && moveRight);
        else if (moveLeft) moveLeft();
        else if (moveRight) moveRight();
        move(delta);
    }

    private void updateSprite() {
        currentSprite = KnightIdleSprite;
        if (takingDmg) {
            currentSprite = KnightHurtSprite;
            currentSprite.reset();
        }
        if (hurting) {
            currentSprite = KnightHurtSprite;
            resetOtherSprite(currentSprite);
            currentSprite.nextFrame();
            return;
        }
        if (onAttacking) {
            currentSprite = KnightAttackSprite;
            resetOtherSprite(currentSprite);
            currentSprite.nextFrame();
            return;
        }
        if (!isOnGround) {
            currentSprite = KnightJumpSprite;
            resetOtherSprite(currentSprite);
        }
        if (moveLeft && moveRight);
        else if (moveLeft) currentSprite = KnightMoveSprite;
        else if (moveRight) currentSprite = KnightMoveSprite;
        resetOtherSprite(currentSprite);
        currentSprite.nextFrame();
    }

    public void updateState(double delta) {
        updateSprite();
        updateLogic(delta);
    }

    public void resetOtherSprite(Sprite sprite) {
        if (KnightMoveSprite != sprite) KnightMoveSprite.reset();
        if (KnightHurtSprite != sprite) KnightHurtSprite.reset();
        if (KnightAttackSprite != sprite) KnightAttackSprite.reset();
        if (KnightJumpSprite != sprite) KnightJumpSprite.reset();
        if (KnightIdleSprite != sprite) KnightIdleSprite.reset();
    }

    public void setOnGround(boolean flag) {
        isOnGround = flag;
    }

    public void setOnAttacking(boolean flag) {
        if (!hurting && flag) onAttacking = flag;
        else onAttacking = false;
    }

    public void setJumping(boolean flag) {
        if (!hurting && !onAttacking && isOnGround) {
            jumping = flag;
        }
        else jumping = false;
    }

    public void setHurting(boolean flag) {
        hurting = flag;
    }

    public void setMoveLeft(boolean flag) {
        if (!hurting && !onAttacking) moveLeft = flag;
        else moveLeft = false;
    }

    public void setMoveRight(boolean flag) {
        if (!hurting && !onAttacking) moveRight = flag;
        else moveRight = false;
    }

    public void setCurrentSprite(Sprite sprite) {
        currentSprite = sprite;
    }
}
