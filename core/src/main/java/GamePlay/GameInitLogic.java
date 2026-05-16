package GamePlay;

import GameLogic.Block;
import GameLogic.Knight;
import GameLogic.Skeleton;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameInitLogic {
    public Knight KnightInit() {
        return new Knight(0,0, 32, 32, 10, 10);
    }

    public Skeleton SkeletonInit(Rectangle rect) {
        return new Skeleton(rect.x, rect.y, rect.getHeight(), rect.getWidth(), 5, 5);
    }

    public List<Skeleton> SkeletonsInit(List<Rectangle> rects) {
        List<Skeleton> list = new ArrayList<>();
        for (int i = 0; i < rects.size(); i++) {
            list.add(SkeletonInit(rects.get(i)));
        }
        return list;
    }

    public Block BlockInit(Rectangle rect) {
        return new Block(rect.x, rect.y, rect.getHeight(), rect.getWidth());
    }

    public List<Block> BlocksInit(List<Rectangle> rects) {
        List<Block> list = new ArrayList<>();
        for (int i = 0; i < rects.size(); i++) {
            list.add(BlockInit(rects.get(i)));
        }
        return list;
    }
}
