package GamePlay;

import GameLogic.Knight;
import GameLogic.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;
import java.util.ArrayList;

import static GameLogic.CONST.*;

public class GameInitAsset {
    public static TextureRegion ATTACK_1;
    public static TextureRegion ATTACK_2;
    public static TextureRegion ATTACK_3;

    public static TextureRegion DEATH;
    public static TextureRegion DEFEND;
    public static TextureRegion HURT;
    public static TextureRegion IDLE;
    public static TextureRegion JUMP;
    public static TextureRegion RUN;

    public static TextureRegion platformPack_tilesheet_walls_2;

    public static TextureRegion Purple_Nebula_07_1024x1024;

    public static TextureRegion Skeleton_enemy;


    public static void loadAsset() {
        ATTACK_1 =
            new TextureRegion(
                new Texture("assets/img/ATTACK 1.png")
            );

        ATTACK_2 =
            new TextureRegion(
                new Texture("assets/img/ATTACK 2.png")
            );

        ATTACK_3 =
            new TextureRegion(
                new Texture("assets/img/ATTACK 3.png")
            );

        DEATH =
            new TextureRegion(
                new Texture("assets/img/DEATH.png")
            );

        DEFEND =
            new TextureRegion(
                new Texture("assets/img/DEFEND.png")
            );

        HURT =
            new TextureRegion(
                new Texture("assets/img/HURT.png")
            );

        IDLE =
            new TextureRegion(
                new Texture("assets/img/IDLE.png")
            );

        JUMP =
            new TextureRegion(
                new Texture("assets/img/JUMP.png")
            );

        RUN =
            new TextureRegion(
                new Texture("assets/img/RUN.png")
            );

        platformPack_tilesheet_walls_2 =
            new TextureRegion(
                new Texture(
                    "assets/img/platformPack_tilesheet_walls (2).png"
                )
            );

        Purple_Nebula_07_1024x1024 =
            new TextureRegion(
                new Texture(
                    "assets/img/Purple_Nebula_07-1024x1024.png"
                )
            );

        Skeleton_enemy =
            new TextureRegion(
                new Texture(
                    "assets/img/Skeleton enemy.png"
                )
            );
    }

    public static void KnightInit() {
        KnightHurtSprite = new Sprite(HURT, 4);
        KnightMoveSprite = new Sprite(RUN, 4);
        KnightAttackSprite = new Sprite(ATTACK_1, 4);
        KnightIdleSprite = new Sprite(IDLE, 4);
        KnightJumpSprite = new Sprite(JUMP, 4);
    }

    public static void SkeletonsInit(int numbers) {
        SkeletonAttackSprite = new ArrayList<>();
        SkeletonHurtSprite = new ArrayList<>();
        SkeletonIdleSprite = new ArrayList<>();
        SkeletonMoveSprite = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            SkeletonAttackSprite.add(new Sprite(Skeleton_enemy, 4, new Rectangle(5, 5, 5, 5)));
            SkeletonMoveSprite.add(new Sprite(Skeleton_enemy, 4, new Rectangle(5, 5, 5, 5)));
            SkeletonIdleSprite.add(new Sprite(Skeleton_enemy, 4,  new Rectangle(5, 5, 5, 5)));
            SkeletonMoveSprite.add(new Sprite(Skeleton_enemy, 4,  new Rectangle(5, 5, 5, 5)));
        }
    }

    public static void BlockInit() {
        BlockSprite = new Sprite(platformPack_tilesheet_walls_2, 4, new Rectangle(5,5,5,5));
    }
}
