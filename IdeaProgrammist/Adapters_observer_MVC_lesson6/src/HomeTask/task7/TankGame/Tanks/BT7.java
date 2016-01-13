package HomeTask.task7.TankGame.Tanks;

import HomeTask.task7.TankGame.ObjectsOnField.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BT7 extends AbstractTank {
	
	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
//		movePath = 2;
        setImage();
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
//		movePath = 2;
        setImage();
	}

    private void setImage() {
         images = new Image[4];
        try {
            images[0] = ImageIO.read(new File("BT7_UP.png").getAbsoluteFile());
            images[1] = ImageIO.read(new File("BT7_DOWN.png").getAbsoluteFile());
            images[2] = ImageIO.read(new File("BT7_LEFT.png").getAbsoluteFile());
            images[3] = ImageIO.read(new File("BT7_RIGHT.png").getAbsoluteFile());
        }catch (IOException e) {
            throw new IllegalStateException("Can`t find tank image");
        }
    }
//    private Object[] actions = new Object[] {
//            Direction.LEFT,
//            Action.FIRE,
//            Action.MOVE,
//            Action.FIRE,
//            Action.MOVE,
//            Action.FIRE,
//            Action.MOVE,
//            Action.MOVE,
//            Direction.DOWN,
//            Action.FIRE,
//            Action.FIRE,
//            Action.FIRE
//    };
//    private int idx = 0;
//
//
//	@Override
	public Action setUp() {
//        if(idx >= actions.length) {
//        idx = 0;
//    }
//        if (!(actions[idx] instanceof Action)) {
//            turn((Direction) actions[idx++]);
//        }

		return getAction();
    }
}
