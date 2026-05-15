package GameLogic;

import static GameLogic.CONST.*;

public class Skeleton extends MovableObject implements Attackable{
    private static int counter;
    private static int index;
    private boolean isOnGround;
    private boolean onAttacking;
    private boolean hurting;
    private boolean moveLeft, moveRight;
    private Sprite currentSprite;
    private double HP;

    public Skeleton(double x, double y, double h, double w, double velocityX, double velocityY) {
        super(x, y, h, w, velocityX, velocityY);
        index = counter;
        counter++;
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
            currentSprite = SkeletonHurtSprite.get(index);
            resetOtherSprite(currentSprite);
            return;
        }
        if (onAttacking) {
            attack();
            currentSprite = SkeletonAttackSprite.get(index);
            currentSprite.nextFrame();
            resetOtherSprite(currentSprite);
            if (currentSprite.isTerminated()) onAttacking = false;
            return;
        }
        if (moveLeft || moveRight) {
            if (moveLeft && moveRight) ;
            else if (moveLeft) moveLeft();
            else if (moveRight) moveRight();
            currentSprite = SkeletonMoveSprite.get(index);
            resetOtherSprite(currentSprite);
        }
        currentSprite.nextFrame();
    }

    public void resetOtherSprite(Sprite sprite) {
        if (SkeletonMoveSprite.get(index)!= sprite) SkeletonMoveSprite.get(index).reset();
        if (SkeletonHurtSprite.get(index) != sprite) SkeletonHurtSprite.get(index).reset();
        if (SkeletonAttackSprite.get(index) != sprite) SkeletonAttackSprite.get(index).reset();
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
