package GameLogic;

import static GameLogic.CONST.*;

public class Skeleton extends MovableObject implements Attackable{
    private boolean isOnGround;
    private boolean onAttacking;
    private boolean hurting, takingDmg;
    private boolean jumping;
    private boolean moveLeft, moveRight;
    private boolean death, zeroHP;
    private Sprite currentSprite;
    private double HP;
    private double dmg;
    private int counter = -1;
    private static int currentSkeleton;
    private int index;

    public Skeleton(double x, double y, double h, double w, double velocityX, double velocityY) {
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
        if (currentSprite.getCurrentFrame() == currentSprite.getNumberOfFrame() - 2) {
            w = SKELETON_ATTACK_WIDTH;
        }
        if (currentSprite.isTerminated()) {
            onAttacking = false;
            w = DEFAULT_SKELETON_WIDTH;
        }
        return dmg;
    }

    public void hurt() {
        velocityX = 0.1 * DEFAULT_TURN_VELOCITY;
        if (currentSprite.isTerminated()) hurting = false;
    }

    public void goDown() {
        velocityX = 0;
        velocityY = 0;
        if (currentSprite.isTerminated()) death = true;
    }

    public void takeDamage(double dmg) {
        takingDmg = true;
        HP -= dmg;
        if (HP <= 0) zeroHP = true;
    }

    private void updateLogic(double delta) {
        if (zeroHP) {
            goDown();
            return;
        }
        idle();
        fall();
        if (takingDmg) {
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
        if (moveLeft && moveRight) ;
        else if (moveLeft) moveLeft();
        else if (moveRight) moveRight();
        move(delta);
    }

    private void updateSprite() {
        if (zeroHP) {
            currentSprite = getDeathSprite();
            resetOtherSprite(currentSprite);
            currentSprite.nextFrame();
            return;
        }
        currentSprite = getIdleSprite();
        if (takingDmg) {
            currentSprite = getHurtSprite();
            currentSprite.reset();
        }
        if (hurting) {
            currentSprite = getHurtSprite();
            resetOtherSprite(currentSprite);
            currentSprite.nextFrame();
            return;
        }
        if (onAttacking) {
            currentSprite = getAttackSprite();
            resetOtherSprite(currentSprite);
            currentSprite.nextFrame();
            return;
        }
        if (!isOnGround) {
            currentSprite = getIdleSprite();
        }
        if (moveLeft && moveRight);
        else if (moveLeft) currentSprite = getMoveSprite();
        else if (moveRight) currentSprite = getMoveSprite();
        resetOtherSprite(currentSprite);
        currentSprite.nextFrame();
    }

    public void updateState(double delta) {
        updateSprite();
        updateLogic(delta);
    }

    public void resetOtherSprite(Sprite sprite) {
        if (getMoveSprite() != sprite) getMoveSprite().reset();
        if (getHurtSprite() != sprite) getHurtSprite().reset();
        if (getAttackSprite() != sprite) getAttackSprite().reset();
        if (getIdleSprite() != sprite) getIdleSprite().reset();
    }

    public void setOnGround(boolean flag) {
        isOnGround = flag;
    }

    public void setOnAttacking(boolean flag) {
        if (!zeroHP && !hurting) onAttacking = flag;
        else onAttacking = false;
    }

    public void setHurting(boolean flag) {
        if (!zeroHP) hurting = flag;
        else hurting = false;
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

    public Sprite getMoveSprite() {
        return SkeletonMoveSprite.get(index);
    }

    public Sprite getIdleSprite() {
        return SkeletonIdleSprite.get(index);
    }

    public Sprite getHurtSprite() {
        return SkeletonHurtSprite.get(index);
    }

    public Sprite getAttackSprite() {
        return SkeletonAttackSprite.get(index);
    }

    public Sprite getDeathSprite() {
        return SkeletonDeathSprite.get(index);
    }
}
