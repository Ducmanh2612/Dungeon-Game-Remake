package GameLogic;

import java.util.List;

public class CONST {
    public static double gravity = 5;
    public static double DEFAULT_JUMP_VELOCITY = 10;
    public static double DEFAULT_TURN_VELOCITY = 10;
    public static double DEFAULT_KNIGHT_WIDTH = 54;
    public static double DEFAULT_KNIGHT_HEIGHT = 84;
    public static double DEFAULT_SKELETON_HEIGHT = 64;
    public static double DEFAULT_SKELETON_WIDTH = 64;
    public static double KNIGHT_ATTACK_WIDTH = 80;
    public static double SKELETON_ATTACK_WIDTH = 70;
    public static Sprite KnightHurtSprite;
    public static Sprite KnightAttackSprite;
    public static Sprite KnightMoveSprite;
    public static Sprite KnightIdleSprite;
    public static Sprite KnightJumpSprite;
    public static Sprite KnightDeathSprite;
    public static List<Sprite> SkeletonAttackSprite;
    public static List<Sprite> SkeletonMoveSprite;
    public static List<Sprite> SkeletonHurtSprite;
    public static List<Sprite> SkeletonIdleSprite;
    public static List<Sprite> SkeletonDeathSprite;
    public static Sprite BlockSprite;
}
